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
import org.jannocessor.model.structure.AbstractJavaEnum;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;

abstract class AbstractJavaEnumAdapter extends AbstractJavaStructureAdapter
		implements AbstractJavaEnum {

	private static final long serialVersionUID = -95951993222943561L;
	@SuppressWarnings("unused")
	private final TypeElement tenum;

	public AbstractJavaEnumAdapter(TypeElement tenum, Elements elementUtils,
			Types typeUtils) {
		super(tenum, elementUtils, typeUtils);
		this.tenum = tenum;
	}

	@Override
	public PowerList<JavaEnumConstant> getValues() {
		return findChildrenByType(JavaEnumConstant.class);
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
	protected Class<? extends AbstractJavaEnum> getAdaptedInterface() {
		return AbstractJavaEnum.class;
	}

	@Override
	public AbstractJavaEnum copy() {
		throw calculatedMethodException();
	}

}
