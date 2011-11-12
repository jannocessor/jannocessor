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

package org.jannocessor.adapter.variable;

import java.util.Set;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.FieldModifiersBean;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.value.FieldModifierValue;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaField;

public final class JavaFieldAdapter extends AbstractJavaVariableAdapter implements JavaField {

	private static final long serialVersionUID = 197580621670549990L;

	private final VariableElement field;

	private final JavaExpression value;

	public JavaFieldAdapter(VariableElement field, Elements elementUtils, Types typeUtils) {
		super(field, elementUtils, typeUtils);

		this.field = field;
		this.value = getConstantExpression();
	}

	@Override
	public FieldModifiers getModifiers() {
		Set<Modifier> modifiers = field.getModifiers();
		final FieldModifierValue[] values = new FieldModifierValue[modifiers.size()];

		int index = 0;
		for (Modifier modifier : modifiers) {
			values[index++] = FieldModifierValue.valueOf(modifier.name());
		}

		return new FieldModifiersBean(values);
	}

	@Override
	public JavaExpression getValue() {
		return value;
	}

	@Override
	public PowerList<JavaMetadata> getMetadata() {
		return getAnnotatedMetadata();
	}

	@Override
	protected Class<? extends JavaField> getAdaptedInterface() {
		return JavaField.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaField copy() {
		throw calculatedMethodException();
	}

	@Override
	public AbstractJavaStructure getParent() {
		return retrieveParent();
	}

}
