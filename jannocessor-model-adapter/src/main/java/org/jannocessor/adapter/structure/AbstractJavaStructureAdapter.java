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

	private static final long serialVersionUID = -1171708337294305207L;
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
		return getAnnotatedMetadata();
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

	@Override
	protected Class<? extends AbstractJavaStructure> getAdaptedInterface() {
		return AbstractJavaStructure.class;
	}

	@Override
	public AbstractJavaStructure copy() {
		throw calculatedMethodException();
	}

}
