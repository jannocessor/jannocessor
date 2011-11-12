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

import javax.lang.model.type.ArrayType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ModelUtils;

public class JavaArrayTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaArrayType {

	private static final long serialVersionUID = -8431107976792077987L;
	private final ArrayType arrayType;

	public JavaArrayTypeAdapter(ArrayType arrayType, Elements elementUtils,
			Types typeUtils) {
		super(arrayType, elementUtils, typeUtils);

		this.arrayType = arrayType;

	}

	@Override
	public JavaType getComponentType() {
		return getTypeAdapter(arrayType.getComponentType());
	}

	@Override
	protected Class<? extends JavaArrayType> getAdaptedInterface() {
		return JavaArrayType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaArrayType copy() {
		throw calculatedMethodException();
	}

}
