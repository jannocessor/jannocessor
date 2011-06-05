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

public class ElementAdapter extends AbstractAdapter implements JavaElement,
		SourceHolder {

	private final Element element;

	public ElementAdapter(Element element) {
		this.element = element;
	}

	@Override
	public JavaElement getParent() {
		Element parent = element.getEnclosingElement();
		if (parent != null) {
			return getAdapterFor(parent);
		} else {
			return null;
		}
	}

	@Override
	public List<JavaElement> getChildren() {
		List<JavaElement> children = new ArrayList<JavaElement>();

		for (Element enclosedElement : element.getEnclosedElements()) {
			children.add(getAdapterFor(enclosedElement));
		}

		return children;
	}

	@Override
	public String getName() {
		return element.getSimpleName().toString();
	}

	@Override
	public String getKind() {
		return element.getKind().toString().toLowerCase();
	}

	@Override
	public Element retrieveSourceElement() {
		return element;
	}

	@Override
	public String toString() {
		return "{name=" + getName() + ", children=" + show(getChildren())
				+ ", parent=" + show(getParent()) + ", kind=" + getKind() + "}";
	}

	private String show(List<JavaElement> children) {
		StringBuilder sb = new StringBuilder();

		sb.append("[");

		for (int i = 0; i < children.size(); i++) {
			JavaElement element = children.get(i);
			sb.append(show(element));
			if (i < children.size() - 1) {
				sb.append(", ");
			}
		}
		sb.append("]");

		return sb.toString();
	}

	private String show(JavaElement element) {
		return "{name=" + element.getName() + ", kind=" + element.getKind()
				+ "}";
	}

}
