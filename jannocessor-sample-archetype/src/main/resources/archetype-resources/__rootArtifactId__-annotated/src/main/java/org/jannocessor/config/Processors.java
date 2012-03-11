package org.jannocessor.config;

import org.jannocessor.extra.annotation.DtoModel;
import org.jannocessor.extra.annotation.GenerateFacade;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.processor.annotation.Annotated;
import org.jannocessor.processor.annotation.Types;
import org.jannocessor.processor.api.CodeProcessor;

import example.annotation.BeanModel;
import example.annotation.GenerateBuilder;
import example.processor.MyBeanGenerator;
import example.processor.MyBuilderGenerator;
import example.processor.MyDtoGenerator;
import example.processor.MyExperimentProcessor;
import example.processor.MyFacadeGenerator;
import example.processor.MyMapperGenerator;

/**
 * This is a configuration class and it must have the name
 * "org.jannocessor.config.Processors" by convention. This is the entry point of
 * the annotation processor and contains a list of code processors, as well as
 * their target source code elements, defined by annotation and kind.
 */
public class Processors {

	private static final boolean DEBUG_MODE = true;

	@Annotated(BeanModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<? extends JavaElement> generateBean() {
		return new MyBeanGenerator(DEBUG_MODE);
	}

	@Annotated(GenerateBuilder.class)
	@Types(JavaClass.class)
	public MyBuilderGenerator generateBuilder() {
		return new MyBuilderGenerator(DEBUG_MODE);
	}

	@Annotated(DtoModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<JavaClass> generateDto() {
		return new MyDtoGenerator(DEBUG_MODE);
	}

	@Annotated(DtoModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<JavaClass> generateMapper() {
		return new MyMapperGenerator(DEBUG_MODE);
	}

	@Annotated(GenerateFacade.class)
	@Types(JavaInterface.class)
	public CodeProcessor<JavaInterface> generateFacade() {
		return new MyFacadeGenerator(DEBUG_MODE);
	}

	@Annotated(BeanModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<? extends JavaElement> experiment() {
		return new MyExperimentProcessor(DEBUG_MODE);
	}

}
