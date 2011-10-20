/**
 * Copyright 2011 Nikolche Mihajlovski
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

package org.jannocessor.service.configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.jannocessor.processor.model.Config;
import org.jannocessor.processor.model.Configuration;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JannocessorInput;
import org.jannocessor.util.Settings;

public class ConfiguratorImpl implements Configurator, Settings {

	private Configuration general;

	private Configuration annotations;

	private Configuration processors;

	private final ConfigLoader loader;

	private final JannocessorInput input;

	@Inject
	public ConfiguratorImpl(JannocessorInput input, ConfigLoader loader)
			throws JannocessorException {
		this.input = input;
		this.loader = loader;
		initialize();
	}

	private void initialize() throws JannocessorException {
		String generalFilename = getGeneralConfigFilename();
		general = new Config(loader.loadProperties(generalFilename));

		String annotationsFilename = getAnnotationConfigFilename();
		annotations = new Config(loader.loadProperties(annotationsFilename));

		String processorsFilename = getProcessorsConfigFilename();
		processors = new Config(loader.loadProperties(processorsFilename));

	}

	@Override
	public final String[] getRulesFilenames() throws JannocessorException {
		return general.getMandatoryValues("rules");
	}

	@Override
	public Set<String> getSupportedAnnotations() throws JannocessorException {
		return new HashSet<String>(annotations.getAllProperties().values());
	}

	@Override
	public String getAnnotationLabel(String annotation)
			throws JannocessorException {
		Set<Entry<String, String>> properties = annotations.getAllProperties()
				.entrySet();

		for (Entry<String, String> entry : properties) {
			if (entry.getValue().equals(annotation)) {
				return entry.getKey();
			}
		}

		throw new JannocessorException("Cannot find name of annotation: "
				+ annotation);
	}

	@Override
	public String[] getProcessedRules() throws JannocessorException {
		Collection<String> rules = processors.getAllProperties().keySet();
		return rules.toArray(new String[rules.size()]);
	}

	@Override
	public Map<String, String> getRulesProcessors() throws JannocessorException {
		return Collections.unmodifiableMap(processors.getAllProperties());
	}

	@Override
	public String getProfile() {
		return input.getOptions().getOptionalValue(OPTION_PROFILE, null);
	}

	@Override
	public String getTemplatesPath() throws JannocessorException {
		return input.getOptions().getOptionalValue(OPTION_TEMPLATES_PATH,
				mergePath(getResourcesPath(), "templates"));
	}

	@Override
	public String getResourcesPath() throws JannocessorException {
		return "";
	}

	@Override
	public String getRulesPath() throws JannocessorException {
		return mergePath(getResourcesPath(), "rules");
	}

	@Override
	public String getConfigPath() throws JannocessorException {
		return mergePath(getResourcesPath(), "config");
	}

	@Override
	public String getAnnotationConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(ANNOTATIONS_PROPERTIES)
				+ ".properties");
	}

	@Override
	public String getGeneralConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(GENERAL_PROPERTIES)
				+ ".properties");
	}

	@Override
	public String getProcessorsConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(PROCESSORS_PROPERTIES)
				+ ".properties");
	}

	@Override
	public final String getKnowledgeBaseFilename() {
		return KNOWLEDGE_BASE;
	}

	private String modeName(String filename) {
		String mode = getProfile();
		if (mode != null) {
			return filename + "-" + mode;
		} else {
			return filename;
		}
	}

	private String mergePath(String part1, String part2) {
		if (part1.isEmpty() || part1.endsWith("/")) {
			return part1 + part2;
		} else {
			return part1 + "/" + part2;
		}
	}

}
