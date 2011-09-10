/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.processor.model;

import javax.lang.model.element.TypeElement;

import org.jannocessor.model.JavaElement;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;

public class Mark {

	private final TypeElement annotation;
	private final String label;

	private JavaElement element;
	private JavaClass clazz;

	public Mark(TypeElement annotation, JavaElement element, String label) {
		this.annotation = annotation;
		this.label = label;
		this.element = element;

		if (element instanceof JavaClass) {
			clazz = (JavaClass) element;
		}
	}

	public TypeElement getAnnotation() {
		return annotation;
	}

	public JavaElement getElement() {
		return element;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public String toString() {
		return "Mark [annotation=" + annotation + ", element=" + element
				+ ", label=" + label + "]";
	}

	public JavaClass getClazz() {
		return clazz;
	}
	
}
