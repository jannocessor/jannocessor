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
import org.jannocessor.model.bean.modifier.NestedAnnotationModifiersBean;
import org.jannocessor.model.modifier.NestedAnnotationModifiers;
import org.jannocessor.model.modifier.value.NestedAnnotationModifierValue;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.util.ModelUtils;

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

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public AbstractJavaStructure getParent() {
		return super.retrieveParent();
	}

	@Override
	public JavaNestedAnnotation copy() {
		throw calculatedMethodException();
	}

}
