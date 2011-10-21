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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.bean.modifier.NestedAnnotationModifiersBean;
import org.jannocessor.model.modifier.NestedAnnotationModifiers;
import org.jannocessor.model.modifier.value.NestedAnnotationModifierValue;
import org.jannocessor.model.structure.JavaNestedAnnotation;

public final class JavaNestedAnnotationAdapter extends
		AbstractJavaAnnotationAdapter implements JavaNestedAnnotation {

	private static final long serialVersionUID = 2448738435842709024L;
	@SuppressWarnings("unused")
	private final TypeElement annotation;

	public JavaNestedAnnotationAdapter(TypeElement annotation,
			Elements elementUtils, Types typeUtils) {
		super(annotation, elementUtils, typeUtils);

		this.annotation = annotation;
	}

	@Override
	public NestedAnnotationModifiers getModifiers() {
		return new NestedAnnotationModifiersBean(
				getModifierValues(NestedAnnotationModifierValue.class));
	}

	@Override
	protected Class<? extends JavaNestedAnnotation> getAdaptedInterface() {
		return JavaNestedAnnotation.class;
	}

}
