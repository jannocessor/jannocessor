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

package org.jannocessor.adapter.type;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

import org.jannocessor.adapter.ElementAdapter;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.JavaTypeName;
import org.jannocessor.domain.Text;
import org.jannocessor.domain.type.JavaType;
import org.jannocessor.domain.type.JavaTypeParameter;

abstract class JavaTypeAdapter extends ElementAdapter implements JavaType {

	private final TypeElement type;

	public JavaTypeAdapter(TypeElement type) {
		super(type);
		this.type = type;
	}

	@Override
	public Text getNesting() {
		return getTextAdapter(type.getNestingKind().toString());
	}

	@Override
	public JavaTypeName getQualifiedName() {
		return getTypeNameAdapter(type.getQualifiedName().toString());
	}

	@Override
	public JavaElementType getSuperclass() {
		return getTypeAdapter(type.getSuperclass());
	}

	@Override
	public List<JavaElementType> getInterfaces() {
		List<JavaElementType> adapters = new ArrayList<JavaElementType>();

		for (TypeMirror tinterface : type.getInterfaces()) {
			adapters.add(getTypeAdapter(tinterface));
		}

		return adapters;
	}

	@Override
	public List<JavaTypeParameter> getParameters() {
		List<JavaTypeParameter> adapters = new ArrayList<JavaTypeParameter>();

		for (TypeParameterElement parameter : type.getTypeParameters()) {
			adapters.add(getElementAdapter(parameter, JavaTypeParameter.class));
		}

		return adapters;
	}

}
