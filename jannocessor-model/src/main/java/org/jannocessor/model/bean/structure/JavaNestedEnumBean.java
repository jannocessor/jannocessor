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

package org.jannocessor.model.bean.structure;

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaNestedEnumData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;

public class JavaNestedEnumBean extends JavaNestedEnumData implements
		JavaNestedEnum {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2629476425124936333L;

	public JavaNestedEnumBean(NestedEnumModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaEnumConstant> values,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {
		this.setModifiers(modifiers);
		this.setName(new NameBean(name));
		this.setInterfaces(children(Power.list(interfaces)));
		this.setValues(children(Power.list(values)));
		this.setFields(children(Power.list(fields)));
		this.setConstructors(children(Power.list(constructors)));
		this.setMethods(children(Power.list(methods)));
		this.setStaticInits(children(Power.emptyList(JavaStaticInit.class)));
		this.setInstanceInits(children(Power.emptyList(JavaInstanceInit.class)));
		this.setNestedClasses(children(Power.emptyList(JavaNestedClass.class)));
		this.setNestedEnums(children(Power.emptyList(JavaNestedEnum.class)));
		this.setNestedInterfaces(children(Power
				.emptyList(JavaNestedInterface.class)));
		this.setNestedAnnotations(children(Power
				.emptyList(JavaNestedAnnotation.class)));

		this.setKind(JavaElementKind.NESTED_ENUM);
		this.setCode(New.code(JavaNestedEnum.class));
	}

}
