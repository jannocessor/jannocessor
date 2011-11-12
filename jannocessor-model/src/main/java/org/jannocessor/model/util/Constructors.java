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

import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;

public class Constructors {

	/** Represents the default constructor modifier. */
	public static final ConstructorModifiers DEFAULT_MODIFIER = New
			.constructorModifiers();

	/** Represents "public" constructor modifier. */
	public static final ConstructorModifiers PUBLIC = New
			.constructorModifiers(ConstructorModifierValue.PUBLIC);

	/** Represents "private" constructor modifier. */
	public static final ConstructorModifiers PRIVATE = New
			.constructorModifiers(ConstructorModifierValue.PRIVATE);

	/** Represents "protected" constructor modifier. */
	public static final ConstructorModifiers PROTECTED = New
			.constructorModifiers(ConstructorModifierValue.PROTECTED);

}
