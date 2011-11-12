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

import javax.lang.model.type.NoType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaVoidType;
import org.jannocessor.model.util.ModelUtils;

public class JavaVoidTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaVoidType {

	private static final long serialVersionUID = 8556334335757463508L;
	@SuppressWarnings("unused")
	private final NoType noType;

	public JavaVoidTypeAdapter(NoType noType, Elements elementUtils,
			Types typeUtils) {
		super(noType, elementUtils, typeUtils);

		this.noType = noType;

	}

	@Override
	protected Class<? extends JavaVoidType> getAdaptedInterface() {
		return JavaVoidType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaVoidType copy() {
		throw calculatedMethodException();
	}

}
