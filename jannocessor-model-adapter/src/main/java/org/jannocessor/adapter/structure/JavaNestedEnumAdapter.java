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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.NestedEnumModifiersBean;
import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.modifier.value.NestedEnumModifierValue;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.util.ModelUtils;

public final class JavaNestedEnumAdapter extends AbstractJavaEnumAdapter
		implements JavaNestedEnum {

	private static final long serialVersionUID = 2204313585154783825L;
	@SuppressWarnings("unused")
	private final TypeElement tenum;

	public JavaNestedEnumAdapter(TypeElement tenum, Elements elementUtils,
			Types typeUtils) {
		super(tenum, elementUtils, typeUtils);

		this.tenum = tenum;
	}

	@Override
	public NestedEnumModifiers getModifiers() {
		return new NestedEnumModifiersBean(
				getModifierValues(NestedEnumModifierValue.class));
	}

	@Override
	protected Class<? extends JavaNestedEnum> getAdaptedInterface() {
		return JavaNestedEnum.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public AbstractJavaStructure getParent() {
		return super.retrieveParent();
	}

	@Override
	public JavaNestedEnum copy() {
		throw calculatedMethodException();
	}

}
