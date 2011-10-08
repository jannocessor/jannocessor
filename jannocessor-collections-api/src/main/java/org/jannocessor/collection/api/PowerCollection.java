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

import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public interface PowerCollection<E> extends Collection<E> {

	PowerCollection<E> addAll(E... objects);

	PowerCollection<E> removeAll(E... objects);

	PowerCollection<E> copy();

	PowerCollection<E> getSelection(Criteria<E> criteria);

	PowerCollection<E> remove(Criteria<E> criteria);

	PowerCollection<E> retain(Criteria<E> criteria);

	PowerCollection<E> getDisjunction(Collection<E> collection);

	PowerCollection<E> getIntersection(Collection<E> list);

	PowerCollection<E> getUnion(Collection<E> list);

	<T> PowerCollection<T> getTransformed(Transformation<E, T> transformation);

	PowerCollection<E> each(Operation<? super E> operation);

	void assign(Collection<? extends E> collection);

	void assign(E... elements);

}
