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
