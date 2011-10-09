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

package org.jannocessor.service.render;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.executable.ExecutableBody;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.SourceCodeRenderer;
import org.jannocessor.service.api.TemplateRenderer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultSourceCodeRenderer implements SourceCodeRenderer {

	private Logger logger = LoggerFactory.getLogger("CODE RENDERER");

	private final TemplateRenderer templateRenderer;

	private final Configurator configurator;

	private final TypeUtils typeUtils;

	public DefaultSourceCodeRenderer(TemplateRenderer templateRenderer,
			Configurator configurator, TypeUtils typeUtils) {
		this.templateRenderer = templateRenderer;
		this.configurator = configurator;
		this.typeUtils = typeUtils;
	}

	@Override
	public String render(JavaCodeModel codeModel) {
		logger.debug("Rendering element: {}", codeModel);
		SourceCode code = codeModel.getCode();
		try {
			if (code.getCode() != null) {
				return code.getCode();
			} else if (code.getTemplate() != null) {
				return renderModelByTemplate(codeModel);
			} else if (code.getTemplateName() != null) {
				return renderModelByTemplateName(codeModel);
			} else {
				return renderModelError(codeModel);
			}
		} catch (Exception e) {
			logger.error("Cannot render element: " + codeModel, e);
			return renderModelError(codeModel);
		}
	}

	@Override
	public String renderBody(ExecutableBody body) {
		logger.debug("Rendering body: {}", body);
		try {
			if (body.getCode() != null) {
				return body.getCode();
			} else if (body.getTemplate() != null) {
				return renderBodyByTemplate(body);
			} else if (body.getTemplateName() != null) {
				return renderBodyByTemplateName(body);
			} else {
				return "";
			}
		} catch (Exception e) {
			logger.error("Cannot render body: " + body, e);
			return renderBodyError(body);
		}
	}

	private String renderBodyError(ExecutableBody body) {
		return String.format("[ERROR - %s]", body);
	}

	private String renderBodyByTemplateName(ExecutableBody body)
			throws JannocessorException {
		return templateRenderer.renderFromFile(
				getTemplateFilename(body.getTemplateName()),
				getAttributes(body));
	}

	private String renderBodyByTemplate(ExecutableBody body)
			throws JannocessorException {
		return templateRenderer.render(body.getTemplate(), getAttributes(body));
	}

	private String renderModelError(JavaCodeModel codeModel) {
		return String.format("[ERROR - %s]", codeModel);
	}

	private String renderModelByTemplateName(JavaCodeModel codeModel)
			throws JannocessorException {
		return templateRenderer.renderFromFile(getTemplateFilename(codeModel
				.getCode().getTemplateName()), getAttributes(codeModel));
	}

	private String renderModelByTemplate(JavaCodeModel codeModel)
			throws JannocessorException {
		return templateRenderer.render(codeModel.getCode().getTemplate(),
				getAttributes(codeModel));
	}

	private String getTemplateFilename(String templateName)
			throws JannocessorException {
		return configurator.getTemplatesPath() + "/" + templateName + ".vm";
	}

	private Map<String, Object> getAttributes(JavaCodeModel sourceCode) {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("self", sourceCode);
		attributes.put("types", typeUtils);

		return attributes;
	}

	private Map<String, Object> getAttributes(ExecutableBody body) {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("self", body);
		attributes.put("types", typeUtils);

		return attributes;
	}

	@Override
	public String toString() {
		return "methods=[render($element),renderBody($body)]";
	}

}
