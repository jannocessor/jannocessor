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
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Get;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Transform;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.api.ProcessingContext;

public class MapperGenerator extends AbstractGenerator<AbstractJavaClass> {

	private final String pkg1;
	private final String pkg2;
	private final String suffix1;
	private final String suffix2;

	public MapperGenerator(String destPackage, String pkg1, String pkg2, String suffix1, String suffix2,
			boolean inDebugMode) {
		super(destPackage, inDebugMode);
		this.pkg1 = pkg1;
		this.pkg2 = pkg2;
		this.suffix1 = suffix1;
		this.suffix2 = suffix2;
	}

	/**
	 * Generates a mapper implementation class from the specified model.
	 */
	protected void generateCodeFrom(PowerList<AbstractJavaClass> models, ProcessingContext context) {
		for (AbstractJavaClass model : models) {
			JavaType superclass = New.type("AbstractMapper");
			JavaClass mapper = New.classs(Classes.PUBLIC, model.getName() + "Mapper", superclass);

			JavaType typeA = New.type(pkg1 + "." + model.getName() + suffix1);
			JavaType typeB = New.type(pkg2 + "." + model.getName() + suffix2);

			JavaParameter paramA = New.parameter(typeA, "model");
			JavaParameter paramB = New.parameter(typeB, "dto");

			JavaMethod mapAB = New.method(Methods.PUBLIC, void.class, "map", paramA, paramB);
			JavaMethod mapBA = New.method(Methods.PUBLIC, void.class, "map", paramB.copy(), paramA.copy());

			String code = "";
			String code2 = "";
			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : model.getFields()) {
				String getterName = field.getName().copy().insertPart(0, "get").toString();
				String setterName = field.getName().copy().insertPart(0, "set").toString();

				PowerList<AbstractJavaClass> modelParts = findTypeParts(field.getType(), models);

				// e.g. model.getBook()
				String modelSrc = String.format("model.%s()", getterName);
				String dtoSrc = String.format("dto.%s()", getterName);

				if (!modelParts.isEmpty()) {
					// e.g. convert(model.getFirstName(), BookDTO.class)
					modelSrc = String.format("convert(%s, " + classes(modelParts, true) + ")", modelSrc,
							classes(modelParts, true));
					dtoSrc = String.format("convert(%s, " + classes(modelParts, false) + ")", dtoSrc,
							classes(modelParts, false));
				}

				// e.g. dto.setFirstName(model.getFirstName());
				code += String.format("dto.%s(%s);\n", setterName, modelSrc);
				code2 += String.format("model.%s(%s);\n", setterName, dtoSrc);
			}

			mapAB.getBody().setTemplate(code.trim());
			mapBA.getBody().setTemplate(code2.trim());

			mapper.getMethods().add(mapAB);
			mapper.getMethods().add(mapBA);

			generate(mapper);
		}
	}

	private String classes(PowerList<AbstractJavaClass> modelParts, boolean isDTO) {
		String suffix = isDTO ? "DTO" : "";
		String pkg = isDTO ? pkg2 : pkg1;
		String classes = modelParts.getTransformed(Get.NAME).getTransformed(Transform.TO_STRING)
				.getTransformed(Transform.surround("#type('" + pkg + ".", suffix + "').class")).join(", ");
		return classes;
	}
}
