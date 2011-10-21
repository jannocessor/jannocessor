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

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.transform.api.Transformation;
import org.jannocessor.model.bean.structure.JavaAnnotationAttributeBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaAnnotation;
import org.jannocessor.model.structure.JavaAnnotationAttribute;

abstract class AbstractJavaAnnotationAdapter extends
		AbstractJavaStructureAdapter implements AbstractJavaAnnotation {

	private static final long serialVersionUID = -3693116263568298976L;

	private static final Transformation<JavaMethod, JavaAnnotationAttribute> METHOD_TO_ATTRIBUTE;

	@SuppressWarnings("unused")
	private final TypeElement annotation;

	static {
		METHOD_TO_ATTRIBUTE = new Transformation<JavaMethod, JavaAnnotationAttribute>() {
			@Override
			public JavaAnnotationAttribute transform(JavaMethod method) {
				return new JavaAnnotationAttributeBean(method.getReturnType(),
						method.getName().getText(), null);
			}
		};
	}

	public AbstractJavaAnnotationAdapter(TypeElement annotation,
			Elements elementUtils, Types typeUtils) {
		super(annotation, elementUtils, typeUtils);
		this.annotation = annotation;
	}

	@Override
	public PowerList<JavaAnnotationAttribute> getAttributes() {
		return findChildrenByType(JavaMethod.class).getTransformed(
				METHOD_TO_ATTRIBUTE);
	}

	@Override
	protected Class<? extends AbstractJavaAnnotation> getAdaptedInterface() {
		return AbstractJavaAnnotation.class;
	}

}
