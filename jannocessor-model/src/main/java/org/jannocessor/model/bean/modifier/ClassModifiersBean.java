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

package org.jannocessor.model.bean.modifier;

import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.value.ClassModifierValue;

public class ClassModifiersBean extends
		AbstractModifiersBean<ClassModifierValue, ClassModifiers> implements
		ClassModifiers {

	
	private static final long serialVersionUID = -1163517897727959762L;

	public ClassModifiersBean(ClassModifierValue[] values) {
		super(values, ClassModifiers.class);
	}

}