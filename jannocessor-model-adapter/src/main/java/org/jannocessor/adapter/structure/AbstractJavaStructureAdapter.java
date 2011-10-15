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

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.type.JavaType;

abstract class AbstractJavaStructureAdapter extends JavaElementAdapter
		implements AbstractJavaStructure {

	private final TypeElement type;

	public AbstractJavaStructureAdapter(TypeElement type,
			Elements elementUtils, Types typeUtils) {
		super(type, elementUtils, typeUtils);
		this.type = type;
	}

	@Override
	public String getNesting() {
		return type.getNestingKind().toString();
	}

	@Override
	public Name getQualifiedName() {
		return getNameAdapter(type.getQualifiedName().toString());
	}

	@Override
	public JavaType getSuperclass() {
		return getTypeAdapter(type.getSuperclass());
	}

	@Override
	public PowerList<JavaMetadata> getMetadata() {
		PowerList<JavaMetadata> results = Power.list();

		for (AnnotationMirror annotationMirror : type.getAnnotationMirrors()) {
			results.add(getMetadataAdapter(annotationMirror));
		}

		return results;
	}

	@Override
	public PowerList<JavaMetadata> getAllMetadata() {
		PowerList<JavaMetadata> results = Power.list();

		for (AnnotationMirror annotationMirror : getElementUtils()
				.getAllAnnotationMirrors(type)) {
			results.add(getMetadataAdapter(annotationMirror));
		}

		return results;
	}

	@Override
	public Name getPackageName() {
		String fullName = type.getQualifiedName().toString();
		int pos = fullName.lastIndexOf('.');
		String packageName = (pos >= 0) ? fullName.substring(0, pos) : null;
		return getNameAdapter(packageName);
	}

	@Override
	public PowerList<JavaType> getInterfaces() {
		PowerList<JavaType> adapters = Power.list();

		for (TypeMirror tinterface : type.getInterfaces()) {
			adapters.add(getTypeAdapter(tinterface));
		}

		return adapters;
	}

	@Override
	public PowerList<JavaMethod> getMethods() {
		return findChildrenByType(JavaMethod.class);
	}

	@Override
	public PowerList<JavaNestedClass> getNestedClasses() {
		return findChildrenByType(JavaNestedClass.class);
	}

	@Override
	public PowerList<JavaNestedEnum> getNestedEnums() {
		return findChildrenByType(JavaNestedEnum.class);
	}

	@Override
	public PowerList<JavaNestedInterface> getNestedInterfaces() {
		return findChildrenByType(JavaNestedInterface.class);
	}

	@Override
	public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
		return findChildrenByType(JavaNestedAnnotation.class);
	}

}
