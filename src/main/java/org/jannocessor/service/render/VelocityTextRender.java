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

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.api.TextRenderer;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityTextRender implements TextRenderer, Settings {

	private Logger logger = LoggerFactory.getLogger("RENDERER");

	private final PathLocator paths;

	public VelocityTextRender(PathLocator paths) {
		this.paths = paths;
		Velocity.init();
	}

	@Override
	public String render(String template, Map<String, Object> attributes)
			throws JannocessorException {
		VelocityContext context = createContext(attributes);
		Writer writer = new StringWriter();

		Velocity.evaluate(context, writer, "RENDERER", template);

		String renderedText = writer.toString();

		logger.debug("Rendered text:\n{}", renderedText);
		return postProcess(renderedText);
	}

	@Override
	public String renderFromFile(String templateName,
			Map<String, Object> attributes) throws JannocessorException {
		try {
			String file = paths.getTemplatesPath() + "/" + templateName + ".vm";
			logger.debug("Retrieving template: {}", file);
			Template t = Velocity.getTemplate(file);

			VelocityContext context = createContext(attributes);
			Writer writer = new StringWriter();

			t.merge(context, writer);
			String renderedText = writer.toString();

			logger.debug("Rendered text:\n{}", renderedText);
			return postProcess(renderedText);
		} catch (Exception e) {
			String report = String.format("Rendering of template '%s' failed",
					templateName);
			throw new JannocessorException(report, e);
		}
	}

	private VelocityContext createContext(Map<String, Object> attributes) {
		VelocityContext context1 = new VelocityContext();

		for (Entry<String, Object> entry : attributes.entrySet()) {
			logger.debug("- Attribute {} = '{}'", entry.getKey(),
					entry.getValue());
			context1.put(entry.getKey(), entry.getValue());
		}
		return context1;
	}

	private String replacePlaceholder(String text, String placeholder,
			String replacement) {
		String pattern = Pattern.quote("(!PLACEHOLDER:" + placeholder + "!)");
		return text.replaceAll(pattern, replacement);
	}

	private String postProcess(String renderedText) {
		String replacement = "OPA";
		String text = replacePlaceholder(renderedText, "SMART_IMPORT",
				replacement);
		
		logger.debug("Post-processed text:\n{}", text);
		return text;
	}

}
