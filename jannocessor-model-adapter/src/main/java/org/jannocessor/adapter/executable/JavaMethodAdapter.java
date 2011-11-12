/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.adapter.executable;

import java.util.Set;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.MethodModifiersBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.value.MethodModifierValue;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;

public final class JavaMethodAdapter extends AbstractJavaExecutableAdapter
		implements JavaMethod {

	private static final long serialVersionUID = -2502354526306569829L;
	private final ExecutableElement method;

	public JavaMethodAdapter(ExecutableElement method, Elements elementUtils,
			Types typeUtils) {
		super(method, elementUtils, typeUtils);

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

	@Override
	public PowerList<JavaMetadata> getMetadata() {
		return getAnnotatedMetadata();
	}

	@Override
	protected Class<? extends JavaMethod> getAdaptedInterface() {
		return JavaMethod.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaMethod copy() {
		throw calculatedMethodException();
	}

}
