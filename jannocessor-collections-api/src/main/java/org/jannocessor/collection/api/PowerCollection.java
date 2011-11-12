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

	<T> PowerCollection<T> getTransformed(Transformation<? super E, T> transformation);

	PowerCollection<E> each(Operation<? super E> operation);

	void assign(Collection<? extends E> collection);

	void assign(E... elements);

	String join(String separator);

}
