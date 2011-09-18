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

package org.jannocessor.adapter;

import java.util.List;

import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaType;
import org.jannocessor.model.Name;

public final class JavaTypeAdapter extends AbstractAdapter implements JavaType {

	private final TypeMirror typeMirror;

	public JavaTypeAdapter(TypeMirror typeMirror, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.typeMirror = typeMirror;
	}

	@Override
	public Name getCanonicalName() {
		return getNameAdapter(typeMirror.toString());
	}

	@Override
	public Name getSimpleName() {
		return getNameAdapter(typeMirror.toString());
	}

	@Override
	public PowerList<JavaType> getDirectSupertypes() {
		List<? extends TypeMirror> supertypes = getTypeUtils()
				.directSupertypes(typeMirror);

		PowerList<JavaType> result = Power.list();
		for (TypeMirror supertype : supertypes) {
			result.add(getTypeAdapter(supertype));
		}

		return result;
	}

}
