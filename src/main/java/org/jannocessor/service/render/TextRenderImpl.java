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

package org.jannocessor.service.render;

import java.util.Map;
import java.util.Map.Entry;

import javax.lang.model.element.Element;

import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.api.TextRenderer;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.stringtemplate.v4.AttributeRenderer;
import org.stringtemplate.v4.ST;
import org.stringtemplate.v4.STGroup;
import org.stringtemplate.v4.STGroupFile;

public class TextRenderImpl implements TextRenderer, Settings {

	private Logger logger = LoggerFactory.getLogger("GENERATOR");

	private final PathLocator paths;

	private AttributeRenderer elementsRenderer = new ElementRenderer();

	public TextRenderImpl(PathLocator paths) {
		this.paths = paths;
	}

	@Override
	public String renderText(String templateName, Map<String, Object> attributes)
			throws JannocessorException {
		try {
			ST tmpl = getTemplate(templateName);
			addAttributes(tmpl, attributes);
			return tmpl.render();
		} catch (Exception e) {
			String report = String.format("Rendering of template '%s' failed",
					templateName);
			throw new JannocessorException(report, e);
		}
	}

	private void addAttributes(ST tmpl, Map<String, Object> context) {
		logger.info("Adding template attributes...");
		for (Entry<String, Object> entry : context.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();

			logger.debug("- Attribute {} = '{}'", key, value);
			logger.debug("- Attribute " + key + "=" + value);
			tmpl.add(key, value);
		}
	}

	private ST getTemplate(String name) throws JannocessorException {
		String file = paths.getTemplatesPath() + "/" + name + ".stg";
		logger.info("Retrieving template: {}", file);

		STGroup group = new STGroupFile(file);
		group.registerRenderer(Element.class, elementsRenderer);

		ST tmpl = group.getInstanceOf("main");
		return tmpl;
	}

}
