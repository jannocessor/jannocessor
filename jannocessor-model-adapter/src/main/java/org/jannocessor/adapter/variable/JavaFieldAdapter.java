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
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaField;

public final class JavaFieldAdapter extends AbstractJavaVariableAdapter
		implements JavaField {

	private static final long serialVersionUID = 197580621670549990L;

	private final VariableElement field;

	private final JavaExpression value;

	public JavaFieldAdapter(VariableElement field, Elements elementUtils,
			Types typeUtils) {
		super(field, elementUtils, typeUtils);

		this.field = field;
		this.value = getConstantExpression();
	}

	@Override
	public FieldModifiers getModifiers() {
		Set<Modifier> modifiers = field.getModifiers();
		final FieldModifierValue[] values = new FieldModifierValue[modifiers
				.size()];

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

}
