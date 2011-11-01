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

package org.jannocessor.processor;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;

import org.jannocessor.JannocessorException;
import org.jannocessor.adapter.SourceHolder;
import org.jannocessor.context.Config;
import org.jannocessor.context.Configuration;
import org.jannocessor.context.RenderRegister;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.engine.impl.ProcessorModule;
import org.jannocessor.inject.ImportsServiceModule;
import org.jannocessor.inject.RulesServiceModule;
import org.jannocessor.processor.context.Problem;
import org.jannocessor.processor.context.Problems;
import org.jannocessor.processor.context.ProcessorsConfiguration;
import org.jannocessor.service.configuration.ConfigurationServiceModule;
import org.jannocessor.service.io.IOServiceModule;
import org.jannocessor.service.render.TemplateServiceModule;
import org.jannocessor.service.representation.RepresentationServiceModule;
import org.jannocessor.service.splitter.SplitterServiceModule;
import org.jannocessor.util.logging.JannocessorLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class JannocessorProcessorBase extends AbstractProcessor {

	protected Logger logger = LoggerFactory.getLogger("JANNOCESSOR");

	protected boolean valid = true;
	protected Elements elementUtils;
	protected Types typeUtils;
	protected Filer filer;
	private Configuration options;
	protected Map<String, String> files = new HashMap<String, String>();
	protected List<String> contents = new ArrayList<String>();
	protected Problems problems = new Problems();
	protected JannocessorEngine engine;
	protected RenderRegister renderRegister;
	private Messager messager;
	private String projectPath;

	private List<String> globalErrors = new ArrayList<String>();
	private List<String> globalWarnings = new ArrayList<String>();

	private Injector injector;

	protected ProcessorsConfiguration processorsConfig;

	public JannocessorProcessorBase() {
		logger.info("Instantiated Jannocessor");
	}

	private Injector createInjector() {
		return Guice.createInjector(new ProcessorModule(options), new ConfigurationServiceModule(),
				new ImportsServiceModule(), new IOServiceModule(), new RulesServiceModule(),
				new TemplateServiceModule(), new SplitterServiceModule(),
				new RepresentationServiceModule());
	}

	protected void logException(JannocessorException e) {
		String msg = "";

		Throwable error = e;
		while (error != null) {
			String cls = error.getClass().getSimpleName();
			if (error instanceof JannocessorException) {
				msg += error.getMessage();
			} else if (error.getMessage() != null) {
				msg += cls + " (" + error.getMessage() + ")";
			} else {
				msg += cls;
			}

			error = error.getCause();
			if (error != null) {
				msg += "\n";
			}
		}

		addGlobalError(msg);

		logger.error(msg);
	}

	protected void addGlobalError(String msg) {
		globalErrors.add(msg);
	}

	protected void addGlobalWarning(String msg) {
		globalWarnings.add(msg);
	}

	@Override
	public synchronized void init(ProcessingEnvironment env) {
		super.init(env);
		try {
			messager = env.getMessager();
			JannocessorLogger.messager = messager;

			elementUtils = env.getElementUtils();
			typeUtils = env.getTypeUtils();
			filer = env.getFiler();
			options = new Config(env.getOptions());
			injector = createInjector();

			processOptions();

			logger.info("Initializing services...");

			engine = injector.getInstance(JannocessorEngine.class);
			engine.configure(engine.getTemplatesPath(), true);

			processorsConfig = new ProcessorsConfiguration(engine.getProcessorsConfiguration());

			showConfiguration();

			logger.info("Initialization finished.");
		} catch (Exception e) {
			logger.error("Initialization failed!");
			valid = false;
			throw new RuntimeException(e);
		}
	}

	private void showConfiguration() throws JannocessorException {
		logger.info("Project path: {}", getProjectPath());
		logger.info("Templates path: {}", engine.getTemplatesPath());
	}

	private void processOptions() throws JannocessorException {
		logger.info("Options:");
		Set<Entry<String, String>> entries = options.getAllProperties().entrySet();
		for (Entry<String, String> entry : entries) {
			logger.info("- Option: {} = '{}'", entry.getKey(), entry.getValue());
			processOption(entry.getKey(), entry.getValue());
		}
	}

	protected void processOption(String key, String value) {

	}

	@Override
	public Set<String> getSupportedAnnotationTypes() {
		if (valid) {
			logger.info("Specifying supported annotations...");
			try {
				return retrieveSupportedAnnotations();
			} catch (Exception e) {
				logger.error("Cannot specify supported annotations", e);
				throw new RuntimeException(e);
			}
		} else {
			return Collections.emptySet();
		}
	}

	protected abstract Set<String> retrieveSupportedAnnotations() throws JannocessorException;

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
		logger.info("Entering annotation processor...");
		if (valid) {
			if (!env.processingOver()) {
				logger.info("Processing resources...");
				try {
					processAnnotations(annotations, env);
					logger.info("Successfully finished processing.");
				} catch (JannocessorException e) {
					logException(e);
				} catch (Exception e) {
					throw new RuntimeException("Unexpected error occured", e);
				}
				processProblems(env);
			} else {
				logger.info("Last round, processing is done.");
			}
			return true;
		} else {
			logger.error("Canceled processing, due to error.");
			return false;
		}

	}

	private void processProblems(RoundEnvironment env) {
		for (Problem error : problems.getErrors()) {
			if (error.getElement() instanceof SourceHolder) {
				SourceHolder sourceHolder = (SourceHolder) error.getElement();
				error(error.getMessage(), sourceHolder.retrieveSourceElement());
			} else {
				throw new IllegalStateException("Expected source holder");
			}
		}

		for (Problem warning : problems.getWarnings()) {
			if (warning.getElement() instanceof SourceHolder) {
				SourceHolder sourceHolder = (SourceHolder) warning.getElement();
				warning(warning.getMessage(), sourceHolder.retrieveSourceElement());
			} else {
				throw new IllegalStateException("Expected source holder");
			}
		}

		Set<? extends Element> roots = env.getRootElements();
		for (Element rootElement : roots) {
			for (String globalError : globalErrors) {
				error(globalError, rootElement);
			}
			for (String globalWarning : globalWarnings) {
				warning(globalWarning, rootElement);
			}
		}
	}

	protected void writeToFile(Location location, String pkg, String filename, String text)
			throws JannocessorException {
		String info = fileInfo(location, pkg, filename);
		logger.debug("Writing text ({} characters) to file: {}", text.length(), info);

		FileObject fileRes;
		Writer writer = null;

		try {
			fileRes = filer.createResource(location, pkg, filename);
			writer = fileRes.openWriter();
			writer.write(text);
		} catch (IOException e) {
			throw new JannocessorException("Couldn't write to file: " + info, e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					throw new JannocessorException("Couldn't close file: " + info, e);
				}
			}
		}
	}

	protected abstract void processAnnotations(Set<? extends TypeElement> annotations,
			RoundEnvironment env) throws JannocessorException;

	protected String fileInfo(Location location, String pkg, String filename) {
		return String.format("%s/%s", pkg, filename);
	}

	protected void error(String msg, Element element) {
		messager.printMessage(Diagnostic.Kind.ERROR, msg, element);
	}

	protected void warning(String msg, Element element) {
		messager.printMessage(Diagnostic.Kind.WARNING, msg, element);
	}

	protected String getProjectPath() {
		if (projectPath == null) {
			String path;
			try {
				FileObject file = filer.createResource(StandardLocation.SOURCE_OUTPUT, "",
						"foo.bar");
				path = file.toUri().getPath();
			} catch (Exception e1) {
				throw new RuntimeException("Cannot calculate project path!", e1);
			}

			projectPath = extractProjectPath(path);
		}

		return projectPath;
	}

	private String extractProjectPath(String path) {
		int pos = path.indexOf("src");

		if (pos < 0) {
			pos = path.indexOf("target");
		}

		if (pos < 0) {
			throw new RuntimeException("Cannot find 'src' or 'target' folder on path: " + path);
		}

		String result = path.substring(0, pos);

		if (result.startsWith("/")) {
			result = result.substring(1);
		}

		return result;
	}

}