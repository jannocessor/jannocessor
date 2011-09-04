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

package org.jannocessor.adapter;

import java.util.List;

import javax.lang.model.type.ArrayType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.domain.JavaElement;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Name;

public final class ElementTypeAdapter extends AbstractAdapter implements
		JavaElementType {

	private final TypeMirror typeMirror;

	public ElementTypeAdapter(TypeMirror typeMirror, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.typeMirror = typeMirror;
	}

	@Override
	public Name getName() {
		return getNameAdapter(typeMirror.toString());
	}

	public JavaElement getAsElement() {
		return getElementAdapter(getTypeUtils().asElement(typeMirror),
				JavaElement.class);
	}

	public TypeMirror getCapture() {
		return getTypeUtils().capture(typeMirror);
	}

	public List<? extends TypeMirror> getDirectSupertypes() {
		return getTypeUtils().directSupertypes(typeMirror);
	}

	public TypeMirror getErasure() {
		return getTypeUtils().erasure(typeMirror);
	}

	public ArrayType getArrayType() {
		return getTypeUtils().getArrayType(typeMirror);
	}

	public PrimitiveType getUnboxedType() {
		return getTypeUtils().unboxedType(typeMirror);
	}

}
