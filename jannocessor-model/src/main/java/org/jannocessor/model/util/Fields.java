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

package org.jannocessor.model.util;

import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.value.FieldModifierValue;

public class Fields {

	/** Represents the default field modifier. */
	public static final FieldModifiers DEFAULT_MODIFIER = Code.fieldModifiers();

	/** Represents "public" field modifier. */
	public static final FieldModifiers PUBLIC = Code
			.fieldModifiers(FieldModifierValue.PUBLIC);

	/** Represents "public static" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC = Code.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.STATIC);

	/** Represents "public static final" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_FINAL = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "public static final transient" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "public static transient" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "public static transient volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "public static volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "public final" field modifiers. */
	public static final FieldModifiers PUBLIC_FINAL = Code.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.FINAL);

	/** Represents "public final transient" field modifiers. */
	public static final FieldModifiers PUBLIC_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "public transient" field modifiers. */
	public static final FieldModifiers PUBLIC_TRANSIENT = Code.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.TRANSIENT);

	/** Represents "public transient volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "public volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_VOLATILE = Code.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.VOLATILE);

	/** Represents "protected" field modifier. */
	public static final FieldModifiers PROTECTED = Code
			.fieldModifiers(FieldModifierValue.PROTECTED);

	/** Represents "protected static" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC = Code.fieldModifiers(
			FieldModifierValue.PROTECTED, FieldModifierValue.STATIC);

	/** Represents "protected static final" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_FINAL = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "protected static final transient" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "protected static transient" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "protected static transient volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "protected static volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "protected final" field modifiers. */
	public static final FieldModifiers PROTECTED_FINAL = Code.fieldModifiers(
			FieldModifierValue.PROTECTED, FieldModifierValue.FINAL);

	/** Represents "protected final transient" field modifiers. */
	public static final FieldModifiers PROTECTED_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "protected transient" field modifiers. */
	public static final FieldModifiers PROTECTED_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.TRANSIENT);

	/** Represents "protected transient volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "protected volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.VOLATILE);

	/** Represents "private" field modifier. */
	public static final FieldModifiers PRIVATE = Code
			.fieldModifiers(FieldModifierValue.PRIVATE);

	/** Represents "private static" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC = Code.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.STATIC);

	/** Represents "private static final" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_FINAL = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "private static final transient" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "private static transient" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "private static transient volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "private static volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "private final" field modifier. */
	public static final FieldModifiers PRIVATE_FINAL = Code.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.FINAL);

	/** Represents "private final transient" field modifiers. */
	public static final FieldModifiers PRIVATE_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "private transient" field modifiers. */
	public static final FieldModifiers PRIVATE_TRANSIENT = Code.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.TRANSIENT);

	/** Represents "private transient volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "private volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_VOLATILE = Code.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.VOLATILE);

	/** Represents "static" field modifier. */
	public static final FieldModifiers STATIC = Code
			.fieldModifiers(FieldModifierValue.STATIC);

	/** Represents "static final" field modifiers. */
	public static final FieldModifiers STATIC_FINAL = Code.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "static final transient" field modifiers. */
	public static final FieldModifiers STATIC_FINAL_TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.STATIC,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "static transient" field modifiers. */
	public static final FieldModifiers STATIC_TRANSIENT = Code.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "static transient volatile" field modifiers. */
	public static final FieldModifiers STATIC_TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.STATIC,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "static volatile" field modifiers. */
	public static final FieldModifiers STATIC_VOLATILE = Code.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "final" field modifier. */
	public static final FieldModifiers FINAL = Code
			.fieldModifiers(FieldModifierValue.FINAL);

	/** Represents "final transient" field modifiers. */
	public static final FieldModifiers FINAL_TRANSIENT = Code.fieldModifiers(
			FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "transient" field modifiers. */
	public static final FieldModifiers TRANSIENT = Code
			.fieldModifiers(FieldModifierValue.TRANSIENT);

	/** Represents "transient volatile" field modifiers. */
	public static final FieldModifiers TRANSIENT_VOLATILE = Code
			.fieldModifiers(FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "volatile" field modifier. */
	public static final FieldModifiers VOLATILE = Code
			.fieldModifiers(FieldModifierValue.VOLATILE);

}
