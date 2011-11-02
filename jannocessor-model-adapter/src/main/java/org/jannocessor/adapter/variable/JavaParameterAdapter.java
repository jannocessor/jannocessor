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
