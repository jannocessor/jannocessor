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
import org.jannocessor.model.bean.modifier.InterfaceModifiersBean;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.value.InterfaceModifierValue;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.ModelUtils;

public final class JavaInterfaceAdapter extends AbstractJavaInterfaceAdapter
		implements JavaInterface {

	private static final long serialVersionUID = -2461593767762457193L;
	@SuppressWarnings("unused")
	private final TypeElement tinterface;

	public JavaInterfaceAdapter(TypeElement tinterface, Elements elementUtils,
			Types typeUtils) {
		super(tinterface, elementUtils, typeUtils);

		this.tinterface = tinterface;
	}

	@Override
	public InterfaceModifiers getModifiers() {
		return new InterfaceModifiersBean(
				getModifierValues(InterfaceModifierValue.class));
	}

	@Override
	protected Class<? extends JavaInterface> getAdaptedInterface() {
		return JavaInterface.class;
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
	public JavaInterface copy() {
		throw calculatedMethodException();
	}

}
