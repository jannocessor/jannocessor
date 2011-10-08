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

package org.jannocessor.model.util;

import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;

public class Constructors {

	/** Represents the default constructor modifier. */
	public static final ConstructorModifiers DEFAULT_MODIFIER = Code
			.constructorModifiers();

	/** Represents "public" constructor modifier. */
	public static final ConstructorModifiers PUBLIC = Code
			.constructorModifiers(ConstructorModifierValue.PUBLIC);

	/** Represents "private" constructor modifier. */
	public static final ConstructorModifiers PRIVATE = Code
			.constructorModifiers(ConstructorModifierValue.PRIVATE);

	/** Represents "protected" constructor modifier. */
	public static final ConstructorModifiers PROTECTED = Code
			.constructorModifiers(ConstructorModifierValue.PROTECTED);

}
