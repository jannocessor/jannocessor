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

import javax.annotation.Generated;

import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.value.AnnotationModifierValue;
import org.jannocessor.model.structure.JavaMetadata;

public class Annotations {

	/** Represents the default annotation modifier. */
	public static final AnnotationModifiers DEFAULT_MODIFIER = New
			.annotationModifiers();

	/** Represents "public" annotation modifier. */
	public static final AnnotationModifiers PUBLIC = New
			.annotationModifiers(AnnotationModifierValue.PUBLIC);

	/** Represents "public abstract" interface modifiers. */
	public static final AnnotationModifiers PUBLIC_ABSTRACT = New
			.annotationModifiers(AnnotationModifierValue.PUBLIC,
					AnnotationModifierValue.ABSTRACT);

	/** Represents "abstract" interface modifier. */
	public static final AnnotationModifiers ABSTRACT = New
			.annotationModifiers(AnnotationModifierValue.ABSTRACT);

	public static JavaMetadata generated(String value) {
		return New.metadata(Generated.class, value);
	}

	public static JavaMetadata override() {
		return New.metadata(Override.class);
	}

}
