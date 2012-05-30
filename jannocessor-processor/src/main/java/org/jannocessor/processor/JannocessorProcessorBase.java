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

package org.jannocessor.processor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.apache.commons.io.IOUtils;
import org.jannocessor.JannocessorException;
import org.jannocessor.adapter.SourceHolder;
import org.jannocessor.collection.Power;
import org.jannocessor.context.Config;
import org.jannocessor.context.Configuration;
import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.engine.impl.ProcessorModule;
import org.jannocessor.inject.ImportsServiceModule;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.FileInformation;
import org.jannocessor.processor.api.RenderRegister;
import org.jannocessor.processor.context.DefaultFileInformation;
import org.jannocessor.processor.context.GeneratedCode;
import org.jannocessor.processor.context.GeneratedFile;
import org.jannocessor.processor.context.Problem;
import org.jannocessor.processor.context.Problems;
import org.jannocessor.processor.context.ProcessorsConfiguration;
import org.jannocessor.service.configuration.ConfigurationServiceModule;
import org.jannocessor.service.io.IOServiceModule;
import org.jannocessor.service.render.TemplateServiceModule;
import org.jannocessor.service.representation.RepresentationServiceModule;
import org.jannocessor.service.splitter.SplitterServiceModule;
import org.jannocessor.util.Jannocessor;
import org.jannocessor.util.Settings;
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
	protected Map<String, GeneratedFile> files = new HashMap<String, GeneratedFile>();
	protected List<GeneratedCode> contents = new ArrayList<GeneratedCode>();
	protected Problems problems = new Problems();
	protected JannocessorEngine engine;
	protected RenderRegister renderRegister;
	private Messager messager;

	private List<String> globalErrors = new ArrayList<String>();
	private List<String> globalWarnings = new ArrayList<String>();

	private Injector injector;

	protected ProcessorsConfiguration processorsConfig;

	public JannocessorProcessorBase() {
		logger.info("Instantiated Jannocessor");
	}

	private Injector createInjector() {
		return Guice.createInjector(new ProcessorModule(options), new ConfigurationServiceModule(),
				new ImportsServiceModule(), new IOServiceModule(), new TemplateServiceModule(), 
				new SplitterServiceModule(), new RepresentationServiceModule());
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
		// overwrite the class loader set by the Maven plugin
		Thread.currentThread().setContextClassLoader(JannocessorEngine.class.getClassLoader());

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

			// recompileProcessors();

			Class<?> hotConfig = Jannocessor.reloadClass("org.jannocessor.config.Processors",
					Power.emptyList(String.class));
			processorsConfig = new ProcessorsConfiguration(hotConfig);

			showConfiguration();

			logger.info("Initialization finished.");
		} catch (Exception e) {
			logger.error("Initialization failed!");
			valid = false;
			throw new RuntimeException(e);
		}
	}

	private void showConfiguration() throws JannocessorException {
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

	protected void writeToFile(Location location, String pkg, String filename, String text,
			CodeMerger merger) throws JannocessorException {
		boolean mergeFile = merger != null;

		String info = fileInfo(location, pkg, filename);
		String operation = mergeFile ? "Merging" : "Overwriting";
		logger.info("{} generated code ({} characters) to file: {}", new Object[] { operation,
				text.length(), info });

		try {
			if (mergeFile) {
				FileInformation oldCode = readFile(location, pkg, filename);
				if (oldCode != null) {
					FileInformation newCode = new DefaultFileInformation(text, oldCode.getFilename(), new Date());
					text = merger.mergeCode(oldCode, newCode);
				} else {
					logger.warn("Couldn't merge non-existing file: {}", info);
				}
			}
		} catch (Exception e) {
			throw new JannocessorException("Couldn't merge file: " + info, e);
		}

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

	private FileInformation readFile(Location location, String pkg, String filename) {
		try {
			FileObject file = filer.getResource(location, pkg, filename);

			InputStream inputStream = file.openInputStream();
			String content = IOUtils.toString(inputStream);
			inputStream.close();

			Date lastModified = new Date(file.getLastModified());

			String name = new File(file.toUri()).getCanonicalPath();

			return new DefaultFileInformation(content, name, lastModified);
		} catch (IOException e) {
			return null;
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

	protected void compile(String path) {
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		if (compiler != null) {
			int result = compiler.run(null, null, null, "-proc:none", "-verbose", "-d",
					getPath(StandardLocation.CLASS_PATH), "-sourcepath",
					getPath(StandardLocation.SOURCE_PATH), getPath(StandardLocation.SOURCE_PATH)
							+ "/" + path);
			if (result == 0) {
				logger.info("Compile finished successfully.");
			} else {
				logger.error("Compile error!");
			}
		} else {
			logger.error("Couldn't retrieve system Java compiler! Hot code swap won't work!");
		}
	}

	private String getPath(Location location) {
		try {
			FileObject file = filer.getResource(location, "", "foo");
			return file.toUri().getPath().replaceFirst("/foo$", "").substring(1);
		} catch (Exception e) {
			throw new RuntimeException("Cannot retrieve path: " + location);
		}
	}

	protected void recompileProcessors() {
		compile(Settings.PROCESSORS_CLASSNAME.replace('.', '/') + ".java");
	}

}