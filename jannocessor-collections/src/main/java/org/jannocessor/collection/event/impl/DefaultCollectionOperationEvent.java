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

package org.jannocessor.collection.event.impl;

import java.util.EventObject;

import org.jannocessor.collection.api.PowerCollection;
import org.jannocessor.collection.api.event.CollectionOperationEvent;

public class DefaultCollectionOperationEvent<E> extends EventObject implements
		CollectionOperationEvent<E> {

	private static final long serialVersionUID = 1L;

	private final E item;

	public DefaultCollectionOperationEvent(PowerCollection<E> source, E item) {
		super(source);
		this.item = item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerCollection<E> getSource() {
		return (PowerCollection<E>) super.getSource();
	}

	@Override
	public E getElement() {
		return item;
	}
}
