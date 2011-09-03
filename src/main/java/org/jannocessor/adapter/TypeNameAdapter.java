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

import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.domain.JavaTypeName;
import org.jannocessor.domain.Text;

public class TypeNameAdapter extends AbstractAdapter implements JavaTypeName {

	private final String typeName;

	public TypeNameAdapter(String typeName, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.typeName = typeName;
	}

	@Override
	public Text getFull() {
		return getTextAdapter(typeName);
	}

	@Override
	public Text getSimple() {
		int pos = typeName.lastIndexOf('.');
		return getTextAdapter(pos >= 0 ? typeName.substring(pos + 1) : typeName);
	}

	@Override
	public Text getPackage() {
		int pos = typeName.lastIndexOf('.');
		return getTextAdapter(pos >= 0 ? typeName.substring(0, pos) : null);
	}

}
