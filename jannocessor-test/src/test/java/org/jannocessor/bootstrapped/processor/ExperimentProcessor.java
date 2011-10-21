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

package org.jannocessor.bootstrapped.processor;

import java.util.Map;

import javax.annotation.Generated;

import org.jannocessor.collection.Power;
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
import org.jannocessor.processor.model.CodeProcessor;
import org.jannocessor.processor.model.ProcessingContext;

public class ExperimentProcessor implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
		JavaClass model = (JavaClass) params.get("model");

		context.getLogger().debug("Processing: {} ", model.getName());

		model.getName().appendPart("Gen");

		if (model.getSuperclass() != null) {
			Name parentName = model.getSuperclass().getSimpleName();
			if (parentName.getText().equals("AbstractModel")) {
				parentName.appendPart("Gen");
			}
		}

		JavaMetadata meta1 = New.metadata(Generated.class, "Jannocessor Test");
		model.getMetadata().add(meta1);

		JavaMethod method1 = New.method(Methods.PUBLIC, String.class, "cool");
		method1.getBody().setHardcoded("return \"COOL!\";");
		model.getMethods().add(method1);

		model.getInstanceInits().add(New.instanceInit(New.body("// init")));
		model.getStaticInits().add(New.staticInit(New.body("// static init")));

		JavaField x = New.field(Fields.PRIVATE, boolean.class, "x",
				New.literal(true));
		JavaMetadata meta2 = New.metadata(SuppressWarnings.class, "unused");
		x.getMetadata().add(meta2);

		model.getFields().add(x);

		JavaEnumConstant value1 = New.enumConstant("A");
		value1.getValues().addAll(New.expression("\"foo\""),
				New.expression("11"));

		JavaEnumConstant value2 = New.enumConstant("B", New.literal("bar"),
				New.literal(13));

		JavaNestedEnum enum1 = New.nestedEnum("MyEnum",
				Power.list(value1, value2));

		JavaParameter param1 = New.parameter(String.class, "a");
		JavaParameter param2 = New.parameter(int.class, "b");
		JavaConstructor constr1 = New.constructor(Constructors.PRIVATE, param1,
				param2);
		enum1.getConstructors().add(constr1);

		model.getNestedEnums().add(enum1);

		JavaConstructor constr2 = New.constructor(New.parameter(String.class,
				"xa"));
		model.getConstructors().add(constr2);

		JavaClass model2 = New.copy(model);
		model2.getName().appendPart("Copy");

		if (model.getSuperclass() != null) {
			System.out.println("===" + model.getSuperclass().hashCode());
		}

		// System.out.println("--------------------------- 1");
		// System.out.println(model);
		// System.out.println("--------------------------- 2");
		// System.out.println(model2);
		// System.out.println("--------------------------- 3");

		context.generateCode(model, true);
		// context.generateCode(model2, true);
	}

}
