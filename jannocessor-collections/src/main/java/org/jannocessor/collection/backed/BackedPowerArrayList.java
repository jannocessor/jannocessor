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
