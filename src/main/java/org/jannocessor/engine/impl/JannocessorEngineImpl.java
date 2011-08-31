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

import javax.inject.Inject;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.service.api.Configuratîr;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.api.TemplateRenderer;

public class JannocessorEngineImpl implements JannocessorEngine {

	private final PathLocator locations;
	private final Configuratîr config;
	private final RuleExecutor ruleExecutor;
	private final TemplateRenderer generator;
	private final RulesGenerator rulesGenerator;

	@Inject
	public JannocessorEngineImpl(PathLocator locations, Configuratîr config,
			RuleExecutor ruleExecutor, TemplateRenderer generator,
			RulesGenerator rulesGenerator) {
		this.locations = locations;
		this.config = config;
		this.ruleExecutor = ruleExecutor;
		this.generator = generator;
		this.rulesGenerator = rulesGenerator;
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

	public void executeRules(String rules, List<Object> facts,
			Map<String, Object> globals) throws JannocessorException {
		ruleExecutor.executeRules(rules, facts, globals);
	}

	@Override
	public String render(String template, Map<String, Object> attributes)
			throws JannocessorException {
		return generator.render(template, attributes);
	}

	@Override
	public String renderFromFile(String templateName,
			Map<String, Object> attributes) throws JannocessorException {
		return generator.renderFromFile(templateName, attributes);
	}

	@Override
	public String generateRules(String[] ruleNames) throws JannocessorException {
		return rulesGenerator.generateRules(ruleNames);
	}

}
