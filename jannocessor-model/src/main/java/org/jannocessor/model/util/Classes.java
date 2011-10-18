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
