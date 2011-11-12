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

package org.jannocessor.collection.backed;

import java.util.ArrayList;
import java.util.List;

import org.jannocessor.collection.api.PowerCollection;
import org.jannocessor.collection.backed.api.BackedPowerList;
import org.jannocessor.collection.backed.api.CollectionDispatcher;
import org.jannocessor.collection.impl.PowerArrayList;

public class BackedPowerArrayList<E> extends PowerArrayList<E> implements
		BackedPowerList<E> {

	private static final long serialVersionUID = 1955947408216363213L;

	private List<PowerCollection<E>> collections = new ArrayList<PowerCollection<E>>();

	private CollectionDispatcher<E> dispatcher;

	public BackedPowerArrayList(CollectionDispatcher<E> dispatcher) {
		this.dispatcher = dispatcher;
	}

	public <T extends PowerCollection<E>> void setIndexedCollection(int index,
			T collection) {
		// make sure the list is big enough
		while (index > collections.size() - 1) {
			collections.add(null);
		}

		collections.set(index, collection);
	}

	protected final void beforeItemAddedNotification(E item) {
		getTargetCollection(item).add(item);
	}

	protected final void beforeItemRemovedNotification(E item) {
		getTargetCollection(item).remove(item);
	}

	private PowerCollection<E> getTargetCollection(E item) {
		int index = dispatcher.getTargetCollectionIndex(item);

		PowerCollection<E> target = (index < collections.size()) ? collections
				.get(index) : null;

		if (target == null) {
			throw new IllegalArgumentException(
					"Couldn't dispatch item, no back collection specified for index: "
							+ index);
		}

		return target;
	}

}
