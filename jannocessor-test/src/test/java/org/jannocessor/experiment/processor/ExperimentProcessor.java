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

package org.jannocessor.experiment.processor;

import javax.annotation.Generated;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.processor.context.CodeProcessor;
import org.jannocessor.processor.context.ProcessingContext;

public class ExperimentProcessor implements CodeProcessor<JavaClass> {

	@Override
	public void process(PowerList<JavaClass> classes, ProcessingContext context) {
		context.getLogger().info("Processing {} classes", classes.size());

		for (JavaClass clazz : classes) {
			clazz.getName().appendPart("Gen");
			clazz.getPackageName().appendPart("generated");

			if (clazz.getSuperclass() != null) {
				Name parentName = clazz.getSuperclass().getSimpleName();
				if (parentName.getText().equals("AbstractModel")) {
					parentName.appendPart("Gen");
					clazz.getSuperclass().getPackageName()
							.appendPart("generated");
				}
			}

			JavaMetadata meta1 = New.metadata(Generated.class,
					"Jannocessor Test");
			clazz.getMetadata().add(meta1);

			JavaMethod method1 = New.method(Methods.PUBLIC, String.class,
					"cool");
			method1.getBody().setHardcoded("return \"COOL!\";");
			clazz.getMethods().add(method1);

			clazz.getInstanceInits().add(New.instanceInit(New.body("// init")));
			clazz.getStaticInits().add(
					New.staticInit(New.body("// static init")));

			JavaField x = New.field(Fields.PRIVATE, boolean.class, "x",
					New.literal(true));
			JavaMetadata meta2 = New.metadata(SuppressWarnings.class, "unused");
			x.getMetadata().add(meta2);

			clazz.getFields().add(x);

			JavaEnumConstant value1 = New.enumConstant("A");
			value1.getValues().addAll(New.expression("\"foo\""),
					New.expression("11"));

			JavaEnumConstant value2 = New.enumConstant("B", New.literal("bar"),
					New.literal(13));

			JavaNestedEnum enum1 = New.nestedEnum("MyEnum",
					Power.list(value1, value2));

			JavaParameter param1 = New.parameter(String.class, "a");
			JavaParameter param2 = New.parameter(int.class, "b");
			JavaConstructor constr1 = New.constructor(Constructors.PRIVATE,
					param1, param2);
			enum1.getConstructors().add(constr1);

			clazz.getNestedEnums().add(enum1);

			JavaConstructor constr2 = New.constructor(New.parameter(
					String.class, "param1"));
			clazz.getConstructors().add(constr2);

//			context.generateCode(clazz, true);
		}
	}

}
