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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.Code;

public final class JavaTypeParameterAdapter extends JavaElementAdapter
		implements JavaTypeParameter {

	private static final Criteria<JavaType> DEFAULT_BOUND;

	private final TypeParameterElement typeParameter;

	static {
		DEFAULT_BOUND = Power.criteria(new Condition<JavaType>() {
			@Override
			public boolean satisfies(JavaType type) {
				return type.getKind() == JavaTypeKind.DECLARED
						&& Object.class.equals(type.getTypeClass());
			}
		});
	}

	public JavaTypeParameterAdapter(TypeParameterElement typeParameter,
			Elements elementUtils, Types typeUtils) {
		super(typeParameter, elementUtils, typeUtils);
		this.setCode(Code.code(JavaTypeParameter.class));
		this.typeParameter = typeParameter;
	}

	@Override
	public PowerList<JavaType> getBounds() {
		return getTypeAdapters(typeParameter.getBounds()).remove(DEFAULT_BOUND);
	}

}
