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

import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.value.ClassModifierValue;

public class Classes {

	/** Represents the default class modifier. */
	public static final ClassModifiers DEFAULT_MODIFIER = New.classModifiers();

	/** Represents "public" class modifier. */
	public static final ClassModifiers PUBLIC = New
			.classModifiers(ClassModifierValue.PUBLIC);

	/** Represents "public abstract" class modifiers. */
	public static final ClassModifiers PUBLIC_ABSTRACT = New.classModifiers(
			ClassModifierValue.PUBLIC, ClassModifierValue.ABSTRACT);

	/** Represents "public final" class modifiers. */
	public static final ClassModifiers PUBLIC_FINAL = New.classModifiers(
			ClassModifierValue.PUBLIC, ClassModifierValue.FINAL);

	/** Represents "abstract" class modifier. */
	public static final ClassModifiers ABSTRACT = New
			.classModifiers(ClassModifierValue.ABSTRACT);

	/** Represents "final" class modifier. */
	public static final ClassModifiers FINAL = New
			.classModifiers(ClassModifierValue.FINAL);

}
