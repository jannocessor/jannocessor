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
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.api.CodeProcessor;
import org.jannocessor.processor.api.ProcessingContext;

public class DtoGenerator implements CodeProcessor<JavaClass> {

	private final boolean inDebugMode;

	public DtoGenerator(boolean inDebugMode) {
		this.inDebugMode = inDebugMode;
	}

	/**
	 * Processes a list of annotated domain model classes (e.g. Person),
	 * generating a Domain Transfer Object (DTO) class for each of them.
	 */
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		for (JavaClass model : classes) {
			JavaClass dto = New.classs(Classes.PUBLIC, model.getName() + "Dto");

			// iterate the model fields (e.g. firstName, lastName... in Person)
			for (JavaField field : model.getFields()) {
				JavaMethod getter = Methods.getter(field);
				JavaMethod setter = Methods.setter(field);

				dto.getMethods().addAll(getter, setter);

				field.getMetadata().clear();
				dto.getFields().add(field);
			}

			dto.getMetadata().add(Annotations.generated("JAnnocessor"));

			New.packagee(model.getParent().getName() + ".dto").getClasses().add(dto);
			context.generateCode(dto, inDebugMode);
		}
	}
}
