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

package org.jannocessor.collection.impl;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.StringUtils;
import org.jannocessor.collection.api.PowerSet;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.filter.impl.PredicateAdapter;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public class PowerLinkedHashSet<E> extends LinkedHashSet<E> implements
		PowerSet<E> {

	private static final long serialVersionUID = 1L;

	public static <T> PowerSet<T> create(T... items) {
		PowerLinkedHashSet<T> Set = new PowerLinkedHashSet<T>();
		for (T item : items) {
			Set.add(item);
		}
		return Set;
	}

	public static <T> PowerSet<T> powerSet(Collection<T> collection) {
		PowerLinkedHashSet<T> Set = new PowerLinkedHashSet<T>();
		Set.addAll(collection);
		return Set;
	}

	public PowerSet<E> copy() {
		return powerSet(this);
	}

	@SuppressWarnings("unchecked")
	public PowerSet<E> getSelection(Criteria<E> criteria) {
		return powerSet(CollectionUtils.select(this, predicate(criteria)));
	}

	private Predicate predicate(Criteria<E> criteria) {
		return new PredicateAdapter(criteria);
	}

	public PowerSet<E> remove(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria.not()));
		return this;
	}

	public PowerSet<E> retain(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria));
		return this;
	}

	@SuppressWarnings("unchecked")
	public PowerSet<E> getIntersection(Collection<E> Set) {
		return powerSet(CollectionUtils.intersection(this, Set));
	}

	@SuppressWarnings("unchecked")
	public PowerSet<E> getDisjunction(Collection<E> Set) {
		return powerSet(CollectionUtils.disjunction(this, Set));
	}

	@SuppressWarnings("unchecked")
	public PowerSet<E> getUnion(Collection<E> Set) {
		return powerSet(CollectionUtils.union(this, Set));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> PowerSet<T> getTransformed(
			final Transformation<? super E, T> transformation) {
		PowerSet copy = copy();
		CollectionUtils.transform(copy, new Transformer() {
			public Object transform(Object input) {
				return transformation.transform((E) input);
			}
		});
		return copy;
	}

	public PowerSet<E> each(final Operation<? super E> operation) {
		CollectionUtils.forAllDo(this, new Closure() {
			@SuppressWarnings("unchecked")
			public void execute(Object input) {
				operation.execute((E) input);
			}
		});
		return this;
	}

	public PowerSet<E> addAll(E... objects) {
		for (E object : objects) {
			super.add(object);
		}
		return this;
	}

	public PowerSet<E> removeAll(E... objects) {
		for (E object : objects) {
			super.remove(object);
		}
		return this;
	}

	@Override
	public void assign(Collection<? extends E> collection) {
		clear();
		addAll(collection);
	}

	@Override
	public void assign(E... elements) {
		clear();
		addAll(elements);
	}

	@Override
	public String join(String separator) {
		return StringUtils.join(this, separator);
	}

}
