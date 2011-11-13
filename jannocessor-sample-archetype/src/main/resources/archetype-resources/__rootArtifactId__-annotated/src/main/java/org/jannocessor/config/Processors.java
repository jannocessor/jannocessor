package org.jannocessor.config;

import org.jannocessor.annotation.Annotated;
import org.jannocessor.annotation.Types;
import org.jannocessor.common.annotation.BuilderModel;
import org.jannocessor.common.annotation.DtoModel;
import org.jannocessor.common.annotation.GenerateFacade;
import org.jannocessor.common.processor.BuilderGenerator;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.processor.context.CodeProcessor;

import example.annotation.BeanModel;
import example.annotation.GenerateBuilder;
import example.processor.MyBeanGenerator;
import example.processor.MyBuilderGenerator;
import example.processor.MyDtoGenerator;
import example.processor.MyExperimentProcessor;
import example.processor.MyFacadeGenerator;
import example.processor.MyMapperGenerator;
import example.processor.MyMirrorProcessor;


/**
 * This is a configuration class and it must have the name
 * "org.jannocessor.config.Processors" by convention. This is the entry point of
 * the annotation processor and contains a list of code processors, as well as
 * their target source code elements, defined by annotation and kind.
 */
public class Processors {

	private static final boolean DEBUG_MODE = false;

	/**
	 * All classes annotated with @GenerateBuilder should be processed with the
	 * {@link BuilderGenerator} code processor.
	 * 
	 * @return the code processor that will process the annotated classes
	 */
	@Annotated(GenerateBuilder.class)
	@Types(JavaClass.class)
	public BuilderGenerator willGenerateBuilder() {
		return new BuilderGenerator(DEBUG_MODE);
	}

	@Annotated({ BeanModel.class, GenerateFacade.class })
	@Types({ JavaInterface.class, JavaEnum.class, JavaAnnotation.class })
	public CodeProcessor<? extends JavaElement> generateMirror() {
		return new MyMirrorProcessor(DEBUG_MODE);
	}

	@Annotated(BeanModel.class)
	@Types(JavaClass.class)
	public CodeProcessor<? extends JavaElement> generateBean() {
		return new MyBeanGenerator(DEBUG_MODE);
	}

	@Annotated(BuilderModel.class)
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
