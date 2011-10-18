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

import org.jannocessor.model.bean.modifier.MethodModifiersBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.value.MethodModifierValue;
import org.jannocessor.model.util.New;

public final class JavaMethodAdapter extends AbstractJavaExecutableAdapter
		implements JavaMethod {

	private final ExecutableElement method;

	public JavaMethodAdapter(ExecutableElement method, Elements elementUtils,
			Types typeUtils) {
		super(method, elementUtils, typeUtils);
		this.setCode(New.code(JavaMethod.class));
		this.setBody(New.body(JavaMethod.class));
		this.method = method;
	}

	@Override
	public MethodModifiers getModifiers() {
		Set<Modifier> modifiers = method.getModifiers();
		final MethodModifierValue[] values = new MethodModifierValue[modifiers
				.size()];

		int index = 0;
		for (Modifier modifier : modifiers) {
			values[index++] = MethodModifierValue.valueOf(modifier.name());
		}

		return new MethodModifiersBean(values);
	}

}
