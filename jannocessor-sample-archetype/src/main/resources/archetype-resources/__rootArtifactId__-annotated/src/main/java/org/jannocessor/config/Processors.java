#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package org.jannocessor.config;

import ${package}.example.annotation.GenerateBuilder;
import ${package}.example.processor.BuilderGenerator;

import org.jannocessor.annotation.Annotated;
import org.jannocessor.annotation.Types;
import org.jannocessor.model.structure.JavaClass;

/**
 * This is a configuration class and it must have the name
 * "org.jannocessor.config.Processors" by convention. This is the entry point of
 * the annotation processor and contains a list of code processors, as well as
 * their target source code elements, defined by annotation and kind.
 */
public class Processors {

	/**
	 * All classes annotated with @GenerateBuilder should be processed with the
	 * {@link BuilderGenerator} code processor.
	 * 
	 * @return the code processor that will process the annotated classes
	 */
	@Annotated(GenerateBuilder.class)
	// process only elements annotated with @GenerateBuilder
	@Types(JavaClass.class)
	// process only classes (not enums, interfaces etc.)
	public BuilderGenerator willGenerateBuilder() {
		// use the builder generator in debug mode
		return new BuilderGenerator(true);
	}

}
