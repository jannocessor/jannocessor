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

import org.jannocessor.model.modifier.NestedClassModifiers;
import org.jannocessor.model.modifier.value.NestedClassModifierValue;

public class NestedClasses {

	/** Represents the default nested class modifier. */
	public static final NestedClassModifiers DEFAULT_MODIFIER = New
			.nestedClassModifiers();

	/** Represents "public" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC);

	/** Represents "public abstract" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_ABSTRACT = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "public abstract static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_ABSTRACT_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "public final" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_FINAL = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.FINAL);

	/** Represents "public final static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_FINAL_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "public static" nested class modifiers. */
	public static final NestedClassModifiers PUBLIC_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PUBLIC,
					NestedClassModifierValue.STATIC);

	/** Represents "private" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE);

	/** Represents "private abstract" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_ABSTRACT = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "private abstract static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_ABSTRACT_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "private final" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_FINAL = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.FINAL);

	/** Represents "private final static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_FINAL_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "private static" nested class modifiers. */
	public static final NestedClassModifiers PRIVATE_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PRIVATE,
					NestedClassModifierValue.STATIC);

	/** Represents "protected" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED);

	/** Represents "protected abstract" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_ABSTRACT = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.ABSTRACT);

	/** Represents "protected abstract static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_ABSTRACT_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "protected final" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_FINAL = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.FINAL);

	/** Represents "protected final static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_FINAL_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "protected static" nested class modifiers. */
	public static final NestedClassModifiers PROTECTED_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.PROTECTED,
					NestedClassModifierValue.STATIC);

	/** Represents "abstract" nested class modifiers. */
	public static final NestedClassModifiers ABSTRACT = New
			.nestedClassModifiers(NestedClassModifierValue.ABSTRACT);

	/** Represents "abstract static" nested class modifiers. */
	public static final NestedClassModifiers ABSTRACT_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.ABSTRACT,
					NestedClassModifierValue.STATIC);

	/** Represents "final" nested class modifiers. */
	public static final NestedClassModifiers FINAL = New
			.nestedClassModifiers(NestedClassModifierValue.FINAL);

	/** Represents "final static" nested class modifiers. */
	public static final NestedClassModifiers FINAL_STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.FINAL,
					NestedClassModifierValue.STATIC);

	/** Represents "static" nested class modifiers. */
	public static final NestedClassModifiers STATIC = New
			.nestedClassModifiers(NestedClassModifierValue.STATIC);

}
