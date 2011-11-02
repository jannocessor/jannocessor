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

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.AbstractJavaVariable;

abstract class AbstractJavaVariableAdapter extends JavaElementAdapter implements
		AbstractJavaVariable {

	private static final long serialVersionUID = 837222250253517508L;
	private final VariableElement variable;

	public AbstractJavaVariableAdapter(VariableElement variable, Elements elementUtils,
			Types typeUtils) {
		super(variable, elementUtils, typeUtils);
		this.variable = variable;
	}

	protected JavaExpression getConstantExpression() {
		Object constantValue = variable.getConstantValue();
		if (constantValue != null) {
			// it can be String or primitive type
			if (constantValue instanceof String) {
				return New.literal((String) constantValue);
			} else {
				return New.expression(String.valueOf(constantValue));
			}
		} else {
			return New.expression();
		}
	}

	@Override
	protected Class<? extends AbstractJavaVariable> getAdaptedInterface() {
		return AbstractJavaVariable.class;
	}

	@Override
	public JavaElement getParent() {
		return super.retrieveParent();
	}

	@Override
	public AbstractJavaVariable copy() {
		throw calculatedMethodException();
	}

}
