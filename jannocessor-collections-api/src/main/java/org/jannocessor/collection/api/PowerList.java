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

package org.jannocessor.collection.api;

import java.util.Collection;
import java.util.List;

import org.jannocessor.collection.api.event.CollectionOperationListener;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public interface PowerList<E> extends List<E>, PowerCollection<E> {

	PowerList<E> addAll(E... objects);

	PowerList<E> removeAll(E... objects);

	PowerList<E> copy();

	PowerList<E> getSelection(Criteria<E> criteria);

	PowerList<E> remove(Criteria<E> criteria);

	PowerList<E> retain(Criteria<E> criteria);

	PowerList<E> getDisjunction(Collection<E> collection);

	PowerList<E> getIntersection(Collection<E> list);

	PowerList<E> getUnion(Collection<E> list);

	<T> PowerList<T> getTransformed(Transformation<E, T> transformation);

	PowerList<E> each(Operation<? super E> operation);

	void addCollectionOperationListener(CollectionOperationListener<E> listener);

	void removeCollectionOperationListener(
			CollectionOperationListener<E> listener);

}
