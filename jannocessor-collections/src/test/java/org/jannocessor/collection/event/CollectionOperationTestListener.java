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

package org.jannocessor.collection.event;

import java.util.ArrayList;
import java.util.List;

import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.api.event.CollectionOperationListener;

public class CollectionOperationTestListener<E> implements
		CollectionOperationListener<E> {

	private List<CollectionOperationEvent<E>> added = new ArrayList<CollectionOperationEvent<E>>();
	private List<CollectionOperationEvent<E>> removed = new ArrayList<CollectionOperationEvent<E>>();

	@Override
	public void itemAdded(CollectionOperationEvent<E> event) {
		added.add(event);
	}

	@Override
	public void itemRemoved(CollectionOperationEvent<E> event) {
		removed.add(event);
	}

	public void reset() {
		added.clear();
		removed.clear();
	}

	public List<CollectionOperationEvent<E>> getAdded() {
		return added;
	}

	public List<CollectionOperationEvent<E>> getRemoved() {
		return removed;
	}

}
