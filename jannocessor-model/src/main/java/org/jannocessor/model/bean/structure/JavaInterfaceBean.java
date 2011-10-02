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
import org.jannocessor.data.JavaInterfaceData;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Templates;

public class JavaInterfaceBean extends JavaInterfaceData implements
		JavaInterface {

	public JavaInterfaceBean(InterfaceModifiers modifiers, String name,
			List<JavaType> superInterfaces, List<JavaMethod> methods,
			List<JavaTypeParameter> parameters) {
		this.setModifiers(modifiers);
		this.setName(new NameBean(name));
		this.setInterfaces(Power.list(superInterfaces));
		this.setMethods(Power.list(methods));
		this.setParameters(Power.list(parameters));

		this.setCode(new SourceCodeBean(Templates.defaultName(getClass())));
	}

}
