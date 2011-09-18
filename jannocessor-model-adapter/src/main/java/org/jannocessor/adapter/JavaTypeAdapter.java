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

import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaInterface;

public final class JavaTypeAdapter extends AbstractAdapter implements JavaType {

	private final TypeMirror typeMirror;

	public JavaTypeAdapter(TypeMirror typeMirror, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.typeMirror = typeMirror;
	}

	@Override
	public Name getCanonicalName() {
		return getNameAdapter(typeMirror.toString());
	}

	@Override
	public Name getSimpleName() {
		String simpleName = typeMirror.toString().replaceFirst(".+\\.", "");
		return getNameAdapter(simpleName);
	}

	@Override
	public String toString() {
		return getCanonicalName().getText();
	}

	@Override
	public boolean isPrimitive() {
		return typeMirror.getKind().isPrimitive();
	}

	@Override
	public boolean isArray() {
		return TypeKind.ARRAY.equals(typeMirror.getKind());
	}

	@Override
	public JavaType asArray() {
		return null;
	}

	@Override
	public boolean isClass() {
		if (TypeKind.DECLARED.equals(typeMirror.getKind())) {
			return false;
		} else {
			return false;
		}
	}

	@Override
	public JavaClass asClass() {
		return null;
	}

	@Override
	public boolean isInterface() {
		return false;
	}

	@Override
	public JavaInterface asInterface() {
		return null;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isDeclared() {
		return false;
	}

	@Override
	public boolean isTypeVariable() {
		return false;
	}

	@Override
	public boolean hasError() {
		return false;
	}

	@Override
	public PowerList<JavaType> getParameters() {
		return null;
	}

}
