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

package org.jannocessor.adapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;

public abstract class JavaElementAdapter extends JavaCodeModelAdapter implements
		JavaElement, SourceHolder {

	private final Element element;

	public JavaElementAdapter(Element element, Elements elementUtils,
			Types typeUtils) {
		super(elementUtils, typeUtils);
		this.element = element;
	}

	@Override
	public JavaElement getParent() {
		Element parent = element.getEnclosingElement();
		if (parent != null) {
			return getElementAdapter(parent, JavaElement.class);
		} else {
			return null;
		}
	}

	private List<? extends Element> getEnclosedElements(Element element) {
		if (element == null) {
			throw new IllegalArgumentException("The element must not be NULL!");
		}

		try {
			// sometimes a strange NPE arises here, it's probably a bug
			return element.getEnclosedElements();
		} catch (Exception e) {
			return new ArrayList<Element>();
		}
	}

	@Override
	public PowerList<JavaElement> getChildren() {
		PowerList<JavaElement> children = Power.list();

		for (Element enclosedElement : getEnclosedElements(element)) {
			children.add(getElementAdapter(enclosedElement, JavaElement.class));
		}

		return children;
	}

	@Override
	public Name getName() {
		return getNameAdapter(element.getSimpleName().toString());
	}

	@Override
	public Element retrieveSourceElement() {
		return element;
	}

	@Override
	public JavaType getType() {
		return getTypeAdapter(element.asType());
	}

	@SuppressWarnings("unchecked")
	protected <T> PowerList<T> findChildrenByType(Class<T> clazz) {
		PowerList<T> results = Power.list();

		for (JavaElement child : getChildren()) {
			if (clazz.isAssignableFrom(child.getClass())) {
				results.add((T) child);
			}
		}
		return results;
	}

	@SuppressWarnings("unchecked")
	protected <T extends Enum<T>> T[] getModifierValues(Class<T> enumType) {
		Set<Modifier> modifiers = element.getModifiers();
		final T[] values = (T[]) Array.newInstance(enumType, modifiers.size());

		int index = 0;
		for (Modifier modifier : modifiers) {
			values[index++] = Enum.valueOf(enumType, modifier.name());
		}

		return values;
	}

}
