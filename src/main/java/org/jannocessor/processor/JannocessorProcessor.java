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

package org.jannocessor.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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

import org.jannocessor.adapter.ModelFactory;
import org.jannocessor.domain.JavaElement;
import org.jannocessor.model.File;
import org.jannocessor.model.Mark;
import org.jannocessor.model.ProcessingContext;
import org.jannocessor.model.Processors;
import org.jannocessor.model.Root;
import org.jannocessor.service.api.JannocessorException;

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

		// generate files
		generateFiles();
	}

	private void generateFiles() throws JannocessorException {
		Collection<File> allFiles = files.getAll();
		logger.info("Generating {} files...", allFiles.size());

		for (File file : allFiles) {
			generateFile(file);
		}

		logger.info("Total {} files were generated.", allFiles.size());
	}

	private void generateFile(File file) throws JannocessorException {
		Location location = StandardLocation.SOURCE_OUTPUT;

		String filename = file.getFileName();
		String pkg = file.getPackageName();

		String info = fileInfo(location, pkg, filename);
		logger.debug("- Generating file: {}", info);

		writeToFile(location, pkg, filename, file.getContent());
	}

	private Map<String, Object> initGlobals() {
		Map<String, Object> globals = new HashMap<String, Object>();

		ProcessingContext context = new ProcessingContext();

		context.setEngine(engine);
		context.setLogger(logger);
		context.setElements(elementUtils);
		context.setTypes(typeUtils);
		context.setFiles(files);
		context.setProblems(problems);
		context.setProcessors(processors);
		context.setFiler(filer);
		context.setProjectPath(getProjectPath());

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
			Root root = new Root(ModelFactory.getElementModel(rootElement,
					JavaElement.class));
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
			JavaElement javaElement = ModelFactory.getElementModel(element,
					JavaElement.class);
			facts.add(javaElement);
		}

		return facts;
	}

	protected Mark createMark(TypeElement annotation,
			JavaElement annotatedElement) throws JannocessorException {
		// annotation label is the annotation key in annotations configuration
		String cannonicalName = annotation.getQualifiedName().toString();
		String annotationLabel = engine.getAnnotationLabel(cannonicalName);

		Mark mark = new Mark(annotation, annotatedElement, annotationLabel);
		return mark;
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
