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

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaCodeModelAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaEnumConstant;

public class JavaMetadataAdapter extends JavaCodeModelAdapter implements
		JavaMetadata {

	private static final long serialVersionUID = -7187042825188441175L;

	private final AnnotationMirror annotationMirror;

	public JavaMetadataAdapter(AnnotationMirror annotationMirror,
			Elements elementUtils, Types typeUtils) {
		super(elementUtils, typeUtils);
		this.annotationMirror = annotationMirror;

	}

	@Override
	public JavaType getAnnotation() {
		return getTypeAdapter(annotationMirror.getAnnotationType());
	}

	@Override
	public PowerMap<String, Object> getValues() {
		return extractValues(annotationMirror.getElementValues());
	}

	public PowerMap<String, Object> getValuesWithDefaults() {
		// FIXME: publish to the API as read-only property
		return extractValues(getElementUtils().getElementValuesWithDefaults(
				annotationMirror));
	}

	private PowerMap<String, Object> extractValues(
			Map<? extends ExecutableElement, ? extends AnnotationValue> elementValues) {
		PowerMap<String, Object> values = Power.map();

		for (Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : elementValues
				.entrySet()) {
			String key = entry.getKey().getSimpleName().toString();
			Object value = translate(entry.getValue().getValue());
			values.put(key, value);
		}

		return values;
	}

	@SuppressWarnings("unchecked")
	private Object translate(Object value) {
		if (value instanceof List) {
			PowerList<Object> values = Power.list();
			List<? extends AnnotationValue> list = (List<? extends AnnotationValue>) value;
			for (AnnotationValue annotationValue : list) {
				values.add(translate(annotationValue.getValue()));
			}
			return values;
		}

		if (value instanceof VariableElement) {
			VariableElement variableElement = (VariableElement) value;
			return getElementAdapter(variableElement, JavaEnumConstant.class);
		}

		if (value instanceof TypeMirror) {
			TypeMirror typeMirror = (TypeMirror) value;
			return getTypeAdapter(typeMirror);
		}

		if (value instanceof AnnotationMirror) {
			AnnotationMirror annotationMirror = (AnnotationMirror) value;
			return getMetadataAdapter(annotationMirror);
		}

		return value;
	}

	@Override
	public JavaElement getParent() {
		return null;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	protected Class<? extends JavaMetadata> getAdaptedInterface() {
		return JavaMetadata.class;
	}

	@Override
	public JavaMetadata copy() {
		throw calculatedMethodException();
	}

}
