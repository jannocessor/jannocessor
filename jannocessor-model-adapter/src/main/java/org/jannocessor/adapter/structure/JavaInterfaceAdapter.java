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

}
