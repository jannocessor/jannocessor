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

import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.ModelUtils;

public class JavaTypeVariableAdapter extends AbstractJavaTypeAdapter implements
		JavaTypeVariable {

	private static final long serialVersionUID = -6393738928505508309L;
	private final TypeVariable typeVariable;

	public JavaTypeVariableAdapter(TypeVariable typeVariable,
			Elements elementUtils, Types typeUtils) {
		super(typeVariable, elementUtils, typeUtils);

		this.typeVariable = typeVariable;

	}

	@Override
	public JavaType getUpperBound() {
		return getTypeAdapter(typeVariable.getUpperBound());
	}

	@Override
	public JavaType getLowerBound() {
		return getTypeAdapter(typeVariable.getLowerBound());
	}

	@Override
	protected Class<? extends JavaTypeVariable> getAdaptedInterface() {
		return JavaTypeVariable.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaTypeVariable copy() {
		throw calculatedMethodException();
	}

}
