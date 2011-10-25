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

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaCodeModelAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.New;

public abstract class AbstractJavaTypeAdapter extends JavaCodeModelAdapter
		implements JavaType {

	private static final long serialVersionUID = 3107540909724234443L;
	private final TypeMirror typeMirror;

	public AbstractJavaTypeAdapter(TypeMirror typeMirror,
			Elements elementUtils, Types typeUtils) {
		super(elementUtils, typeUtils);

		this.typeMirror = typeMirror;
	}

	@Override
	public String getCanonicalName() {
		return typeMirror.toString();
	}

	@Override
	public Name getSimpleName() {
		String simpleName = extractGenericType().replaceFirst(".+\\.", "");
		return New.name(simpleName);
	}

	@Override
	public Name getPackageName() {
		String generic = extractGenericType();
		if (generic.contains(".")) {
			return New.name(generic.replaceFirst("\\.[^\\.]+$", ""));
		} else {
			return null;
		}
	}

	private String extractGenericType() {
		return typeMirror.toString().replaceFirst("<.*>", "");
	}

	@Override
	public String toString() {
		return getCanonicalName();
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
		if (getKind().isDeclared()) {
			String genericTypeName = extractGenericType();
			try {
				return Class.forName(genericTypeName);
			} catch (ClassNotFoundException e) {
				logger.warn("Couldn't find declared type: {}", genericTypeName);
			}
		}
		return null;
	}

	@Override
	public Object getDefaultValue() {
		if (typeMirror.getKind().isPrimitive()) {
			if (typeMirror.getKind() == TypeKind.BOOLEAN) {
				return false;
			} else {
				return 0;
			}
		} else {
			return null;
		}
	}

	@Override
	public JavaTypeKind getKind() {
		return JavaTypeKind.valueOf(typeMirror.getKind().toString());
	}

	@Override
	protected Class<? extends JavaType> getAdaptedInterface() {
		return JavaType.class;
	}

	@Override
	public CodeNode getParent() {
		return null;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return Power.emptyList();
	}

}
