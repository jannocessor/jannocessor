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
import org.jannocessor.data.JavaEnumData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;

public class JavaEnumBean extends JavaEnumData implements JavaEnum {


	private static final long serialVersionUID = -194889084741369043L;

	public JavaEnumBean(EnumModifiers modifiers, String name,
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
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));
		this.setStaticInits(children(Power.emptyList(JavaStaticInit.class)));
		this.setInstanceInits(children(Power.emptyList(JavaInstanceInit.class)));
		this.setNestedClasses(children(Power.emptyList(JavaNestedClass.class)));
		this.setNestedEnums(children(Power.emptyList(JavaNestedEnum.class)));
		this.setNestedInterfaces(children(Power
				.emptyList(JavaNestedInterface.class)));
		this.setNestedAnnotations(children(Power
				.emptyList(JavaNestedAnnotation.class)));

		this.setKind(JavaElementKind.ENUM);
		this.setCode(New.code(JavaEnum.class));
	}

}
