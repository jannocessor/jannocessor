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

	<T> PowerList<T> getTransformed(Transformation<? super E, T> transformation);

	PowerList<E> each(Operation<? super E> operation);

	void addCollectionOperationListener(CollectionOperationListener<E> listener);

	void removeCollectionOperationListener(
			CollectionOperationListener<E> listener);

}
