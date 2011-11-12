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
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaParameter;

public final class JavaParameterAdapter extends AbstractJavaVariableAdapter
		implements JavaParameter {

	private static final long serialVersionUID = 4304123692935787081L;
	private final VariableElement parameter;

	public JavaParameterAdapter(VariableElement parameter,
			Elements elementUtils, Types typeUtils) {
		super(parameter, elementUtils, typeUtils);

		this.parameter = parameter;
	}

	@Override
	public boolean isFinal() {
		return parameter.getModifiers().contains(Modifier.FINAL);
	}

	@Override
	public PowerList<JavaMetadata> getMetadata() {
		return getAnnotatedMetadata();
	}

	@Override
	protected Class<? extends JavaParameter> getAdaptedInterface() {
		return JavaParameter.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaParameter copy() {
		throw calculatedMethodException();
	}

	@Override
	public AbstractJavaExecutable getParent() {
		return retrieveParent();
	}

}
