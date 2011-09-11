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
