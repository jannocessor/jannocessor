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

import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import org.jannocessor.domain.JavaElement;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Name;
import org.jannocessor.domain.Text;

public abstract class ElementAdapter extends AbstractAdapter implements
		JavaElement, SourceHolder {

	private final Element element;

	public ElementAdapter(Element element) {
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

	@Override
	public List<JavaElement> getChildren() {
		List<JavaElement> children = new ArrayList<JavaElement>();

		for (Element enclosedElement : element.getEnclosedElements()) {
			children.add(getElementAdapter(enclosedElement, JavaElement.class));
		}

		return children;
	}

	@Override
	public Name getName() {
		return getNameAdapter(element.getSimpleName().toString());
	}

	@Override
	public Text getKind() {
		return getTextAdapter(element.getKind().toString().toLowerCase());
	}

	@Override
	public Element retrieveSourceElement() {
		return element;
	}

	@Override
	public JavaElementType getType() {
		return getTypeAdapter(element.asType());
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> findChildrenByType(Class<T> clazz) {
		List<T> results = new ArrayList<T>();

		for (JavaElement child : getChildren()) {
			if (clazz.isAssignableFrom(child.getClass())) {
				results.add((T) child);
			}
		}
		return results;
	}

}
