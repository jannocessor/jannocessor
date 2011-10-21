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

package org.jannocessor.adapter.executable;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;

abstract class AbstractJavaExecutableAdapter extends JavaElementAdapter
		implements AbstractJavaExecutable {

	private static final long serialVersionUID = -5004287664697277125L;

	private final ExecutableElement executable;

	private final JavaBody body = New.body();

	public AbstractJavaExecutableAdapter(ExecutableElement executable,
			Elements elementUtils, Types typeUtils) {
		super(executable, elementUtils, typeUtils);
		this.executable = executable;
	}

	public PowerList<JavaTypeParameter> getTypeParameters() {
		return getElementsAdapters(executable.getTypeParameters(),
				JavaTypeParameter.class);
	}

	public JavaType getReturnType() {
		return getTypeAdapter(executable.getReturnType());
	}

	public PowerList<JavaParameter> getParameters() {
		return getElementsAdapters(executable.getParameters(),
				JavaParameter.class);
	}

	public Boolean isVarArgs() {
		return executable.isVarArgs();
	}

	public PowerList<JavaType> getThrownTypes() {
		PowerList<JavaType> adapters = Power.list();

		for (TypeMirror typeMirror : executable.getThrownTypes()) {
			adapters.add(getTypeAdapter(typeMirror));
		}

		return adapters;
	}

	@Override
	public JavaBody getBody() {
		return this.body;
	}

	@Override
	protected Class<? extends AbstractJavaExecutable> getAdaptedInterface() {
		return AbstractJavaExecutable.class;
	}

}
