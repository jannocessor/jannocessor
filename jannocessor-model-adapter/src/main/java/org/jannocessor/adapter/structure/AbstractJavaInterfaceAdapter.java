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
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaField;

abstract class AbstractJavaInterfaceAdapter extends
		AbstractJavaStructureAdapter implements AbstractJavaInterface {

	private static final long serialVersionUID = -3728020235818316455L;
	private final TypeElement tinterface;

	public AbstractJavaInterfaceAdapter(TypeElement tinterface,
			Elements elementUtils, Types typeUtils) {
		super(tinterface, elementUtils, typeUtils);
		this.tinterface = tinterface;
	}

	@Override
	public PowerList<JavaMethod> getMethods() {
		return findChildrenByType(JavaMethod.class);
	}

	@Override
	public PowerList<JavaTypeParameter> getTypeParameters() {
		return getElementsAdapters(tinterface.getTypeParameters(),
				JavaTypeParameter.class);
	}

	@Override
	public PowerList<JavaField> getFields() {
		return findChildrenByType(JavaField.class);
	}

	@Override
	protected Class<? extends AbstractJavaInterface> getAdaptedInterface() {
		return AbstractJavaInterface.class;
	}

	@Override
	public AbstractJavaInterface copy() {
		throw calculatedMethodException();
	}

}
