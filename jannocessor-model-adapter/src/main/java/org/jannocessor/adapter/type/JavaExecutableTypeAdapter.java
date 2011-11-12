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

import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.ModelUtils;

public class JavaExecutableTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaExecutableType {

	private static final long serialVersionUID = 6878540706508272046L;
	private final ExecutableType executableType;

	public JavaExecutableTypeAdapter(ExecutableType executableType,
			Elements elementUtils, Types typeUtils) {
		super(executableType, elementUtils, typeUtils);

		this.executableType = executableType;

	}

	@Override
	public PowerList<JavaType> getParameterTypes() {
		return getTypeAdapters(executableType.getParameterTypes());
	}

	@Override
	public JavaType getReturnType() {
		return getTypeAdapter(executableType.getReturnType());
	}

	@Override
	public PowerList<JavaDeclaredType> getThrownTypes() {
		return getTypeAdapters(executableType.getThrownTypes(),
				JavaDeclaredType.class);
	}

	@Override
	public PowerList<JavaTypeVariable> getTypeVariables() {
		return getTypeAdapters(executableType.getTypeVariables(),
				JavaTypeVariable.class);
	}

	@Override
	protected Class<? extends JavaExecutableType> getAdaptedInterface() {
		return JavaExecutableType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaExecutableType copy() {
		throw calculatedMethodException();
	}

}
