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

import org.jannocessor.model.bean.modifier.NestedEnumModifiersBean;
import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.modifier.value.NestedEnumModifierValue;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.util.New;

public final class JavaNestedEnumAdapter extends AbstractJavaEnumAdapter
		implements JavaNestedEnum {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2204313585154783825L;
	@SuppressWarnings("unused")
	private final TypeElement tenum;

	public JavaNestedEnumAdapter(TypeElement tenum, Elements elementUtils,
			Types typeUtils) {
		super(tenum, elementUtils, typeUtils);
		this.getCode().assign(New.code(JavaNestedEnum.class));
		this.tenum = tenum;
	}

	@Override
	public NestedEnumModifiers getModifiers() {
		return new NestedEnumModifiersBean(
				getModifierValues(NestedEnumModifierValue.class));
	}

}
