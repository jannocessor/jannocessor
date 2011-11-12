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

package org.jannocessor.collection.filter.impl;

import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;

public class CriteriaImpl<E> implements Criteria<E> {

	private final Condition<E> condition;

	public CriteriaImpl(Condition<E> condition) {
		this.condition = condition;
	}

	public boolean satisfies(E object) {
		return condition.satisfies(object);
	}

	public static <T> Criteria<T> create(Condition<T> condition) {
		return new CriteriaImpl<T>(condition);
	}

	public Criteria<E> not() {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return !condition.satisfies(object);
			}
		});
	}

	public Criteria<E> and(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object)
						&& criteria.satisfies(object);
			}
		});
	}

	public Criteria<E> or(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object)
						|| criteria.satisfies(object);
			}
		});
	}

	public Criteria<E> xor(final Criteria<E> criteria) {
		return create(new Condition<E>() {
			public boolean satisfies(E object) {
				return condition.satisfies(object) ^ criteria.satisfies(object);
			}
		});
	}
}
