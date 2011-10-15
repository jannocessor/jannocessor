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

package org.jannocessor.engine.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.service.api.MultiContentSplitter;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.api.TemplateRenderer;

public class JannocessorEngineImpl implements JannocessorEngine {

	private final Configurator config;
	private final RuleExecutor ruleExecutor;
	private final TemplateRenderer generator;
	private final RulesGenerator rulesGenerator;
	private final MultiContentSplitter splitter;
	private final JavaRepresenter representer;

	@Inject
	public JannocessorEngineImpl(Configurator config,
			RuleExecutor ruleExecutor, TemplateRenderer generator,
			RulesGenerator rulesGenerator, MultiContentSplitter splitter,
			JavaRepresenter representer) {
		this.config = config;
		this.ruleExecutor = ruleExecutor;
		this.generator = generator;
		this.rulesGenerator = rulesGenerator;
		this.splitter = splitter;
		this.representer = representer;
	}

	public String getResourcesPath() throws JannocessorException {
		return config.getResourcesPath();
	}

	public String getRulesPath() throws JannocessorException {
		return config.getRulesPath();
	}

	public String getConfigPath() throws JannocessorException {
		return config.getConfigPath();
	}

	public String getTemplatesPath() throws JannocessorException {
		return config.getTemplatesPath();
	}

	public String getAnnotationConfigFilename() throws JannocessorException {
		return config.getAnnotationConfigFilename();
	}

	public String getGeneralConfigFilename() throws JannocessorException {
		return config.getGeneralConfigFilename();
	}

	public String getKnowledgeBaseFilename() throws JannocessorException {
		return config.getKnowledgeBaseFilename();
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
	public void configure(String templatesPath, boolean debugMode) {
		generator.configure(templatesPath, debugMode);
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
	public String renderMacro(String macro, Map<String, Object> attributes,
			String[] params) throws JannocessorException {
		return generator.renderMacro(macro, attributes, params);
	}

	@Override
	public String generateRules(String[] ruleNames) throws JannocessorException {
		return rulesGenerator.generateRules(ruleNames);
	}

	@Override
	public String getProcessorsConfigFilename() throws JannocessorException {
		return config.getProcessorsConfigFilename();
	}

	@Override
	public String[] getProcessedRules() throws JannocessorException {
		return config.getProcessedRules();
	}

	@Override
	public Map<String, String> getRulesProcessors() throws JannocessorException {
		return config.getRulesProcessors();
	}

	@Override
	public String getProfile() throws JannocessorException {
		return config.getProfile();
	}

	@Override
	public Map<String, String> split(String contents) {
		return splitter.split(contents);
	}

	@Override
	public String getJavaRepresentation(Object value) {
		return representer.getJavaRepresentation(value);
	}

}
