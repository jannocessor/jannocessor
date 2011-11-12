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
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaField;

abstract class AbstractJavaClassAdapter extends AbstractJavaStructureAdapter
		implements AbstractJavaClass {

	private static final long serialVersionUID = 3057258745502923931L;
	private final TypeElement tclass;

	public AbstractJavaClassAdapter(TypeElement tclass, Elements elementUtils,
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
	public PowerList<JavaStaticInit> getStaticInits() {
		return findChildrenByType(JavaStaticInit.class);
	}

	@Override
	public PowerList<JavaInstanceInit> getInstanceInits() {
		return findChildrenByType(JavaInstanceInit.class);
	}

	@Override
	public PowerList<JavaTypeParameter> getTypeParameters() {
		return getElementsAdapters(tclass.getTypeParameters(),
				JavaTypeParameter.class);
	}

	@Override
	protected Class<? extends AbstractJavaClass> getAdaptedInterface() {
		return AbstractJavaClass.class;
	}

	@Override
	public AbstractJavaClass copy() {
		throw calculatedMethodException();
	}

}
