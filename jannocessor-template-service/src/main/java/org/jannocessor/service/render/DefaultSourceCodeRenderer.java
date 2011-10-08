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

import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.code.JavaCodeModel;
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

	public DefaultSourceCodeRenderer(TemplateRenderer templateRenderer,
			Configurator configurator) {
		this.templateRenderer = templateRenderer;
		this.configurator = configurator;
	}

	@Override
	public String render(JavaCodeModel codeModel) {
		SourceCode code = codeModel.getCode();
		try {
			if (code.getCode() != null) {
				return code.getCode();
			} else if (code.getTemplate() != null) {
				return templateRenderer.render(code.getTemplate(),
						getAttributes(codeModel));
			} else if (code.getTemplateName() != null) {
				return templateRenderer.renderFromFile(
						configurator.getTemplatesPath() + "/"
								+ code.getTemplateName() + ".vm",
						getAttributes(codeModel));
			} else {
				return "ERROR (" + codeModel + ")";
			}
		} catch (JannocessorException e) {
			logger.error("Cannot render element: " + codeModel, e);
			return "ERROR (" + codeModel + ")";
		}
	}

	private Map<String, Object> getAttributes(JavaCodeModel sourceCode) {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("self", sourceCode);

		return attributes;
	}

	@Override
	public String toString() {
		return "methods=[render($element)]";
	}

}
