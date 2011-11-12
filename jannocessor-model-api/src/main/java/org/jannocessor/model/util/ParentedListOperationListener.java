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
		E item = event.getElement();
		if (item instanceof ParentedElement) {
			ParentedElement element = (ParentedElement) item;
			element.setParent(parent);
		} else {
			throw new IllegalArgumentException("Could not set the parent of "
					+ item.getClass().getSimpleName() + " instance: " + item);
		}
	}

	@Override
	public void itemRemoved(CollectionOperationEvent<E> event) {
		E item = event.getElement();
		if (item instanceof ParentedElement) {
			ParentedElement element = (ParentedElement) item;
			element.setParent(parent);
		} else {
			throw new IllegalArgumentException("Could not set the parent of "
					+ item.getClass().getSimpleName() + " instance: " + item);
		}
	}

}
