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

import org.jannocessor.model.modifier.NestedAnnotationModifiers;
import org.jannocessor.model.modifier.value.NestedAnnotationModifierValue;

public class NestedAnnotations {

	/** Represents the default nested class modifier. */
	public static final NestedAnnotationModifiers DEFAULT_MODIFIER = New
			.nestedAnnotationModifiers();

	/** Represents "public" nested class modifiers. */
	public static final NestedAnnotationModifiers PUBLIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PUBLIC);

	/** Represents "public abstract" nested class modifiers. */
	public static final NestedAnnotationModifiers PUBLIC_ABSTRACT = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PUBLIC,
					NestedAnnotationModifierValue.ABSTRACT);

	/** Represents "public abstract static" nested class modifiers. */
	public static final NestedAnnotationModifiers PUBLIC_ABSTRACT_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PUBLIC,
					NestedAnnotationModifierValue.ABSTRACT,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "public static" nested class modifiers. */
	public static final NestedAnnotationModifiers PUBLIC_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PUBLIC,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "private" nested class modifiers. */
	public static final NestedAnnotationModifiers PRIVATE = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PRIVATE);

	/** Represents "private abstract" nested class modifiers. */
	public static final NestedAnnotationModifiers PRIVATE_ABSTRACT = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PRIVATE,
					NestedAnnotationModifierValue.ABSTRACT);

	/** Represents "private abstract static" nested class modifiers. */
	public static final NestedAnnotationModifiers PRIVATE_ABSTRACT_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PRIVATE,
					NestedAnnotationModifierValue.ABSTRACT,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "private static" nested class modifiers. */
	public static final NestedAnnotationModifiers PRIVATE_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PRIVATE,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "protected" nested class modifiers. */
	public static final NestedAnnotationModifiers PROTECTED = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PROTECTED);

	/** Represents "protected abstract" nested class modifiers. */
	public static final NestedAnnotationModifiers PROTECTED_ABSTRACT = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PROTECTED,
					NestedAnnotationModifierValue.ABSTRACT);

	/** Represents "protected abstract static" nested class modifiers. */
	public static final NestedAnnotationModifiers PROTECTED_ABSTRACT_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PROTECTED,
					NestedAnnotationModifierValue.ABSTRACT,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "protected static" nested class modifiers. */
	public static final NestedAnnotationModifiers PROTECTED_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.PROTECTED,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "abstract" nested class modifiers. */
	public static final NestedAnnotationModifiers ABSTRACT = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.ABSTRACT);

	/** Represents "abstract static" nested class modifiers. */
	public static final NestedAnnotationModifiers ABSTRACT_STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.ABSTRACT,
					NestedAnnotationModifierValue.STATIC);

	/** Represents "static" nested class modifiers. */
	public static final NestedAnnotationModifiers STATIC = New
			.nestedAnnotationModifiers(NestedAnnotationModifierValue.STATIC);

}
