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

import org.jannocessor.data.JavaAnnotationAttributeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaAnnotationAttributeBean extends JavaAnnotationAttributeData
		implements JavaAnnotationAttribute {

	
	private static final long serialVersionUID = 7511359361247727478L;
	private JavaType type;
	private Name name;
	private Object defaultValue;

	public JavaAnnotationAttributeBean(JavaType type, String name,
			Object defaultValue) {
		this.type = type;
		this.name = New.name(name);
		this.defaultValue = defaultValue;
		this.setCode(New.code(JavaAnnotationAttribute.class));
	}

	@Override
	public JavaType getType() {
		return this.type;
	}

	public Name getName() {
		return name;
	}

	@Override
	public Object getDefaultValue() {
		return defaultValue;
	}

}
