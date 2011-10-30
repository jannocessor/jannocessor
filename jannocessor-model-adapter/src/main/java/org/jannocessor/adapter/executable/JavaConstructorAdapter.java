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

import java.util.Set;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.modifier.ConstructorModifiersBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;

public final class JavaConstructorAdapter extends AbstractJavaExecutableAdapter
		implements JavaConstructor {

	private static final long serialVersionUID = 4244716840887854699L;
	private final ExecutableElement constructor;

	public JavaConstructorAdapter(ExecutableElement constructor,
			Elements elementUtils, Types typeUtils) {
		super(constructor, elementUtils, typeUtils);

		this.constructor = constructor;
	}

	@Override
	public ConstructorModifiers getModifiers() {
		Set<Modifier> modifiers = constructor.getModifiers();
		final ConstructorModifierValue[] values = new ConstructorModifierValue[modifiers
				.size()];

		int index = 0;
		for (Modifier modifier : modifiers) {
			values[index++] = ConstructorModifierValue.valueOf(modifier.name());
		}

		return new ConstructorModifiersBean(values);
	}

	@Override
	public Name getName() {
		return null;
	}

	@Override
	public PowerList<JavaMetadata> getMetadata() {
		return getAnnotatedMetadata();
	}

	@Override
	protected Class<? extends JavaConstructor> getAdaptedInterface() {
		return JavaConstructor.class;
	}

	@Override
	public Boolean isDefault() {
		throw calculatedMethodException();
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaConstructor copy() {
		throw calculatedMethodException();
	}

}
