/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.model.util;

import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.value.FieldModifierValue;

public class Fields {

	/** Represents the default field modifier. */
	public static final FieldModifiers DEFAULT_MODIFIER = New.fieldModifiers();

	/** Represents "public" field modifier. */
	public static final FieldModifiers PUBLIC = New
			.fieldModifiers(FieldModifierValue.PUBLIC);

	/** Represents "public static" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC = New.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.STATIC);

	/** Represents "public static final" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_FINAL = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "public static final transient" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "public static transient" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "public static transient volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "public static volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_STATIC_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "public final" field modifiers. */
	public static final FieldModifiers PUBLIC_FINAL = New.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.FINAL);

	/** Represents "public final transient" field modifiers. */
	public static final FieldModifiers PUBLIC_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "public transient" field modifiers. */
	public static final FieldModifiers PUBLIC_TRANSIENT = New.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.TRANSIENT);

	/** Represents "public transient volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PUBLIC,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "public volatile" field modifiers. */
	public static final FieldModifiers PUBLIC_VOLATILE = New.fieldModifiers(
			FieldModifierValue.PUBLIC, FieldModifierValue.VOLATILE);

	/** Represents "protected" field modifier. */
	public static final FieldModifiers PROTECTED = New
			.fieldModifiers(FieldModifierValue.PROTECTED);

	/** Represents "protected static" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC = New.fieldModifiers(
			FieldModifierValue.PROTECTED, FieldModifierValue.STATIC);

	/** Represents "protected static final" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_FINAL = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "protected static final transient" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "protected static transient" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "protected static transient volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "protected static volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_STATIC_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "protected final" field modifiers. */
	public static final FieldModifiers PROTECTED_FINAL = New.fieldModifiers(
			FieldModifierValue.PROTECTED, FieldModifierValue.FINAL);

	/** Represents "protected final transient" field modifiers. */
	public static final FieldModifiers PROTECTED_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "protected transient" field modifiers. */
	public static final FieldModifiers PROTECTED_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.TRANSIENT);

	/** Represents "protected transient volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PROTECTED,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "protected volatile" field modifiers. */
	public static final FieldModifiers PROTECTED_VOLATILE = New.fieldModifiers(
			FieldModifierValue.PROTECTED, FieldModifierValue.VOLATILE);

	/** Represents "private" field modifier. */
	public static final FieldModifiers PRIVATE = New
			.fieldModifiers(FieldModifierValue.PRIVATE);

	/** Represents "private static" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC = New.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.STATIC);

	/** Represents "private static final" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_FINAL = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "private static final transient" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.FINAL,
					FieldModifierValue.TRANSIENT);

	/** Represents "private static transient" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "private static transient volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT,
					FieldModifierValue.VOLATILE);

	/** Represents "private static volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_STATIC_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "private final" field modifier. */
	public static final FieldModifiers PRIVATE_FINAL = New.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.FINAL);

	/** Represents "private final transient" field modifiers. */
	public static final FieldModifiers PRIVATE_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "private transient" field modifiers. */
	public static final FieldModifiers PRIVATE_TRANSIENT = New.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.TRANSIENT);

	/** Represents "private transient volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.PRIVATE,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "private volatile" field modifiers. */
	public static final FieldModifiers PRIVATE_VOLATILE = New.fieldModifiers(
			FieldModifierValue.PRIVATE, FieldModifierValue.VOLATILE);

	/** Represents "static" field modifier. */
	public static final FieldModifiers STATIC = New
			.fieldModifiers(FieldModifierValue.STATIC);

	/** Represents "static final" field modifiers. */
	public static final FieldModifiers STATIC_FINAL = New.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.FINAL);

	/** Represents "static final transient" field modifiers. */
	public static final FieldModifiers STATIC_FINAL_TRANSIENT = New
			.fieldModifiers(FieldModifierValue.STATIC,
					FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "static transient" field modifiers. */
	public static final FieldModifiers STATIC_TRANSIENT = New.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.TRANSIENT);

	/** Represents "static transient volatile" field modifiers. */
	public static final FieldModifiers STATIC_TRANSIENT_VOLATILE = New
			.fieldModifiers(FieldModifierValue.STATIC,
					FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "static volatile" field modifiers. */
	public static final FieldModifiers STATIC_VOLATILE = New.fieldModifiers(
			FieldModifierValue.STATIC, FieldModifierValue.VOLATILE);

	/** Represents "final" field modifier. */
	public static final FieldModifiers FINAL = New
			.fieldModifiers(FieldModifierValue.FINAL);

	/** Represents "final transient" field modifiers. */
	public static final FieldModifiers FINAL_TRANSIENT = New.fieldModifiers(
			FieldModifierValue.FINAL, FieldModifierValue.TRANSIENT);

	/** Represents "transient" field modifiers. */
	public static final FieldModifiers TRANSIENT = New
			.fieldModifiers(FieldModifierValue.TRANSIENT);

	/** Represents "transient volatile" field modifiers. */
	public static final FieldModifiers TRANSIENT_VOLATILE = New.fieldModifiers(
			FieldModifierValue.TRANSIENT, FieldModifierValue.VOLATILE);

	/** Represents "volatile" field modifier. */
	public static final FieldModifiers VOLATILE = New
			.fieldModifiers(FieldModifierValue.VOLATILE);

}
