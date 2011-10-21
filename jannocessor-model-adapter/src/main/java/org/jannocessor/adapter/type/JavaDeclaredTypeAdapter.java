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

package org.jannocessor.adapter.type;

import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaType;

public class JavaDeclaredTypeAdapter extends JavaTypeAdapter implements
		JavaDeclaredType {

	private static final long serialVersionUID = -5338242663715964532L;
	private final DeclaredType declaredType;

	public JavaDeclaredTypeAdapter(DeclaredType declaredType,
			Elements elementUtils, Types typeUtils) {
		super(declaredType, elementUtils, typeUtils);

		this.declaredType = declaredType;

	}

	@Override
	public PowerList<JavaType> getTypeArguments() {
		return getTypeAdapters(declaredType.getTypeArguments());
	}

	@Override
	protected Class<? extends JavaDeclaredType> getAdaptedInterface() {
		return JavaDeclaredType.class;
	}

}
