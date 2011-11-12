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

import javax.lang.model.element.Modifier;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaLocalVariable;

public final class JavaLocalVariableAdapter extends AbstractJavaVariableAdapter implements
		JavaLocalVariable {

	private static final long serialVersionUID = -328115801660017048L;
	private final VariableElement localVariable;

	public JavaLocalVariableAdapter(VariableElement localVariable, Elements elementUtils,
			Types typeUtils) {
		super(localVariable, elementUtils, typeUtils);

		this.localVariable = localVariable;
	}

	@Override
	public Boolean isFinal() {
		return localVariable.getModifiers().contains(Modifier.FINAL);
	}

	@Override
	protected Class<? extends JavaLocalVariable> getAdaptedInterface() {
		return JavaLocalVariable.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaLocalVariable copy() {
		throw calculatedMethodException();
	}

	@Override
	public AbstractJavaExecutable getParent() {
		return retrieveParent();
	}

}
