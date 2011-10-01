/**
 * Copyright 2011 jannocessor.org
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
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.type.JavaType;

abstract class AbstractJavaStructureAdapter extends JavaElementAdapter implements
		AbstractJavaStructure {

	private final TypeElement type;

	public AbstractJavaStructureAdapter(TypeElement type, Elements elementUtils,
			Types typeUtils) {
		super(type, elementUtils, typeUtils);
		this.type = type;
	}

	@Override
	public String getNesting() {
		return type.getNestingKind().toString();
	}

	@Override
	public Name getQualifiedName() {
		return getNameAdapter(type.getQualifiedName().toString());
	}

	@Override
	public JavaType getSuperclass() {
		return getTypeAdapter(type.getSuperclass());
	}

	@Override
	public Name getPackageName() {
		String fullName = type.getQualifiedName().toString();
		int pos = fullName.lastIndexOf('.');
		String packageName = (pos >= 0) ? fullName.substring(0, pos) : null;
		return getNameAdapter(packageName);
	}

	@Override
	public PowerList<JavaType> getInterfaces() {
		PowerList<JavaType> adapters = Power.list();

		for (TypeMirror tinterface : type.getInterfaces()) {
			adapters.add(getTypeAdapter(tinterface));
		}

		return adapters;
	}

}
