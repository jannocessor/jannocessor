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

import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.value.InterfaceModifierValue;

public class Interfaces {

	/** Represents the default interface modifier. */
	public static final InterfaceModifiers DEFAULT_MODIFIER = Code
			.interfaceModifiers();

	/** Represents "public" interface modifier. */
	public static final InterfaceModifiers PUBLIC = Code
			.interfaceModifiers(InterfaceModifierValue.PUBLIC);

	/** Represents "public abstract" interface modifiers. */
	public static final InterfaceModifiers PUBLIC_ABSTRACT = Code
			.interfaceModifiers(InterfaceModifierValue.PUBLIC,
					InterfaceModifierValue.ABSTRACT);

	/** Represents "abstract" interface modifier. */
	public static final InterfaceModifiers ABSTRACT = Code
			.interfaceModifiers(InterfaceModifierValue.ABSTRACT);

}
