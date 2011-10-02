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

import javax.lang.model.element.ElementKind;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaCodeModelAdapter;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.util.Code;

public class JavaTypeAdapter extends JavaCodeModelAdapter implements JavaType {

	private final TypeMirror typeMirror;

	public JavaTypeAdapter(TypeMirror typeMirror, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.setCode(Code.code(JavaType.class));
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
	public boolean isClass() {
		DeclaredType declaredType = getDeclaredType();
		if (declaredType != null) {
			return declaredType.asElement().getKind().equals(ElementKind.CLASS);
		} else {
			return false;
		}
	}

	@Override
	public JavaClass asClass() {
		if (isClass()) {
			return (JavaClass) getDeclaredType().asElement();
		} else {
			throw new IllegalStateException("Expected CLASS type, but found: "
					+ typeMirror.getKind());
		}
	}

	@Override
	public boolean isInterface() {
		DeclaredType declaredType = getDeclaredType();
		if (declaredType != null) {
			return declaredType.asElement().getKind()
					.equals(ElementKind.INTERFACE);
		} else {
			return false;
		}
	}

	@Override
	public JavaInterface asInterface() {
		if (isInterface()) {
			return (JavaInterface) getDeclaredType().asElement();
		} else {
			throw new IllegalStateException(
					"Expected INTERFACE type, but found: "
							+ typeMirror.getKind());
		}
	}

	@Override
	public boolean isEnum() {
		DeclaredType declaredType = getDeclaredType();
		if (declaredType != null) {
			return declaredType.asElement().getKind().equals(ElementKind.ENUM);
		} else {
			return false;
		}
	}

	@Override
	public JavaEnum asEnum() {
		if (isEnum()) {
			return (JavaEnum) getDeclaredType().asElement();
		} else {
			throw new IllegalStateException("Expected ENUM type, but found: "
					+ typeMirror.getKind());
		}
	}

	@Override
	public boolean isNull() {
		return TypeKind.NULL.equals(typeMirror.getKind());
	}

	@Override
	public boolean isDeclared() {
		return TypeKind.DECLARED.equals(typeMirror.getKind());
	}

	@Override
	public boolean isTypeVariable() {
		return TypeKind.TYPEVAR.equals(typeMirror.getKind());
	}

	@Override
	public boolean isWildcard() {
		return TypeKind.WILDCARD.equals(typeMirror.getKind());
	}

	@Override
	public boolean hasError() {
		return TypeKind.ERROR.equals(typeMirror.getKind());
	}

	protected DeclaredType getDeclaredType() {
		if (TypeKind.DECLARED.equals(typeMirror.getKind())) {
			if (typeMirror instanceof DeclaredType) {
				return (DeclaredType) typeMirror;
			}
		}
		return null;
	}

	@Override
	public Class<?> getTypeClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isVoid() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JavaDeclaredType asDeclared() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaArrayType asArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaWildcardType asWildcard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JavaTypeVariable asTypeVariable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExecutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JavaExecutableType asExecutable() {
		// TODO Auto-generated method stub
		return null;
	}

}
