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
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
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
import org.jannocessor.JannocessorException;
import org.jannocessor.collection.Power;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.util.Enums;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Interfaces;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.NestedAnnotations;
import org.jannocessor.model.util.NestedClasses;
import org.jannocessor.model.util.NestedEnums;
import org.jannocessor.model.util.NestedInterfaces;
import org.jannocessor.model.util.New;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.imports.ImportOrganizerImpl;
import org.jannocessor.util.Settings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class VelocityTemplateRenderer implements TemplateRenderer, Settings,
		RuntimeConstants {

	private static final String RESOURCE_LOADER_CLASS = "file.resource.loader.class";

	private Logger logger = LoggerFactory.getLogger("RENDERER");

	private final VelocityEngine engine;

	private boolean configured = false;

	private final JavaRepresenter representer;

	@Inject
	public VelocityTemplateRenderer(Configurator configurator,
			JavaRepresenter representer) {
		this.representer = representer;
		this.engine = new VelocityEngine();
	}

	@Override
	public void configure(String templatesPath, boolean debugMode)
			throws JannocessorException {
		try {
			Properties velocityConfig = new Properties();

			if (templatesPath != null) {
				velocityConfig.setProperty(RESOURCE_LOADER_CLASS,
						FileResourceLoader.class.getCanonicalName());
				velocityConfig.setProperty(FILE_RESOURCE_LOADER_PATH,
						templatesPath);
			} else {
				velocityConfig.setProperty(RESOURCE_LOADER_CLASS,
						ClasspathResourceLoader.class.getCanonicalName());
			}

			velocityConfig.setProperty(VM_MAX_DEPTH, "1000");
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

			configured = true;
		} catch (Exception e) {
			throw new JannocessorException(
					"Exception occured while configuring the template renderer",
					e);
		}
	}

	@Override
	public String render(String template, Map<String, Object> attributes)
			throws JannocessorException {
		checkWasConfigured();

		VelocityContext context = createContext(attributes);

		TypeUtils typeUtils = createTypeUtils();
		context.put("types", typeUtils);

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

			TypeUtils typeUtils = createTypeUtils();
			context.put("types", typeUtils);

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

		TypeUtils typeUtils = createTypeUtils();
		context.put("types", typeUtils);

		Writer writer = new StringWriter();
		String logTag = "\"#" + macro + '"';
		engine.invokeVelocimacro(macro, logTag, params, context, writer);
		String renderedText = writer.toString();

		return postProcess(renderedText, typeUtils);
	}

	private void checkWasConfigured() {
		if (!configured) {
			throw new IllegalStateException(
					"The template renderer is not configured!");
		}
	}

	private TypeUtils createTypeUtils() {
		return new TypeUtils(new ImportOrganizerImpl());
	}

	private VelocityContext createContext(Map<String, Object> attributes) {
		VelocityContext context = new VelocityContext();

		addModifiersToContext(context);

		context.put("logger", logger);
		context.put("representer", representer);
		context.put("helper", new TemplateHelper(context));

		for (Entry<String, Object> entry : attributes.entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}

		VelocityEventHandler eventHandler = new VelocityEventHandler();
		eventHandler.listenToContext(context);

		return context;
	}

	private void addModifiersToContext(VelocityContext context) {
		context.put("Annotations", getStaticFields(Annotations.class));
		context.put("Classes", getStaticFields(Classes.class));
		context.put("Code", getStaticFields(New.class));
		context.put("Constructors", getStaticFields(Constructors.class));
		context.put("Enums", getStaticFields(Enums.class));
		context.put("Fields", getStaticFields(Fields.class));
		context.put("Interfaces", getStaticFields(Interfaces.class));
		context.put("Methods", getStaticFields(Methods.class));
		context.put("NestedAnnotations",
				getStaticFields(NestedAnnotations.class));
		context.put("NestedClasses", getStaticFields(NestedClasses.class));
		context.put("NestedEnums", getStaticFields(NestedEnums.class));
		context.put("NestedInterfaces", getStaticFields(NestedInterfaces.class));
	}

	private Map<String, Object> getStaticFields(Class<?> clazz) {
		Map<String, Object> map = Power.map();

		for (Field field : clazz.getFields()) {
			if (Modifier.isStatic(field.getModifiers())) {
				try {
					map.put(field.getName(), field.get(null));
				} catch (Exception e) {
					logger.error("Cannot access field: " + field.getName(), e);
				}
			}
		}

		return map;
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
