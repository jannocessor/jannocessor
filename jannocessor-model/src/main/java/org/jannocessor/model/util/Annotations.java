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
