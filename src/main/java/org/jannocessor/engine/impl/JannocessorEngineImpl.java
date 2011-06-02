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

package org.jannocessor.engine.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jannocessor.engine.EngineInput;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.service.api.Configuratîr;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.service.api.TextRenderer;
import org.jannocessor.service.configuration.ConfiguratorFactory;
import org.jannocessor.service.configuration.PathLocatorFactory;
import org.jannocessor.service.render.TextRenderFactory;
import org.jannocessor.service.rules.RulesFactory;

public class JannocessorEngineImpl implements JannocessorEngine {

	private final PathLocator locations;

	private final Configuratîr config;

	private final RuleExecutor rules;

	private final TextRenderer generator;

	public JannocessorEngineImpl(EngineInput params)
			throws JannocessorException {

		locations = PathLocatorFactory.createPathService(params);

		config = ConfiguratorFactory.createConfigurationService(locations);

		rules = RulesFactory.createRulesService(config, locations);

		generator = TextRenderFactory.createGeneratorService(locations);
	}

	public String getProjectPath() throws JannocessorException {
		return locations.getProjectPath();
	}

	public String getResourcesPath() throws JannocessorException {
		return locations.getResourcesPath();
	}

	public String getRulesPath() throws JannocessorException {
		return locations.getRulesPath();
	}

	public String getConfigPath() throws JannocessorException {
		return locations.getConfigPath();
	}

	public String getTemplatesPath() throws JannocessorException {
		return locations.getTemplatesPath();
	}

	public String getAnnotationConfigFilename() throws JannocessorException {
		return locations.getAnnotationConfigFilename();
	}

	public String getGeneralConfigFilename() throws JannocessorException {
		return locations.getGeneralConfigFilename();
	}

	public String getKnowledgeBaseFilename() throws JannocessorException {
		return locations.getKnowledgeBaseFilename();
	}

	public String[] getRulesFilenames() throws JannocessorException {
		return config.getRulesFilenames();
	}

	public Set<String> getSupportedAnnotations() throws JannocessorException {
		return config.getSupportedAnnotations();
	}

	public String getAnnotationLabel(String annotation)
			throws JannocessorException {
		return config.getAnnotationLabel(annotation);
	}

	public void executeRules(List<Object> facts, Map<String, Object> globals)
			throws JannocessorException {
		rules.executeRules(facts, globals);
	}

	public String renderText(String templateName, Map<String, Object> attributes)
			throws JannocessorException {
		return generator.renderText(templateName, attributes);
	}

}
