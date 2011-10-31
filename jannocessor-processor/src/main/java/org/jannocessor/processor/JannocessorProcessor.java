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

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;

import org.jannocessor.JannocessorException;
import org.jannocessor.adapter.AdapterFactory;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.context.RenderData;
import org.jannocessor.model.JavaElement;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingConfiguration;
import org.jannocessor.processor.context.ProcessingContext;
import org.jannocessor.processor.context.Root;
import org.jannocessor.ui.RenderPreview;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class JannocessorProcessor extends JannocessorProcessorBase {

	@Override
	protected void processAnnotations(Set<? extends TypeElement> annotations, RoundEnvironment env)
			throws JannocessorException {
		// prepare the facts
		ProcessingContext context = createProcessingContext();

		processElements(annotations, env, context);

		/******* RULES ENGINE IS CURRENTLY DISABLED FOR SIMPLICITY REASONS *******/

		// prepare the globals
		// Map<String, Object> globals = initGlobals();

		// generate the rules
		// String[] ruleNames = engine.getProcessedRules();
		// String rules = engine.generateRules(ruleNames);

		// run the rules on the facts
		// engine.executeRules(rules, facts, globals);

		/**************************************************************************/

		// show graphical user interface
		RenderPreview.showDialog(engine.getTemplatesPath(), renderRegister, engine, engine);

		// rendered the registered data again after UI processing
		renderRegistered();

		// generate files
		generateFiles();
	}

	private void renderRegistered() throws JannocessorException {
		List<RenderData> renderings = renderRegister.getRenderings();

		// FIXME: some content will be double-processed (as both in "contents"
		// and "renderings")
		for (String content : contents) {
			processMultiFiles(engine.split(content));
		}

		for (RenderData renderData : renderings) {
			String text = engine.renderMacro("main", renderData.getAttributes(), new String[] {});
			processMultiFiles(engine.split(text));
		}
	}

	private void processMultiFiles(Map<String, String> contents) {
		if (!contents.isEmpty()) {
			for (Entry<String, String> entry : contents.entrySet()) {
				files.put(entry.getKey(), entry.getValue());
			}
		} else {
			logger.error("File name not specified!");
		}
	}

	private void generateFiles() throws JannocessorException {
		logger.info("Generating {} files...", files.size());

		for (Entry<String, String> file : files.entrySet()) {
			generateFile(file.getKey(), file.getValue());
		}

		logger.info("Total {} files were generated.", files.size());
	}

	private void generateFile(String fileName, String content) throws JannocessorException {
		Location location = StandardLocation.SOURCE_OUTPUT;

		String info = fileInfo(location, "", fileName);
		logger.debug("- Generating file: {}", info);

		writeToFile(location, "", fileName, content);
	}

	@SuppressWarnings("unused")
	private Map<String, Object> initGlobals() {
		Map<String, Object> globals = new HashMap<String, Object>();

		ProcessingContext context = createProcessingContext();

		globals.put("context", context);

		return globals;
	}

	private ProcessingContext createProcessingContext() {
		ProcessingContext context = new ProcessingContext();

		context.setEngine(engine);
		context.setLogger(logger);
		context.setElements(elementUtils);
		context.setTypes(typeUtils);
		context.setFiles(files);
		context.setContents(contents);
		context.setProblems(problems);
		context.setFiler(filer);
		context.setProjectPath(getProjectPath());
		context.setRenderer(renderRegister);
		return context;
	}

	private void processElements(Set<? extends TypeElement> annotations, RoundEnvironment env,
			ProcessingContext context) throws JannocessorException {
		List<Object> facts = new ArrayList<Object>();

		Map<String, Set<? extends Element>> annotated = getAnnotatedElements(annotations, env);

		// construct "root" facts
		Set<? extends Element> roots = env.getRootElements();
		for (Element rootElement : roots) {
			// add new "root" wrapper fact for each root element
			Root root = new Root(AdapterFactory.getElementModel(rootElement, JavaElement.class,
					elementUtils, typeUtils));
			facts.add(root);
		}

		for (ProcessingConfiguration config : processorsConfig.getConfiguration()) {
			HashSet<Element> elements = new HashSet<Element>();

			for (Class<? extends Annotation> annotation : config.getAnnotations()) {
				Set<? extends Element> annotatedElements = annotated.get(annotation
						.getCanonicalName());
				if (annotatedElements != null) {
					elements.addAll(annotatedElements);
				}
			}

			PowerList<JavaElement> list = Power.list();

			for (Element element : elements) {
				JavaElement model = AdapterFactory.getElementModel(element, JavaElement.class,
						elementUtils, typeUtils);

				for (Class<? extends JavaElement> type : config.getTypes()) {
					if (type.isInstance(model)) {
						list.add(model);
						break;
					}
				}
			}

			invokeProcessor(config.getProcessor(), list, context);
		}
	}

	private Map<String, Set<? extends Element>> getAnnotatedElements(
			Set<? extends TypeElement> annotations, RoundEnvironment env) {
		Map<String, Set<? extends Element>> annotatedElements = new HashMap<String, Set<? extends Element>>();

		for (TypeElement annotation : annotations) {
			String name = annotation.getQualifiedName().toString();
			Set<? extends Element> elements = env.getElementsAnnotatedWith(annotation);

			annotatedElements.put(name, elements);

			logger.info("Total {} elements were annotated with @{}", elements.size(),
					annotation.getSimpleName());
		}

		return annotatedElements;
	}

	@SuppressWarnings("unchecked")
	private <T extends JavaElement> void invokeProcessor(CodeProcessor<T> codeProcessor,
			PowerList<? extends JavaElement> list, ProcessingContext context) {
		codeProcessor.process((PowerList<T>) list, context);
	}

	@Override
	protected Set<String> retrieveSupportedAnnotations() throws JannocessorException {

		Set<String> supportedAnnotations = processorsConfig.getSupportedAnnotations();

		for (String annotation : supportedAnnotations) {
			logger.debug("- Supported annotation: " + annotation);
		}

		return supportedAnnotations;
	}

}
