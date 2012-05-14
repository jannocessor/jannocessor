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

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.api.ProcessingContext;

public class BuilderGenerator extends AbstractGenerator<AbstractJavaClass> {

	private final String beanPkg;

	public BuilderGenerator(String destPackage, String beanPkg, boolean inDebugMode) {
		super(destPackage, inDebugMode);
		this.beanPkg = beanPkg;
	}

	/**
	 * Generates a builder class from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			// construct the builder class (e.g. PersonBuilder)
			String builderName = model.getName() + "Builder";
			JavaClass builder = New.classs(builderName);

			// the type representation of the builder class (e.g. PersonBuilder type)
			JavaType builderType = New.type(builderName, JavaTypeKind.DECLARED);

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : model.getFields()) {
				// the field name (e.g. firstName)
				String fieldName = field.getName().getText();

				// a parameter for the new method in the builder (e.g. String firstName)
				JavaType type = replaceModel(field.getType(), beanPkg + ".", "");
				JavaParameter param1 = New.parameter(type, fieldName);

				// add the field
				builder.getFields().add(New.field(type, fieldName));

				// create new method names as the field
				// e.g. public PersonBuilder firstName(String firstName) {...}
				JavaMethod method = New.method(Methods.PUBLIC, builderType, fieldName, param1);

				// specify the method body source code (assigns the param value to the field)
				// e.g. this.firstName = firstName
				String body = String.format("this.%s = %s;\nreturn this;", fieldName, fieldName);
				method.getBody().setHardcoded(body);

				// add the method to the builder methods list
				builder.getMethods().add(method);
			}

			// create the builder method that constructs the model
			// e.g. public Person build() {...)
			JavaType beanType = New.type(beanPkg + "." + model.getType().getSimpleName());
			JavaMethod build = New.method(Methods.PUBLIC, beanType, "build");

			// the method body is non-trivial, so it will be rendered from the build.vm template
			build.getBody().setTemplateName("build");

			// add the "build" method to the builder
			builder.getMethods().add(build);

			// finally, generate the builder source code (e.g. PersonBuilder.java)
			// if inDebugMode was set to true, the JAnnocessor UI will be displayed
			generate(builder);
		}
	}
}
