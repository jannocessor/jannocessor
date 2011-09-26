package org.jannocessor.collection.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.event.CollectionOperationListener;
import org.jannocessor.collection.event.impl.DefaultCollectionOperationEvent;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.filter.impl.PredicateAdapter;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public class PowerArrayList<E> extends ArrayList<E> implements PowerList<E> {

	private static final long serialVersionUID = 1L;

	private List<CollectionOperationListener<E>> listeners = new ArrayList<CollectionOperationListener<E>>();

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

	@Override
	public PowerList<E> copy() {
		return powerList(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerList<E> getSelection(Criteria<E> criteria) {
		return powerList(CollectionUtils.select(this, predicate(criteria)));
	}

	private Predicate predicate(Criteria<E> criteria) {
		return new PredicateAdapter(criteria);
	}

	@Override
	public PowerList<E> remove(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria.not()));
		return this;
	}

	@Override
	public PowerList<E> retain(Criteria<E> criteria) {
		CollectionUtils.filter(this, predicate(criteria));
		return this;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerList<E> getIntersection(Collection<E> list) {
		return powerList(CollectionUtils.intersection(this, list));
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerList<E> getDisjunction(Collection<E> list) {
		return powerList(CollectionUtils.disjunction(this, list));
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerList<E> getUnion(Collection<E> list) {
		return powerList(CollectionUtils.union(this, list));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
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
	@Override
	public PowerList<E> each(final Operation<? super E> operation) {
		CollectionUtils.forAllDo(this, new Closure() {

			public void execute(Object input) {
				operation.execute((E) input);
			}

		});

		return this;
	}

	@Override
	public boolean add(E item) {
		boolean result = super.add(item);
		if (result) {
			fireItemAdded(item);
		}
		return result;
	}

	@Override
	public void add(int index, E element) {
		boolean result = super.add(element);
		if (result) {
			fireItemAdded(element);
		}
	};

	@Override
	public boolean addAll(Collection<? extends E> collection) {
		boolean result = super.addAll(collection);
		if (result) {
			for (E element : collection) {
				fireItemAdded(element);
			}
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> collection) {
		boolean result = super.addAll(index, collection);
		if (result) {
			for (E element : collection) {
				fireItemAdded(element);
			}
		}
		return result;
	}

	@Override
	public E remove(int index) {
		E item = super.remove(index);
		fireItemRemoved(item);
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean remove(Object item) {
		boolean result = super.remove(item);
		if (result) {
			fireItemRemoved((E) item);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		Object[] items = toArray();
		super.clear();
		for (Object item : items) {
			fireItemRemoved((E) item);
		}
	}

	@Override
	public E set(int index, E element) {
		E result = super.set(index, element);
		fireItemAdded(element);
		fireItemRemoved(result);
		return result;
	};

	@Override
	public PowerList<E> addAll(E... objects) {
		for (E object : objects) {
			if (super.add(object)) {
				fireItemAdded(object);
			}
		}
		return this;
	}

	@Override
	public PowerList<E> removeAll(E... objects) {
		for (E object : objects) {
			if (super.remove(object)) {
				fireItemRemoved(object);
			}
		}
		return this;
	}

	@Override
	public void addCollectionOperationListener(
			CollectionOperationListener<E> listener) {
		listeners.add(listener);
	}

	@Override
	public void removeCollectionOperationListener(
			CollectionOperationListener<E> listener) {
		listeners.remove(listener);
	}

	private void fireItemAdded(E item) {
		for (CollectionOperationListener<E> listener : listeners) {
			DefaultCollectionOperationEvent<E> event = new DefaultCollectionOperationEvent<E>(
					this, item);
			listener.itemAdded(event);
		}
	}

	private void fireItemRemoved(E item) {
		for (CollectionOperationListener<E> listener : listeners) {
			DefaultCollectionOperationEvent<E> event = new DefaultCollectionOperationEvent<E>(
					this, item);
			listener.itemRemoved(event);
		}
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

}
