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

import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.ModelUtils;

public final class JavaTypeParameterAdapter extends JavaElementAdapter
		implements JavaTypeParameter {

	private static final long serialVersionUID = 2154181045998797757L;

	private static final Criteria<JavaType> DEFAULT_BOUND;

	private final TypeParameterElement typeParameter;

	static {
		DEFAULT_BOUND = Power.criteria(new Condition<JavaType>() {
			@Override
			public boolean satisfies(JavaType type) {
				return type.getKind() == JavaTypeKind.DECLARED
						&& Object.class.equals(type.getTypeClass());
			}
		});
	}

	public JavaTypeParameterAdapter(TypeParameterElement typeParameter,
			Elements elementUtils, Types typeUtils) {
		super(typeParameter, elementUtils, typeUtils);

		this.typeParameter = typeParameter;
	}

	@Override
	public PowerList<JavaType> getBounds() {
		return getTypeAdapters(typeParameter.getBounds()).remove(DEFAULT_BOUND);
	}

	@Override
	protected Class<? extends JavaTypeParameter> getAdaptedInterface() {
		return JavaTypeParameter.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaTypeParameter copy() {
		throw calculatedMethodException();
	}

}
