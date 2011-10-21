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

package org.jannocessor.model.util;

import java.io.Serializable;

import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.api.event.CollectionOperationListener;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.ParentedElement;

public class ParentedListOperationListener<E> implements
		CollectionOperationListener<E>, Serializable {

	private static final long serialVersionUID = 1L;

	private final JavaElement parent;

	public ParentedListOperationListener(JavaElement parent) {
		this.parent = parent;
	}

	@Override
	public void itemAdded(CollectionOperationEvent<E> event) {
		if (event.getElement() instanceof ParentedElement) {
			ParentedElement element = (ParentedElement) event.getElement();
			element.setParent(parent);
		}
	}

	@Override
	public void itemRemoved(CollectionOperationEvent<E> event) {
		if (event.getElement() instanceof ParentedElement) {
			ParentedElement element = (ParentedElement) event.getElement();
			element.setParent(null);
		}
	}

}
