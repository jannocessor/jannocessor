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
