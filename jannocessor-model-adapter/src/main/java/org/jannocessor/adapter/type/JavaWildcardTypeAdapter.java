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

import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaWildcardType;

public class JavaWildcardTypeAdapter extends JavaTypeAdapter implements
		JavaWildcardType {

	private static final long serialVersionUID = 6558226673234282372L;
	private final WildcardType wildcardType;

	public JavaWildcardTypeAdapter(WildcardType wildcardType,
			Elements elementUtils, Types typeUtils) {
		super(wildcardType, elementUtils, typeUtils);

		this.wildcardType = wildcardType;

	}

	@Override
	public JavaType getExtendsBound() {
		return getTypeAdapter(wildcardType.getExtendsBound());
	}

	@Override
	public JavaType getSuperBound() {
		return getTypeAdapter(wildcardType.getSuperBound());
	}

	@Override
	protected Class<? extends JavaWildcardType> getAdaptedInterface() {
		return JavaWildcardType.class;
	}

}
