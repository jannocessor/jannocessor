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

package org.jannocessor.processor;

import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import org.jannocessor.engine.EngineInput;
import org.jannocessor.model.Config;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.configuration.EngineInputImpl;
import org.jannocessor.service.configuration.PathLocatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
@SupportedAnnotationTypes("*")
public class JannocessorProcessor extends JannocessorProcessorBase {

	private final Logger logger = LoggerFactory.getLogger("Jannocessor");

	private Config options;

	private PathLocator locations;

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		super.init(env);
		options = new Config(env.getOptions());
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		logger.info("Processing annotation...");

		try {
			logger.info("Initializing services...");

			processOptions();

			makeContract();

			showConfiguration();

			logger.info("Initialization finished.");
		} catch (JannocessorException e) {
			throw new RuntimeException(e);
		}

		return false;
	}

	private void makeContract() throws JannocessorException {
		EngineInput input = new EngineInputImpl(options);
		locations = PathLocatorFactory.createPathService(input);
	}

	private void showConfiguration() throws JannocessorException {
		logger.info("Project path: {}", locations.getProjectPath());
		logger.info("Resources path: {}", locations.getResourcesPath());
		logger.info("Config path: {}", locations.getConfigPath());
		logger.info("Rules path: {}", locations.getRulesPath());
		logger.info("Templates path: {}", locations.getTemplatesPath());
	}

	private void processOptions() throws JannocessorException {
		logger.info("Options:");
		Set<Entry<String, String>> entries = options.getAllProperties()
				.entrySet();
		for (Entry<String, String> entry : entries) {
			logger.debug("- Option: {} = '{}'", entry.getKey(),
					entry.getValue());
		}
	}

}
