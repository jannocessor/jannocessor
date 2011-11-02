/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.common.processor;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

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
