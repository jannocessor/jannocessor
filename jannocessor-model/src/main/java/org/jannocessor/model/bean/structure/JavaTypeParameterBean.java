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
import org.jannocessor.data.JavaTypeParameterData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaTypeParameterBean extends JavaTypeParameterData implements
		JavaTypeParameter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3912037783962709230L;

	public JavaTypeParameterBean(String name, List<JavaType> bounds) {
		this.setName(new NameBean(name));
		this.setBounds(children(Power.list(bounds)));

		this.setKind(JavaElementKind.TYPE_PARAMETER);
		this.setCode(New.code(JavaTypeParameter.class));
	}
}
