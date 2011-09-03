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

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Iterator;

import javax.lang.model.element.Element;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;
import org.jannocessor.domain.JavaElement;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.JavaTypeName;
import org.jannocessor.domain.Name;
import org.jannocessor.domain.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class AbstractAdapter {

	enum TextMode {
		FULL, UP, DOWN
	}

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	private final BeanUtilsBean beanUtils = BeanUtilsBean.getInstance();

	private final PropertyUtilsBean propertyUtils = beanUtils
			.getPropertyUtils();

	private final Elements elementUtils;

	private final Types typeUtils;

	public AbstractAdapter(Elements elementUtils, Types typeUtils) {
		this.elementUtils = elementUtils;
		this.typeUtils = typeUtils;
	}

	protected <T extends JavaElement> T getElementAdapter(Element element,
			Class<T> clazz) {
		return AdapterFactory.getElementModel(element, clazz, elementUtils,
				typeUtils);
	}

	protected JavaElementType getTypeAdapter(TypeMirror typeMirror) {
		return AdapterFactory.getTypeModel(typeMirror, elementUtils, typeUtils);
	}

	protected JavaTypeName getTypeNameAdapter(String typeName) {
		return AdapterFactory.getTypeNameModel(typeName, elementUtils, typeUtils);
	}

	protected Text getTextAdapter(Object value) {
		return value != null ? AdapterFactory.getTextModel(String.valueOf(value))
				: null;
	}

	protected Name getNameAdapter(Object value) {
		return value != null ? AdapterFactory.getNameModel(String.valueOf(value))
				: null;
	}

	protected Elements getElementUtils() {
		return elementUtils;
	}

	protected Types getTypeUtils() {
		return typeUtils;
	}

	@Override
	public String toString() {
		return asText(TextMode.FULL);
	}

	@SuppressWarnings("unused")
	private String showAsParent() {
		return asText(TextMode.UP);
	}

	private String showAsChild() {
		return asText(TextMode.DOWN);
	}

	private String asText(TextMode mode) {
		try {
			StringBuilder sb = new StringBuilder();

			PropertyDescriptor[] descriptors = propertyUtils
					.getPropertyDescriptors(this);

			sb.append("{");
			boolean isFirst = true;
			for (int i = 0; i < descriptors.length; i++) {
				String name = descriptors[i].getName();
				Object value = propertyUtils.getProperty(this, name);

				if (!isPropertyForbidden(name, value, mode)) {
					if (!isFirst) {
						sb.append(", ");
					}
					isFirst = false;

					sb.append(name + "=" + showProperty(name, value));
				}
			}
			sb.append("}");

			return sb.toString();
		} catch (Exception e) {
			logger.error(
					"Error occured while constructing element textual representation",
					e);
			e.printStackTrace();
			return "ERROR";
		}

	}

	private boolean isPropertyForbidden(String name, Object value, TextMode mode) {
		if (name.equals("class")) {
			return true;
		} else {
			if (mode.equals(TextMode.FULL)) {
				return false;
			} else {
				return (value == null) || (value instanceof Collection)
						|| (value instanceof JavaElement);
			}
		}
	}

	private String showProperty(String name, Object value)
			throws IllegalAccessException, InvocationTargetException,
			NoSuchMethodException {
		if (value != null) {
			if (value instanceof AbstractAdapter
					&& !(value instanceof Text && !(value instanceof Name))) {
				// AbstractAdapter adapter = (AbstractAdapter) value;
				if (name.equals("parent")) {
					return "[...]"; // adapter.showAsParent();
				} else {
					return "[...]"; // adapter.showAsChild();
				}
			} else if (value instanceof Collection) {
				Collection<?> collection = (Collection<?>) value;
				return showMiniChildCollection(collection); // showChildCollection
			} else {
				return value.toString();
			}
		} else {
			return "NULL";
		}
	}

	private String showMiniChildCollection(Collection<?> collection) {
		return "[" + collection.size() + " items]";
	}

	@SuppressWarnings("unused")
	private String showChildCollection(Collection<?> collection) {
		StringBuilder sb = new StringBuilder();

		Iterator<?> iterator = collection.iterator();
		sb.append("[");

		while (iterator.hasNext()) {
			Object item = iterator.next();
			if (item instanceof AbstractAdapter && !(item instanceof Text)) {
				AbstractAdapter adapter = (AbstractAdapter) item;
				sb.append(adapter.showAsChild());
			} else {
				sb.append(item.toString());
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}
		sb.append("]");

		return sb.toString();
	}

}
