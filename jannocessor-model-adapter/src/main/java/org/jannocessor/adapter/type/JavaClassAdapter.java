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

package org.jannocessor.adapter.type;

import java.util.List;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.variable.JavaField;

public final class JavaClassAdapter extends JavaTypeAdapter implements
		JavaClass {

	@SuppressWarnings("unused")
	private final TypeElement tclass;

	public JavaClassAdapter(TypeElement tclass, Elements elementUtils,
			Types typeUtils) {
		super(tclass, elementUtils, typeUtils);
		this.tclass = tclass;
	}

	@Override
	public List<JavaField> getFields() {
		return findChildrenByType(JavaField.class);
	}

	@Override
	public List<JavaConstructor> getConstructors() {
		return findChildrenByType(JavaConstructor.class);
	}

	@Override
	public List<JavaMethod> getMethods() {
		return findChildrenByType(JavaMethod.class);
	}

	@Override
	public List<JavaStaticInit> getStaticInits() {
		return findChildrenByType(JavaStaticInit.class);
	}

	@Override
	public List<JavaInstanceInit> getInstanceInits() {
		return findChildrenByType(JavaInstanceInit.class);
	}

}
