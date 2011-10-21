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
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;

public class JavaMetadataAdapter extends JavaCodeModelAdapter implements
		JavaMetadata {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7187042825188441175L;
	private final AnnotationMirror annotationMirror;

	public JavaMetadataAdapter(AnnotationMirror annotationMirror,
			Elements elementUtils, Types typeUtils) {
		super(elementUtils, typeUtils);
		this.annotationMirror = annotationMirror;
		this.getCode().assign(New.code(JavaMetadata.class));
	}

	@Override
	public JavaType getAnnotation() {
		return getTypeAdapter(annotationMirror.getAnnotationType());
	}

	@Override
	public PowerMap<String, Object> getValues() {
		return extractValues(annotationMirror.getElementValues());
	}

	@Override
	public PowerMap<String, Object> getValuesWithDefaults() {
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

}
