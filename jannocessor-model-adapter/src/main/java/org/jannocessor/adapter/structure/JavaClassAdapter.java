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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.ClassModifiersBean;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.value.ClassModifierValue;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.ModelUtils;

public final class JavaClassAdapter extends AbstractJavaClassAdapter implements
		JavaClass {

	private static final long serialVersionUID = 1860883523822681244L;
	@SuppressWarnings("unused")
	private final TypeElement tclass;

	public JavaClassAdapter(TypeElement tclass, Elements elementUtils,
			Types typeUtils) {
		super(tclass, elementUtils, typeUtils);

		this.tclass = tclass;
	}

	@Override
	public ClassModifiers getModifiers() {
		return new ClassModifiersBean(
				getModifierValues(ClassModifierValue.class));
	}

	@Override
	protected Class<? extends JavaClass> getAdaptedInterface() {
		return JavaClass.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaPackage getParent() {
		return super.retrieveParent();
	}

	@Override
	public JavaClass copy() {
		throw calculatedMethodException();
	}

}
