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

package org.jannocessor.adapter.type;

import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.New;

public class JavaTypeVariableAdapter extends JavaTypeAdapter implements
		JavaTypeVariable {

	private final TypeVariable typeVariable;

	public JavaTypeVariableAdapter(TypeVariable typeVariable,
			Elements elementUtils, Types typeUtils) {
		super(typeVariable, elementUtils, typeUtils);

		this.typeVariable = typeVariable;
		this.getCode().assign(New.code(JavaTypeVariable.class));
	}

	@Override
	public JavaType getUpperBound() {
		return getTypeAdapter(typeVariable.getUpperBound());
	}

	@Override
	public JavaType getLowerBound() {
		return getTypeAdapter(typeVariable.getLowerBound());
	}

}
