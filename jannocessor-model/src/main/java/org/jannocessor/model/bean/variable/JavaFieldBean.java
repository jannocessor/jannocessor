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

package org.jannocessor.model.bean.variable;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaFieldData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.Name;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;

public class JavaFieldBean extends JavaFieldData implements JavaField {

	public JavaFieldBean(FieldModifiers modifiers, JavaType type, Name name,
			JavaExpression value) {
		this.setModifiers(modifiers);
		this.setType(type);
		this.setName(name);
		this.setValue(value);
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));

		this.setKind(JavaElementKind.FIELD);
		this.setCode(New.code(JavaField.class));
	}

}
