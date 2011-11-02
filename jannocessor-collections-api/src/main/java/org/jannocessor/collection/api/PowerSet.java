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
import java.util.Set;

import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public interface PowerSet<E> extends Set<E>, PowerCollection<E> {

	PowerSet<E> addAll(E... objects);

	PowerSet<E> removeAll(E... objects);

	PowerSet<E> copy();

	PowerSet<E> getSelection(Criteria<E> criteria);

	PowerSet<E> remove(Criteria<E> criteria);

	PowerSet<E> retain(Criteria<E> criteria);

	PowerSet<E> getDisjunction(Collection<E> collection);

	PowerSet<E> getIntersection(Collection<E> list);

	PowerSet<E> getUnion(Collection<E> list);

	<T> PowerSet<T> getTransformed(Transformation<? super E, T> transformation);

	PowerSet<E> each(Operation<? super E> operation);

}
