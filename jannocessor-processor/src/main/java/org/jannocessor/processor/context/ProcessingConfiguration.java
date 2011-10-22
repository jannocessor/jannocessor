package org.jannocessor.processor.context;

import java.lang.annotation.Annotation;

import org.jannocessor.model.JavaElement;

public class ProcessingConfiguration {

	private final Class<? extends Annotation>[] annotations;

	private final CodeProcessor<? extends JavaElement> processor;

	private final Class<? extends JavaElement>[] types;

	public ProcessingConfiguration(Class<? extends Annotation>[] annotated,
			Class<? extends JavaElement>[] types,
			CodeProcessor<? extends JavaElement> processor) {
		this.annotations = annotated;
		this.types = types;
		this.processor = processor;
	}

	public Class<? extends Annotation>[] getAnnotations() {
		return annotations;
	}

	public CodeProcessor<? extends JavaElement> getProcessor() {
		return processor;
	}

	public Class<? extends JavaElement>[] getTypes() {
		return types;
	}

}
