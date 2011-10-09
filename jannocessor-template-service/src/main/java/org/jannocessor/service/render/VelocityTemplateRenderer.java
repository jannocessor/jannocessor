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

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.imports.ImportOrganizerImpl;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityTemplateRenderer implements TemplateRenderer, Settings {

	private static final String RESOURCE_LOADER_CLASS = "file.resource.loader.class";

	private static final String CLASSPATH_RESOURCE_LOADER = "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader";

	private static final String INLINE_MACRO_LOCAL_SCOPE = "velocimacro.permissions.allow.inline.local.scope";

	private Logger logger = LoggerFactory.getLogger("RENDERER");

	private final Configurator configurator;

	@Inject
	public VelocityTemplateRenderer(Configurator configurator) {
		this.configurator = configurator;

		Properties velocityConfig = new Properties();
		velocityConfig.setProperty(RESOURCE_LOADER_CLASS,
				CLASSPATH_RESOURCE_LOADER);
		velocityConfig.setProperty(INLINE_MACRO_LOCAL_SCOPE, "true");

		Velocity.init(velocityConfig);
	}

	@Override
	public String render(String template, Map<String, Object> attributes)
			throws JannocessorException {
		VelocityContext context = createContext(attributes);
		Writer writer = new StringWriter();

		TypeUtils typeUtils = (TypeUtils) attributes.get("types");
		if (typeUtils == null) {
			typeUtils = createTypeUtils();
			context.put("types", typeUtils);
		}

		DefaultSourceCodeRenderer renderUtils = createRenderUtils(typeUtils);
		context.put("renderer", renderUtils);

		Velocity.evaluate(context, writer, '"' + template + '"', template);

		String renderedText = writer.toString();

		return postProcess(renderedText, typeUtils);
	}

	private DefaultSourceCodeRenderer createRenderUtils(TypeUtils typeUtils) {
		logger.debug("Creating renderer...");
		return new DefaultSourceCodeRenderer(this, configurator, typeUtils);
	}

	private TypeUtils createTypeUtils() {
		return new TypeUtils(new ImportOrganizerImpl());
	}

	@Override
	public String renderFromFile(String templateFilename,
			Map<String, Object> attributes) throws JannocessorException {
		try {
			logger.info("Retrieving template: {}", templateFilename);

			VelocityContext context = createContext(attributes);

			TypeUtils typeUtils = (TypeUtils) attributes.get("types");
			if (typeUtils == null) {
				typeUtils = createTypeUtils();
				context.put("types", typeUtils);
			}

			DefaultSourceCodeRenderer renderUtils = createRenderUtils(typeUtils);
			context.put("renderer", renderUtils);

			Writer writer = new StringWriter();

			File file = new File(templateFilename);
			if (file.exists()) {
				Reader reader = new FileReader(file);
				Velocity.evaluate(context, writer, templateFilename, reader);
			} else {
				Template t = Velocity.getTemplate(templateFilename);
				t.merge(context, writer);
			}
			String renderedText = writer.toString();

			return postProcess(renderedText, typeUtils);
		} catch (Exception e) {
			String report = String.format("Rendering of template '%s' failed",
					templateFilename);
			throw new JannocessorException(report, e);
		}
	}

	private VelocityContext createContext(Map<String, Object> attributes) {
		VelocityContext context = new VelocityContext();

		for (Entry<String, Object> entry : attributes.entrySet()) {
			logger.debug("- Attribute {} = '{}'", entry.getKey(),
					entry.getValue());
			context.put(entry.getKey(), entry.getValue());
		}

		VelocityEventHandler eventHandler = new VelocityEventHandler();
		eventHandler.listenToContext(context);

		return context;
	}

	private String replacePlaceholder(String text, String placeholder,
			String replacement) {
		String pattern = Pattern.quote("(!PLACEHOLDER:" + placeholder + "!)");
		return text.replaceAll(pattern, replacement);
	}

	private String postProcess(String renderedText, TypeUtils typeUtils) {
		String text = postProcessImports(renderedText,
				typeUtils.getTypeImports());

		return text;
	}

	private String postProcessImports(String renderedText, List<String> imports) {
		StringBuilder sb = new StringBuilder();
		for (String typeImport : imports) {
			sb.append("import ");
			sb.append(typeImport);
			sb.append(";\n");
		}
		String replacement = sb.toString();

		String text = replacePlaceholder(renderedText, "SMART_IMPORT",
				replacement);
		return text;
	}

}
