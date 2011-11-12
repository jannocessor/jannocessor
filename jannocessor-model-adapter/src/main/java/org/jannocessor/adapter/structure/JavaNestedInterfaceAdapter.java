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
import org.jannocessor.model.bean.modifier.NestedInterfaceModifiersBean;
import org.jannocessor.model.modifier.NestedInterfaceModifiers;
import org.jannocessor.model.modifier.value.NestedInterfaceModifierValue;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.util.ModelUtils;

public final class JavaNestedInterfaceAdapter extends
		AbstractJavaInterfaceAdapter implements JavaNestedInterface {

	private static final long serialVersionUID = 4430990112271319170L;
	@SuppressWarnings("unused")
	private final TypeElement tinterface;

	public JavaNestedInterfaceAdapter(TypeElement tinterface,
			Elements elementUtils, Types typeUtils) {
		super(tinterface, elementUtils, typeUtils);

		this.tinterface = tinterface;
	}

	@Override
	public NestedInterfaceModifiers getModifiers() {
		return new NestedInterfaceModifiersBean(
				getModifierValues(NestedInterfaceModifierValue.class));
	}

	@Override
	protected Class<? extends JavaNestedInterface> getAdaptedInterface() {
		return JavaNestedInterface.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public AbstractJavaStructure getParent() {
		return super.retrieveParent();
	}

	@Override
	public JavaNestedInterface copy() {
		throw calculatedMethodException();
	}

}
