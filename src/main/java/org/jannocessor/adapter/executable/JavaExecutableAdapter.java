/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.adapter.executable;

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;

import org.jannocessor.adapter.ElementAdapter;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Text;
import org.jannocessor.domain.executable.JavaExecutable;
import org.jannocessor.domain.type.JavaTypeParameter;
import org.jannocessor.domain.variable.JavaParameter;

abstract class JavaExecutableAdapter extends ElementAdapter implements
		JavaExecutable {

	private final ExecutableElement executable;

	public JavaExecutableAdapter(ExecutableElement executable) {
		super(executable);
		this.executable = executable;
	}

	@Override
	public List<JavaTypeParameter> getTypeParameters() {
		List<JavaTypeParameter> adapters = new ArrayList<JavaTypeParameter>();

		for (TypeParameterElement typeParameter : executable
				.getTypeParameters()) {
			JavaTypeParameter adapter = getElementAdapter(typeParameter,
					JavaTypeParameter.class);
			adapters.add(adapter);
		}

		return adapters;
	}

	@Override
	public JavaElementType getReturnType() {
		return getTypeAdapter(executable.getReturnType());
	}

	@Override
	public List<JavaParameter> getParameters() {
		List<JavaParameter> adapters = new ArrayList<JavaParameter>();

		for (VariableElement variable : executable.getParameters()) {
			JavaParameter adapter = getElementAdapter(variable,
					JavaParameter.class);
			adapters.add(adapter);
		}

		return adapters;
	}

	@Override
	public boolean getVarArgs() {
		return executable.isVarArgs();
	}

	@Override
	public List<JavaElementType> getThrownTypes() {
		List<JavaElementType> adapters = new ArrayList<JavaElementType>();

		for (TypeMirror typeMirror : executable.getThrownTypes()) {
			adapters.add(getTypeAdapter(typeMirror));
		}

		return adapters;
	}

	@Override
	public Text getDefault() {
		return getTextAdapter(executable.getDefaultValue());
	}

}
