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

import org.jannocessor.model.modifier.NestedInterfaceModifiers;
import org.jannocessor.model.modifier.value.NestedInterfaceModifierValue;

public class NestedInterfaces {

	/** Represents the default nested class modifier. */
	public static final NestedInterfaceModifiers DEFAULT_MODIFIER = Code
			.nestedInterfaceModifiers();

	/** Represents "public" nested class modifiers. */
	public static final NestedInterfaceModifiers PUBLIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PUBLIC);

	/** Represents "public abstract" nested class modifiers. */
	public static final NestedInterfaceModifiers PUBLIC_ABSTRACT = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PUBLIC,
					NestedInterfaceModifierValue.ABSTRACT);

	/** Represents "public abstract static" nested class modifiers. */
	public static final NestedInterfaceModifiers PUBLIC_ABSTRACT_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PUBLIC,
					NestedInterfaceModifierValue.ABSTRACT,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "public static" nested class modifiers. */
	public static final NestedInterfaceModifiers PUBLIC_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PUBLIC,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "private" nested class modifiers. */
	public static final NestedInterfaceModifiers PRIVATE = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PRIVATE);

	/** Represents "private abstract" nested class modifiers. */
	public static final NestedInterfaceModifiers PRIVATE_ABSTRACT = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PRIVATE,
					NestedInterfaceModifierValue.ABSTRACT);

	/** Represents "private abstract static" nested class modifiers. */
	public static final NestedInterfaceModifiers PRIVATE_ABSTRACT_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PRIVATE,
					NestedInterfaceModifierValue.ABSTRACT,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "private static" nested class modifiers. */
	public static final NestedInterfaceModifiers PRIVATE_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PRIVATE,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "protected" nested class modifiers. */
	public static final NestedInterfaceModifiers PROTECTED = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PROTECTED);

	/** Represents "protected abstract" nested class modifiers. */
	public static final NestedInterfaceModifiers PROTECTED_ABSTRACT = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PROTECTED,
					NestedInterfaceModifierValue.ABSTRACT);

	/** Represents "protected abstract static" nested class modifiers. */
	public static final NestedInterfaceModifiers PROTECTED_ABSTRACT_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PROTECTED,
					NestedInterfaceModifierValue.ABSTRACT,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "protected static" nested class modifiers. */
	public static final NestedInterfaceModifiers PROTECTED_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.PROTECTED,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "abstract" nested class modifiers. */
	public static final NestedInterfaceModifiers ABSTRACT = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.ABSTRACT);

	/** Represents "abstract static" nested class modifiers. */
	public static final NestedInterfaceModifiers ABSTRACT_STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.ABSTRACT,
					NestedInterfaceModifierValue.STATIC);

	/** Represents "static" nested class modifiers. */
	public static final NestedInterfaceModifiers STATIC = Code
			.nestedInterfaceModifiers(NestedInterfaceModifierValue.STATIC);

}
