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
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.bean.modifier.AnnotationModifiersBean;
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.value.AnnotationModifierValue;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.ModelUtils;

public final class JavaAnnotationAdapter extends AbstractJavaAnnotationAdapter
		implements JavaAnnotation {

	private static final long serialVersionUID = 2236908518207225010L;
	@SuppressWarnings("unused")
	private final TypeElement annotation;

	public JavaAnnotationAdapter(TypeElement annotation, Elements elementUtils,
			Types typeUtils) {
		super(annotation, elementUtils, typeUtils);

		this.annotation = annotation;
	}

	@Override
	public AnnotationModifiers getModifiers() {
		return new AnnotationModifiersBean(
				getModifierValues(AnnotationModifierValue.class));
	}

	@Override
	protected Class<? extends JavaAnnotation> getAdaptedInterface() {
		return JavaAnnotation.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaPackage getParent() {
		return super.retrieveParent();
	}

	@Override
	public JavaAnnotation copy() {
		throw calculatedMethodException();
	}

}
