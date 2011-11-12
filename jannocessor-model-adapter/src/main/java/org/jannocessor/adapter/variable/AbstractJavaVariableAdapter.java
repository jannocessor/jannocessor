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
