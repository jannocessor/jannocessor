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

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaExceptionParameter;

public final class JavaExceptionParameterAdapter extends
		AbstractJavaVariableAdapter implements JavaExceptionParameter {

	private static final long serialVersionUID = -4815832690663017141L;
	@SuppressWarnings("unused")
	private final VariableElement exceptionParameter;

	public JavaExceptionParameterAdapter(VariableElement exceptionParameter,
			Elements elementUtils, Types typeUtils) {
		super(exceptionParameter, elementUtils, typeUtils);

		this.exceptionParameter = exceptionParameter;
	}

	@Override
	protected Class<? extends JavaExceptionParameter> getAdaptedInterface() {
		return JavaExceptionParameter.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaExceptionParameter copy() {
		throw calculatedMethodException();
	}

}
