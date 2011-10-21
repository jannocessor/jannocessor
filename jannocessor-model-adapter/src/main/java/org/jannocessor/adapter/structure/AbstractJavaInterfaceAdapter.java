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

}
