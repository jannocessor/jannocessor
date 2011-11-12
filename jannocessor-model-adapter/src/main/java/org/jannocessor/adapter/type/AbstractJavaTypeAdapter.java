/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.adapter.type;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaCodeModelAdapter;
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
		throw calculatedMethodException();
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
	public JavaType copy() {
		throw calculatedMethodException();
	}

}
