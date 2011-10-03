/**
 * Copyright 2011 jannocessor.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.service.rules;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderConfiguration;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.drools.io.impl.ByteArrayResource;
import org.drools.io.internal.InternalResource;
import org.drools.runtime.StatelessKnowledgeSession;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleExecutorImpl implements RuleExecutor, Settings {

	private Logger logger = LoggerFactory.getLogger("RULES");

	private final Configurator config;

	@Inject
	public RuleExecutorImpl(Configurator config) {
		this.config = config;
	}

	public final void executeRules(String rules, List<Object> facts,
			Map<String, Object> globals) throws JannocessorException {
		logger.info("Executing rules...");

		try {
			execute(rules, facts, globals);
		} catch (Exception e) {
			e.printStackTrace();
			throw new JannocessorException("Rules execution failed", e);
		}

		logger.info("Finished rules execution.");

	}

	private final void execute(String rules, List<?> facts,
			Map<String, Object> globals) throws Exception {
		logger.info("Initializing rules...");

		// String[] files = config.getRulesFilenames();
		// String path = config.getRulesPath();
		// List<Resource> resources = loadResources(path, files, "drl");

		List<Resource> resources = createInMemoryResources(rules);

		KnowledgeBase kbase;
		if (true) { // isRecompilationRequired(resources)
			logger.info("Compiling rules...");
			kbase = createKnowledgeBase(resources);

			// logger.info("Saving rules...");
			// saveKnowledgeBase(kbase);
		} else {
			logger.info("Loading pre-compiled rules...");
			kbase = loadKnowledgeBase();
		}

		logger.info("Creating new session");

		StatelessKnowledgeSession session = kbase
				.newStatelessKnowledgeSession();

		// KnowledgeRuntimeLoggerFactory.newConsoleLogger(session);

		logger.info("Setting session globals");

		for (Entry<String, Object> entry : globals.entrySet()) {
			session.setGlobal(entry.getKey(), entry.getValue());
		}

		logger.info("Running the rules...");

		session.execute(facts);

		logger.info("Rules execution finished.");
	}

	private List<Resource> createInMemoryResources(String content) {
		List<Resource> resources = new ArrayList<Resource>();

		Resource resource = new ByteArrayResource(content.getBytes());
		resources.add(resource);

		return resources;
	}

	private final boolean isRecompilationRequired(List<Resource> resources)
			throws IOException, JannocessorException {
		long latestModifiedOn = getLatestModificationOn(resources);
		long compiledOn = getLastCompiledOn();

		boolean recompilationRequired = compiledOn < latestModifiedOn;

		recompilationRequired = true; // FIXME: temporary hack

		logger.info("Compilation required: {}", recompilationRequired);
		return recompilationRequired;
	}

	private final long getLastCompiledOn() throws JannocessorException {
		File file = new File(config.getKnowledgeBaseFilename());
		if (file.exists()) {
			logger.info("Found file: {}", file.getAbsolutePath());
			return file.lastModified();
		} else {
			logger.info("Didn't find file: {}", file.getAbsolutePath());
			return 0;
		}
	}

	private final List<Resource> loadResources(String path, String[] names,
			String ext) {
		logger.info("Loading resources...");
		List<Resource> resources = new ArrayList<Resource>();
		for (String name : names) {
			String fileName = path + "/" + name + "." + ext;
			logger.info("- Loading resource: {}", fileName);
			Resource resource = ResourceFactory.newClassPathResource(fileName);
			resources.add(resource);
		}
		logger.info("Finished loading resources.");
		return resources;
	}

	private final long getLatestModificationOn(List<Resource> resources)
			throws IOException {
		long latestModif = 0;

		for (Resource resource : resources) {
			if (resource instanceof InternalResource) {
				InternalResource internalResource = (InternalResource) resource;
				long lastModif = internalResource.getLastModified();

				// max = the latest modification date
				latestModif = Math.max(latestModif, lastModif);
			} else {
				logger.warn("Unexpected resource type: {}", resource.getClass());
				return Integer.MAX_VALUE;
			}
		}

		return latestModif;
	}

	private final KnowledgeBase createKnowledgeBase(List<Resource> resources) {

		KnowledgeBuilderConfiguration config = KnowledgeBuilderFactory
				.newKnowledgeBuilderConfiguration();

		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder(config);

		for (Resource resource : resources) {
			logger.info("Compiling rules: {}", resource);
			kbuilder.add(resource, ResourceType.DRL);
		}

		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
			for (KnowledgeBuilderError error : errors) {
				String msg = "Line " + error.getErrorLines() + " - "
						+ error.getMessage();
				logger.error(msg);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();

		return kbase;
	}

	private final KnowledgeBase loadKnowledgeBase() throws Exception {
		KnowledgeBase kbase;
		ObjectInputStream in = null;
		boolean hasError = false;
		try {
			in = new ObjectInputStream(new FileInputStream(
					config.getKnowledgeBaseFilename()));
			kbase = (KnowledgeBase) in.readObject();
		} catch (Exception e) {
			logger.error("Cannot load pre-compiled rules!");
			hasError = true;
			throw new JannocessorException("Cannot load pre-compiled rules!", e);
		} finally {
			if (in != null) {
				in.close();
				if (hasError) {
					deleteKnowledgeBase();
				}
			}
		}

		return kbase;

	}

	@SuppressWarnings("unused")
	private final void saveKnowledgeBase(KnowledgeBase kbase) throws Exception {
		ObjectOutputStream out = null;
		try {
			out = new ObjectOutputStream(new FileOutputStream(
					config.getKnowledgeBaseFilename()));
			out.writeObject(kbase);
		} catch (Exception e) {
			logger.error("Cannot save compiled rules!");
			throw new JannocessorException("Cannot write compiled rules!", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	private final void deleteKnowledgeBase() throws JannocessorException {
		String filename = config.getKnowledgeBaseFilename();
		File file = new File(filename);
		if (file.delete()) {
			logger.info("Deleted file: {}", filename);
		} else {
			logger.warn("Couldn't delete file: {}", filename);
		}
	}

}
