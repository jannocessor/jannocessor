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
