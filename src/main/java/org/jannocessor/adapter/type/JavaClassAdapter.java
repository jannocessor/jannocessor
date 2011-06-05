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

import org.jannocessor.domain.executable.JavaConstructor;
import org.jannocessor.domain.executable.JavaInstanceInit;
import org.jannocessor.domain.executable.JavaMethod;
import org.jannocessor.domain.executable.JavaStaticInit;
import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.domain.variable.JavaField;

public final class JavaClassAdapter extends JavaTypeAdapter implements
		JavaClass {

	@SuppressWarnings("unused")
	private final TypeElement tclass;

	public JavaClassAdapter(TypeElement tclass) {
		super(tclass);
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
