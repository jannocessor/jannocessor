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

import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.value.InterfaceModifierValue;

public class Interfaces {

	/** Represents the default interface modifier. */
	public static final InterfaceModifiers DEFAULT_MODIFIER = New
			.interfaceModifiers();

	/** Represents "public" interface modifier. */
	public static final InterfaceModifiers PUBLIC = New
			.interfaceModifiers(InterfaceModifierValue.PUBLIC);

	/** Represents "public abstract" interface modifiers. */
	public static final InterfaceModifiers PUBLIC_ABSTRACT = New
			.interfaceModifiers(InterfaceModifierValue.PUBLIC,
					InterfaceModifierValue.ABSTRACT);

	/** Represents "abstract" interface modifier. */
	public static final InterfaceModifiers ABSTRACT = New
			.interfaceModifiers(InterfaceModifierValue.ABSTRACT);

}
