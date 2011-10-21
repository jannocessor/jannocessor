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

import org.jannocessor.collection.api.PowerCollection;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.event.CollectionOperationEvent;

public class ParentedListEvent<T> implements CollectionOperationEvent<T> {

	private final T item;
	private final PowerList<T> list;

	public ParentedListEvent(PowerList<T> list, T item) {
		this.list = list;
		this.item = item;
	}

	@Override
	public PowerCollection<T> getSource() {
		return list;
	}

	@Override
	public T getElement() {
		return item;
	}

}
