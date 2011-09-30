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

package org.jannocessor.adapter.structure;

import java.util.Set;

import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.ClassModifierValue;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.variable.JavaField;

public final class JavaClassAdapter extends AbstractJavaTypeAdapter implements
		JavaClass {

	private final TypeElement tclass;

	public JavaClassAdapter(TypeElement tclass, Elements elementUtils,
			Types typeUtils) {
		super(tclass, elementUtils, typeUtils);
		this.tclass = tclass;
	}

	@Override
	public PowerList<JavaField> getFields() {
		return findChildrenByType(JavaField.class);
	}

	@Override
	public PowerList<JavaConstructor> getConstructors() {
		return findChildrenByType(JavaConstructor.class);
	}

	@Override
	public PowerList<JavaMethod> getMethods() {
		return findChildrenByType(JavaMethod.class);
	}

	@Override
	public PowerList<JavaStaticInit> getStaticInits() {
		return findChildrenByType(JavaStaticInit.class);
	}

	@Override
	public PowerList<JavaInstanceInit> getInstanceInits() {
		return findChildrenByType(JavaInstanceInit.class);
	}

	@Override
	public ClassModifiers getModifiers() {
		Set<Modifier> modifiers = tclass.getModifiers();
		final ClassModifierValue[] values = new ClassModifierValue[modifiers
				.size()];

		int index = 0;
		for (Modifier modifier : modifiers) {
			values[index++] = ClassModifierValue.valueOf(modifier.name());
		}

		return new ClassModifiers() {
			@Override
			public ClassModifierValue[] getValues() {
				return values;
			}
		};
	}

	@Override
	public PowerList<JavaNestedClass> getNestedClasses() {
		return findChildrenByType(JavaNestedClass.class);
	}

	@Override
	public PowerList<JavaNestedEnum> getNestedEnums() {
		return findChildrenByType(JavaNestedEnum.class);
	}

	@Override
	public PowerList<JavaNestedInterface> getNestedInterfaces() {
		return findChildrenByType(JavaNestedInterface.class);
	}

	@Override
	public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
		return findChildrenByType(JavaNestedAnnotation.class);
	}

}
