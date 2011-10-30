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

package org.jannocessor.adapter.type;

import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.ModelUtils;

public class JavaExecutableTypeAdapter extends AbstractJavaTypeAdapter implements
		JavaExecutableType {

	private static final long serialVersionUID = 6878540706508272046L;
	private final ExecutableType executableType;

	public JavaExecutableTypeAdapter(ExecutableType executableType,
			Elements elementUtils, Types typeUtils) {
		super(executableType, elementUtils, typeUtils);

		this.executableType = executableType;

	}

	@Override
	public PowerList<JavaType> getParameterTypes() {
		return getTypeAdapters(executableType.getParameterTypes());
	}

	@Override
	public JavaType getReturnType() {
		return getTypeAdapter(executableType.getReturnType());
	}

	@Override
	public PowerList<JavaDeclaredType> getThrownTypes() {
		return getTypeAdapters(executableType.getThrownTypes(),
				JavaDeclaredType.class);
	}

	@Override
	public PowerList<JavaTypeVariable> getTypeVariables() {
		return getTypeAdapters(executableType.getTypeVariables(),
				JavaTypeVariable.class);
	}

	@Override
	protected Class<? extends JavaExecutableType> getAdaptedInterface() {
		return JavaExecutableType.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaExecutableType copy() {
		throw calculatedMethodException();
	}

}
