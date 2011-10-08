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

import org.jannocessor.model.modifier.NestedClassModifiers;
import org.jannocessor.model.modifier.value.NestedClassModifierValue;

public class NestedClasses {

	/** Represents the default nested class modifier. */
	public static final NestedClassModifiers DEFAULT_MODIFIER = Code
			.nestedClassModifiers();

	/** Represents "public" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC);

	/** Represents "public abstract" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_ABSTRACT = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "public abstract static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_ABSTRACT_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "public final" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_FINAL = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.FINAL);

	/** Represents "public final static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_FINAL_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "public static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.STATIC);

	/** Represents "private" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE);

	/** Represents "private abstract" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_ABSTRACT = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "private abstract static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_ABSTRACT_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "private final" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_FINAL = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.FINAL);

	/** Represents "private final static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_FINAL_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "private static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.STATIC);

	/** Represents "protected" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED);

	/** Represents "protected abstract" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_ABSTRACT = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "protected abstract static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_ABSTRACT_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "protected final" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_FINAL = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.FINAL);

	/** Represents "protected final static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_FINAL_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "protected static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.STATIC);

	/** Represents "abstract" nested class modifiers. */
	public static final NestedClassModifiers ABSTRACT = Code
			.nestedClassModifiers(NestedClassModifierValue.ABSTRACT);

	/** Represents "abstract static" nested class modifiers. */
	public static final NestedClassModifiers ABSTRACT_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "final" nested class modifiers. */
	public static final NestedClassModifiers FINAL = Code
			.nestedClassModifiers(NestedClassModifierValue.FINAL);

	/** Represents "final static" nested class modifiers. */
	public static final NestedClassModifiers FINAL_STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "static" nested class modifiers. */
	public static final NestedClassModifiers STATIC = Code
			.nestedClassModifiers(NestedClassModifierValue.STATIC);

}
