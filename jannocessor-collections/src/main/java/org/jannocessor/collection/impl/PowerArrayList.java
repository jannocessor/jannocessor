package org.jannocessor.collection.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.filter.impl.PredicateAdapter;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public class PowerArrayList<E> extends ArrayList<E> implements PowerList<E> {

	private static final long serialVersionUID = 1L;

	public static <T> PowerList<T> create(T... items) {
		PowerArrayList<T> list = new PowerArrayList<T>();
		for (T item : items) {
			list.add(item);
		}
		return list;
	}

	public static <T> PowerList<T> powerList(Collection<T> collection) {
		PowerArrayList<T> list = new PowerArrayList<T>();
		list.addAll(collection);
		return list;
	}

	public PowerList<E> copy() {
		return powerList(this);
	}

	@SuppressWarnings("unchecked")
	public PowerList<E> getSelection(Criteria<E> criteria) {
		return powerList(CollectionUtils.select(this, predicate(criteria)));
	}

	private Predicate predicate(Criteria<E> criteria) {
		return new PredicateAdapter(criteria);
	}

	public PowerList<E> remove(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria.not()));
		return this;
	}

	public PowerList<E> retain(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria));
		return this;
	}

	@SuppressWarnings("unchecked")
	public PowerList<E> getIntersection(Collection<E> list) {
		return powerList(CollectionUtils.intersection(this, list));
	}

	@SuppressWarnings("unchecked")
	public PowerList<E> getDisjunction(Collection<E> list) {
		return powerList(CollectionUtils.disjunction(this, list));
	}

	@SuppressWarnings("unchecked")
	public PowerList<E> getUnion(Collection<E> list) {
		return powerList(CollectionUtils.union(this, list));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> PowerList<T> getTransformed(
			final Transformation<E, T> transformation) {
		PowerList copy = copy();
		CollectionUtils.transform(copy, new Transformer() {
			public Object transform(Object input) {
				return transformation.transform((E) input);
			}
		});
		return copy;
	}

	@SuppressWarnings("unchecked")
	public PowerList<E> each(final Operation<? super E> operation) {
		CollectionUtils.forAllDo(this, new Closure() {

			public void execute(Object input) {
				operation.execute((E) input);
			}

		});

		return this;
	}

	public PowerList<E> add(E... objects) {
		for (E object : objects) {
			super.add(object);
		}
		return this;
	}

	public PowerList<E> remove(E... objects) {
		for (E object : objects) {
			super.remove(object);
		}
		return this;
	}

}
