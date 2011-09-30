/**
 * Copyright 2011 jannocessor.org
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
import org.jannocessor.data.JavaClassData;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Templates;
import org.jannocessor.model.variable.JavaField;

public class JavaClassBean extends JavaClassData implements JavaClass {

	public JavaClassBean(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		this.setModifiers(modifiers);
		this.setName(new NameBean(name));
		this.setSuperclass(superclass);
		this.setInterfaces(Power.list(interfaces));
		this.setFields(Power.list(fields));
		this.setConstructors(Power.list(constructors));
		this.setMethods(Power.list(methods));
		this.setParameters(Power.list(parameters));
		this.setStaticInits(Power.emptyList(JavaStaticInit.class));
		this.setInstanceInits(Power.emptyList(JavaInstanceInit.class));
		this.setNestedClasses(Power.emptyList(JavaNestedClass.class));
		this.setNestedEnums(Power.emptyList(JavaNestedEnum.class));
		this.setNestedInterfaces(Power.emptyList(JavaNestedInterface.class));
		this.setNestedAnnotations(Power.emptyList(JavaNestedAnnotation.class));

		this.setCode(new SourceCodeBean(Templates.defaultName(getClass())));
	}

}
