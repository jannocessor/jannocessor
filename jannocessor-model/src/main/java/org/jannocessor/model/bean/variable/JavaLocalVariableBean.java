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

package org.jannocessor.model.bean.variable;

import org.jannocessor.data.JavaLocalVariableData;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaLocalVariable;

public class JavaLocalVariableBean extends JavaLocalVariableData implements
		JavaLocalVariable {

	public JavaLocalVariableBean(JavaType type, String name, boolean isFinal) {
		this.setType(type);
		this.setName(new NameBean(name));
		this.setFinal(isFinal);
		this.setCode(Code.code(JavaLocalVariable.class));
	}

}
