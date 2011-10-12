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
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;

import org.jannocessor.adapter.AdapterFactory;
import org.jannocessor.model.JavaElement;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.processor.model.ProcessingContext;
import org.jannocessor.processor.model.Processors;
import org.jannocessor.processor.model.RenderData;
import org.jannocessor.processor.model.Root;
import org.jannocessor.ui.RenderPreview;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class JannocessorProcessor extends JannocessorProcessorBase {

	@Override
	protected void processAnnotations(Set<? extends TypeElement> annotations,
			RoundEnvironment env) throws JannocessorException {
		// prepare the facts
		List<Object> facts = initFacts(annotations, env);

		processors = new Processors(engine.getRulesProcessors());

		// prepare the globals
		Map<String, Object> globals = initGlobals();

		// generate the rules
		String[] ruleNames = engine.getProcessedRules();
		String rules = engine.generateRules(ruleNames);

		// run the rules on the facts
		engine.executeRules(rules, facts, globals);

		// show graphical user interface
		RenderPreview.showDialog(getTemplatesPath(), renderRegister, engine);

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
			String text = engine.renderMacro("main",
					renderData.getAttributes(), new String[] {});
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

	private void generateFile(String fileName, String content)
			throws JannocessorException {
		Location location = StandardLocation.SOURCE_OUTPUT;

		String info = fileInfo(location, "", fileName);
		logger.debug("- Generating file: {}", info);

		writeToFile(location, "", fileName, content);
	}

	private Map<String, Object> initGlobals() {
		Map<String, Object> globals = new HashMap<String, Object>();

		ProcessingContext context = new ProcessingContext();

		context.setEngine(engine);
		context.setLogger(logger);
		context.setElements(elementUtils);
		context.setTypes(typeUtils);
		context.setFiles(files);
		context.setContents(contents);
		context.setProblems(problems);
		context.setProcessors(processors);
		context.setFiler(filer);
		context.setProjectPath(getProjectPath());
		context.setRenderer(renderRegister);

		globals.put("context", context);

		return globals;
	}

	private List<Object> initFacts(Set<? extends TypeElement> annotations,
			RoundEnvironment env) throws JannocessorException {
		List<Object> facts = new ArrayList<Object>();

		// construct "root" facts
		Set<? extends Element> roots = env.getRootElements();
		for (Element rootElement : roots) {
			// add new "root" wrapper fact for each root element
			Root root = new Root(AdapterFactory.getElementModel(rootElement,
					JavaElement.class, elementUtils, typeUtils));
			facts.add(root);
		}

		Set<Element> allElements = new HashSet<Element>();

		// construct annotated elements' facts
		for (TypeElement annotation : annotations) {
			Set<? extends Element> annotatedElements = env
					.getElementsAnnotatedWith(annotation);
			logger.debug("-- ANNOTATION: " + annotation);

			allElements.addAll(annotatedElements);

			for (Element annotatedElement : annotatedElements) {
				logger.debug("---- ELEMENT: " + annotatedElement);
				List<? extends Element> kids = annotatedElement
						.getEnclosedElements();
				for (Element kid : kids) {
					logger.debug("------ CHILD: " + kid);
				}

				// add each annotation X for each annotated element

				List<? extends AnnotationMirror> mirrors = annotatedElement
						.getAnnotationMirrors();
				for (AnnotationMirror annotationMirror : mirrors) {
					Map<? extends ExecutableElement, ? extends AnnotationValue> mapa = annotationMirror
							.getElementValues();
					logger.debug("---- ANNOTATION: " + annotationMirror);
					logger.debug("------ MAP: " + mapa);
					logger.debug("------ ALL: "
							+ elementUtils
									.getElementValuesWithDefaults(annotationMirror));
				}

			}
		}

		for (Element element : allElements) {
			JavaElement javaElement = AdapterFactory.getElementModel(element,
					JavaElement.class, elementUtils, typeUtils);
			facts.add(javaElement);
		}

		return facts;
	}

	@Override
	protected Set<String> retrieveSupportedAnnotations()
			throws JannocessorException {
		Set<String> supportedAnnotations = engine.getSupportedAnnotations();
		for (String annotation : supportedAnnotations) {
			logger.debug("- Supported annotation: " + annotation);
		}
		return supportedAnnotations;
	}

}
