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
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;


public class MapperGenerator implements CodeProcessor<JavaClass> {

	private final boolean inDebugMode;

	public MapperGenerator(boolean inDebugMode) {
		this.inDebugMode = inDebugMode;
	}

	/**
	 * Processes a list of annotated domain model classes (e.g. Person),
	 * generating a mapper class for each of them.
	 */
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		for (JavaClass model : classes) {
			JavaClass mapper = New.classs(Classes.PUBLIC, model.getName() + "Mapper");

			JavaType type = model.getType();
			JavaParameter modelParam = New.parameter(type, "model");

			JavaType dtoType = type.copy();
			dtoType.getPackageName().appendPart("dto");
			dtoType.getSimpleName().appendPart("Dto");
			JavaParameter dtoParam = New.parameter(dtoType, "dto");

			JavaMethod modelToDto = New.method(Methods.PUBLIC, void.class, "mapModelToDto",
					modelParam, dtoParam);

			String code = "";

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : model.getFields()) {
				String getterName = field.getName().copy().insertPart(0, "get").toString();
				String setterName = field.getName().copy().insertPart(0, "set").toString();

				// e.g. dto.setFirstName(model.getFirstName());
				code += String.format("dto.%s(model.%s());\n", setterName, getterName);
			}

			modelToDto.getBody().setHardcoded(code.trim());

			mapper.getMethods().add(modelToDto);

			mapper.getMetadata().add(Annotations.generated("JAnnocessor"));

			New.packagee(model.getParent().getName() + ".mapper").getClasses().add(mapper);
			context.generateCode(mapper, inDebugMode);
		}
	}
}
