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
