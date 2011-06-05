package org.jannocessor.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardLocation;

import org.jannocessor.adapter.ElementAdapter;
import org.jannocessor.domain.JavaElement;
import org.jannocessor.model.File;
import org.jannocessor.model.Mark;
import org.jannocessor.model.Root;
import org.jannocessor.service.api.JannocessorException;

@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class JannocessorProcessor extends JannocessorProcessorBase {

	@Override
	protected void processAnnotations(Set<? extends TypeElement> annotations,
			RoundEnvironment env) throws JannocessorException {
		// prepare the facts
		List<Object> facts = initFacts(annotations, env);

		// prepare the globals
		Map<String, Object> globals = initGlobals();

		// run the rules on the facts
		engine.executeRules(facts, globals);

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

		String filename = file.getName() + "." + file.getExtension();
		String template = file.getTemplate();
		String pkg = file.getPackage();

		String info = fileInfo(location, pkg, filename);
		logger.debug("- Generating file '{}' from template '{}'", info,
				template);

		Map<String, Object> attributes = initAttributes(file);

		String text = engine.renderText(template, attributes);

		writeToFile(location, pkg, filename, text);
	}

	private Map<String, Object> initAttributes(File file) {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("file", file);
		attributes.put("data", file.getData());

		return attributes;
	}

	private Map<String, Object> initGlobals() {
		Map<String, Object> globals = new HashMap<String, Object>();

		globals.put("logger", logger);
		globals.put("elements", elementUtils);
		globals.put("types", typeUtils);

		globals.put("files", files);
		globals.put("problems", problems);

		return globals;
	}

	private List<Object> initFacts(Set<? extends TypeElement> annotations,
			RoundEnvironment env) throws JannocessorException {
		List<Object> facts = new ArrayList<Object>();

		// construct "root" facts
		Set<? extends Element> roots = env.getRootElements();
		for (Element rootElement : roots) {
			// add new "root" wrapper fact for each root element
			Root root = new Root(new ElementAdapter(rootElement));
			facts.add(root);
		}

		// construct "mark" facts
		for (TypeElement annotation : annotations) {
			Set<? extends Element> annotatedElements = env
					.getElementsAnnotatedWith(annotation);
			for (Element annotatedElement : annotatedElements) {
				// create mark for each annotation X for each annotated element
				Mark mark = createMark(annotation, new ElementAdapter(annotatedElement));
				facts.add(mark);
			}
		}
		return facts;
	}

	protected Mark createMark(TypeElement annotation, JavaElement annotatedElement)
			throws JannocessorException {
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
