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

	@Override
	public AbstractJavaAnnotation copy() {
		throw calculatedMethodException();
	}

}
