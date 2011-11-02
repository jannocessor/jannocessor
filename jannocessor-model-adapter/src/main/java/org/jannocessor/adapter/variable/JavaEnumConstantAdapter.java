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

import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.structure.AbstractJavaEnum;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaEnumConstant;

public final class JavaEnumConstantAdapter extends AbstractJavaVariableAdapter implements
		JavaEnumConstant {

	private static final long serialVersionUID = 436532312737957029L;

	@SuppressWarnings("unused")
	private final VariableElement enumConstant;

	private final PowerList<JavaExpression> values = Power.list();

	public JavaEnumConstantAdapter(VariableElement enumConstant, Elements elementUtils,
			Types typeUtils) {
		super(enumConstant, elementUtils, typeUtils);

		this.enumConstant = enumConstant;
	}

	@Override
	public PowerList<JavaExpression> getValues() {
		return values;
	}

	@Override
	protected Class<? extends JavaEnumConstant> getAdaptedInterface() {
		return JavaEnumConstant.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaEnumConstant copy() {
		throw calculatedMethodException();
	}

	@Override
	public AbstractJavaEnum getParent() {
		return retrieveParent();
	}

}
