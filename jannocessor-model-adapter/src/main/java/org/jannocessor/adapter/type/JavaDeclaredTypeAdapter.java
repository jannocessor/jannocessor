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
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ModelUtils;

public class JavaDeclaredTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaDeclaredType {

	private static final long serialVersionUID = -5338242663715964532L;
	private final DeclaredType declaredType;

	public JavaDeclaredTypeAdapter(DeclaredType declaredType,
			Elements elementUtils, Types typeUtils) {
		super(declaredType, elementUtils, typeUtils);
		this.declaredType = declaredType;

	}

	@Override
	public PowerList<JavaType> getTypeArguments() {
		return getTypeAdapters(declaredType.getTypeArguments());
	}

	@Override
	protected Class<? extends JavaDeclaredType> getAdaptedInterface() {
		return JavaDeclaredType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaDeclaredType copy() {
		throw calculatedMethodException();
	}

}
