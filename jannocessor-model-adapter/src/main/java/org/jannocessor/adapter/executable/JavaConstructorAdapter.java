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
