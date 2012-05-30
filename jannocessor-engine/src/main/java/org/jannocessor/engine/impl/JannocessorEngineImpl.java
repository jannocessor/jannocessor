/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.engine.impl;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.jannocessor.JannocessorException;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.service.api.MultiContentSplitter;
import org.jannocessor.service.api.TemplateRenderer;

public class JannocessorEngineImpl implements JannocessorEngine {

	private final Configurator config;
	private final TemplateRenderer generator;
	private final MultiContentSplitter splitter;
	private final JavaRepresenter representer;

	@Inject
	public JannocessorEngineImpl(Configurator config,
			TemplateRenderer generator,
			MultiContentSplitter splitter,
			JavaRepresenter representer) {
		this.config = config;
		this.generator = generator;
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

	public Class<?> getProcessorsConfiguration() throws JannocessorException {
		return config.getProcessorsConfiguration();
	}

	public String getAnnotationLabel(String annotation)
			throws JannocessorException {
		return config.getAnnotationLabel(annotation);
	}

	@Override
	public void configure(String templatesPath, boolean debugMode)
			throws JannocessorException {
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
