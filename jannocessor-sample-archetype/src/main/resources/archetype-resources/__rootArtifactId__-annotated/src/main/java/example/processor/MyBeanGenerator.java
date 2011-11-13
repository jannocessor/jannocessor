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

package example.processor;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

public class MyBeanGenerator implements CodeProcessor<JavaClass> {

	private final boolean debugMode;

	public MyBeanGenerator(boolean debugMode) {
		this.debugMode = debugMode;
	}

	@Override
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		context.getLogger().info("Processing {} classes", classes.size());

		for (JavaClass clazz : classes) {
			clazz.getName().appendPart("Gen");
			clazz.getMetadata().clear();

			for (JavaField field : clazz.getFields()) {
				field.getModifiers().assign(Fields.PRIVATE);

				String getterName = field.getName().copy().insertPart(0, "get").toString();
				JavaMethod getter = New.method(Methods.PUBLIC, field.getType(), getterName);
				getter.getBody().setHardcoded(String.format("return this.%s;", field.getName()));

				clazz.getMethods().add(getter);
			}

			context.generateCode(clazz, debugMode);
		}
	}

}
