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
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.imports.ImportOrganizerImpl;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityTemplateRenderer implements TemplateRenderer, Settings,
		RuntimeConstants {

	private static final String RESOURCE_LOADER_CLASS = "file.resource.loader.class";

	private Logger logger = LoggerFactory.getLogger("RENDERER");

	private final Configurator configurator;

	private final VelocityEngine engine;

	private boolean configured = false;

	@Inject
	public VelocityTemplateRenderer(Configurator configurator) {
		this.configurator = configurator;
		this.engine = new VelocityEngine();
	}

	@Override
	public void configure(String templatesPath, boolean debugMode) {
		Properties velocityConfig = new Properties();

		if (templatesPath != null) {
			velocityConfig.setProperty(RESOURCE_LOADER_CLASS,
					FileResourceLoader.class.getCanonicalName());
			velocityConfig
					.setProperty(FILE_RESOURCE_LOADER_PATH, templatesPath);
		} else {
			velocityConfig.setProperty(RESOURCE_LOADER_CLASS,
					ClasspathResourceLoader.class.getCanonicalName());
		}

		velocityConfig.setProperty(VM_PERM_INLINE_LOCAL, "true");
		velocityConfig.setProperty(VM_CONTEXT_LOCALSCOPE, "true");

		if (debugMode) {
			velocityConfig.setProperty(VM_LIBRARY_AUTORELOAD, "true");
			velocityConfig.setProperty(FILE_RESOURCE_LOADER_CACHE, "false");
		} else {
			velocityConfig.setProperty(VM_LIBRARY_AUTORELOAD, "false");
			velocityConfig.setProperty(FILE_RESOURCE_LOADER_CACHE, "true");
		}

		engine.init(velocityConfig);

		engine.setApplicationAttribute("logger", logger);

		configured = true;
	}

	@Override
	public String render(String template, Map<String, Object> attributes)
			throws JannocessorException {
		checkWasConfigured();

		VelocityContext context = createContext(attributes);

		TypeUtils typeUtils = getTypeUtils(attributes, context);
		context.put("renderer", createRenderUtils(typeUtils, context));

		Writer writer = new StringWriter();
		engine.evaluate(context, writer, '"' + template + '"', template);
		String renderedText = writer.toString();

		return postProcess(renderedText, typeUtils);
	}

	@Override
	public String renderFromFile(String templateFilename,
			Map<String, Object> attributes) throws JannocessorException {
		checkWasConfigured();

		try {
			logger.info("Retrieving template: {}", templateFilename);

			VelocityContext context = createContext(attributes);

			TypeUtils typeUtils = getTypeUtils(attributes, context);
			context.put("renderer", createRenderUtils(typeUtils, context));

			Writer writer = new StringWriter();

			File file = new File(templateFilename);
			if (file.exists()) {
				Reader reader = new FileReader(file);
				engine.evaluate(context, writer, templateFilename, reader);
			} else {
				Template t = engine.getTemplate(templateFilename);
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

	@Override
	public String renderMacro(String macro, Map<String, Object> attributes,
			String[] params) throws JannocessorException {
		checkWasConfigured();

		VelocityContext context = createContext(attributes);

		TypeUtils typeUtils = getTypeUtils(attributes, context);
		context.put("renderer", createRenderUtils(typeUtils, context));

		Writer writer = new StringWriter();
		String logTag = "\"#" + macro + '"';
		engine.invokeVelocimacro(macro, logTag, params, context, writer);
		String renderedText = writer.toString();

		return postProcess(renderedText, typeUtils);
	}

	private TypeUtils getTypeUtils(Map<String, Object> attributes,
			VelocityContext context) {
		TypeUtils typeUtils = (TypeUtils) attributes.get("types");
		if (typeUtils == null) {
			typeUtils = createTypeUtils();
			context.put("types", typeUtils);
		}
		return typeUtils;
	}

	private void checkWasConfigured() {
		if (!configured) {
			throw new IllegalStateException(
					"The template renderer is not configured!");
		}
	}

	private DefaultSourceCodeRenderer createRenderUtils(TypeUtils typeUtils,
			VelocityContext context) {
		logger.debug("Creating renderer...");
		return new DefaultSourceCodeRenderer(this, configurator, typeUtils,
				context);
	}

	private TypeUtils createTypeUtils() {
		return new TypeUtils(new ImportOrganizerImpl());
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
