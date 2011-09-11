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

import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.ElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeParameter;

abstract class JavaTypeAdapter extends ElementAdapter implements JavaType {

	private final TypeElement type;

	public JavaTypeAdapter(TypeElement type, Elements elementUtils,
			Types typeUtils) {
		super(type, elementUtils, typeUtils);
		this.type = type;
	}

	@Override
	public Text getNesting() {
		return getTextAdapter(type.getNestingKind().toString());
	}

	@Override
	public Name getQualifiedName() {
		return getNameAdapter(type.getQualifiedName().toString());
	}

	@Override
	public JavaElementType getSuperclass() {
		return getTypeAdapter(type.getSuperclass());
	}

	@Override
	public Name getPackageName() {
		String fullName = type.getQualifiedName().toString();
		int pos = fullName.lastIndexOf('.');
		String packageName = (pos >= 0) ? fullName.substring(0, pos) : null;
		return getNameAdapter(packageName);
	}

	@Override
	public PowerList<JavaElementType> getInterfaces() {
		PowerList<JavaElementType> adapters = Power.list();

		for (TypeMirror tinterface : type.getInterfaces()) {
			adapters.add(getTypeAdapter(tinterface));
		}

		return adapters;
	}

	@Override
	public PowerList<JavaTypeParameter> getParameters() {
		PowerList<JavaTypeParameter> adapters = Power.list();

		for (TypeParameterElement parameter : type.getTypeParameters()) {
			adapters.add(getElementAdapter(parameter, JavaTypeParameter.class));
		}

		return adapters;
	}

}
