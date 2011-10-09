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

package org.jannocessor.model.bean.executable;

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaMethodData;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaParameter;

public class JavaMethodBean extends JavaMethodData implements JavaMethod {

	public JavaMethodBean(MethodModifiers modifiers, JavaType returnType,
			String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		this.setModifiers(modifiers);
		this.setReturnType(returnType);
		this.setName(new NameBean(name));
		this.setParameters(Power.list(params));
		this.setThrownTypes(Power.list(thrownTypes));
		this.setTypeParameters(Power.list(typeParameters));

		this.setCode(Code.code(JavaMethod.class));
		this.setBody(Code.body(JavaMethod.class));
	}

}
