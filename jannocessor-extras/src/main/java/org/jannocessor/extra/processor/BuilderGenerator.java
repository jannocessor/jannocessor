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

package org.jannocessor.extra.processor;

import javax.annotation.Generated;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;

public class BuilderGenerator implements CodeProcessor<JavaClass> {

	private final boolean inDebugMode;

	public BuilderGenerator(boolean inDebugMode) {
		this.inDebugMode = inDebugMode;
	}

	/**
	 * Processes a list of annotated domain model classes (e.g. Person),
	 * transforming each of them to a new class that represents a builder (e.g.
	 * PersonBuilder). Finally, the source code of the transformed classes is
	 * generated.
	 */
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		for (final JavaClass clazz : classes) {
			// the name of the domain model class (e.g. Person)
			String modelName = clazz.getName().getText();

			// construct the builder name (e.g. PersonBuilder)
			clazz.getName().appendPart("Builder");

			// the type representation of the builder class (e.g. PersonBuilder type)
			JavaType builderType = New.type(modelName + "Builder", JavaTypeKind.DECLARED);

			// initialize empty list of methods for the builder
			PowerList<JavaMethod> methods = Power.list();

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : clazz.getFields()) {
				field.getMetadata().clear();

				// the field name, e.g. firstName
				String fieldName = field.getName().getText();

				// a parameter for the new method in the builder (e.g. String firstName)
				JavaParameter param1 = New.parameter(field.getType(), fieldName);

				// create new method names as the field
				// e.g. public PersonBuilder firstName(String firstName) {...}
				JavaMethod method = New.method(Methods.PUBLIC, builderType, fieldName, param1);

				// specify the method body source code (assigns the param value to the field)
				// e.g. this.firstName = firstName
				String body = String.format("this.%s = %s;\nreturn this;", fieldName, fieldName);
				method.getBody().setHardcoded(body);

				// add the method to the builder methods list
				methods.add(method);
			}

			// create the builder method that constructs the model
			// e.g. public Person build() {...)
			JavaMethod build = New.method(Methods.PUBLIC, clazz.getType(), "build");

			// the method body is non-trivial, so it will be rendered from the build.vm template
			build.getBody().setTemplateName("build");

			// add the "build" method to the list of methods
			methods.add(build);

			// remove the model class constructors
			clazz.getConstructors().clear();

			// assign the previously created methods to the builder class
			clazz.getMethods().assign(methods);

			// annotate the generated class as: @Generated("Easily by JAnnocessor :)")
			JavaMetadata metadata = New.metadata(Generated.class, "Easily by JAnnocessor :)");
			clazz.getMetadata().assign(Power.list(metadata));

			// finally, generated the builder source code (e.g. PersonBuilder.java)
			// if inDebugMode was set to true, the JAnnocessor UI will be displayed
			clazz.getParent().getName().appendPart("builder");
			context.generateCode(clazz, inDebugMode);
		}
	}
}
