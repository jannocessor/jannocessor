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

import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.modifier.value.NestedEnumModifierValue;

public class NestedEnums {

	/** Represents the default nested class modifier. */
	public static final NestedEnumModifiers DEFAULT_MODIFIER = New
			.nestedEnumModifiers();

	/** Represents "public" nested class modifiers. */
	public static final NestedEnumModifiers PUBLIC = New
			.nestedEnumModifiers(NestedEnumModifierValue.PUBLIC);

	/** Represents "public static" nested class modifiers. */
	public static final NestedEnumModifiers PUBLIC_STATIC = New
			.nestedEnumModifiers(NestedEnumModifierValue.PUBLIC,
					NestedEnumModifierValue.STATIC);

	/** Represents "private" nested class modifiers. */
	public static final NestedEnumModifiers PRIVATE = New
			.nestedEnumModifiers(NestedEnumModifierValue.PRIVATE);

	/** Represents "private static" nested class modifiers. */
	public static final NestedEnumModifiers PRIVATE_STATIC = New
			.nestedEnumModifiers(NestedEnumModifierValue.PRIVATE,
					NestedEnumModifierValue.STATIC);

	/** Represents "protected" nested class modifiers. */
	public static final NestedEnumModifiers PROTECTED = New
			.nestedEnumModifiers(NestedEnumModifierValue.PROTECTED);

	/** Represents "protected static" nested class modifiers. */
	public static final NestedEnumModifiers PROTECTED_STATIC = New
			.nestedEnumModifiers(NestedEnumModifierValue.PROTECTED,
					NestedEnumModifierValue.STATIC);

	/** Represents "static" nested class modifiers. */
	public static final NestedEnumModifiers STATIC = New
			.nestedEnumModifiers(NestedEnumModifierValue.STATIC);

}
