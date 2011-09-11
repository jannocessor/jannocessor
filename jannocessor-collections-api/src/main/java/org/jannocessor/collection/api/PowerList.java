package org.jannocessor.collection.api;

import java.util.Collection;
import java.util.List;

import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public interface PowerList<E> extends List<E>, PowerCollection<E> {

	PowerList<E> add(E... objects);

	PowerList<E> remove(E... objects);

	PowerList<E> copy();

	PowerList<E> getSelection(Criteria<E> criteria);

	PowerList<E> remove(Criteria<E> criteria);

	PowerList<E> retain(Criteria<E> criteria);

	PowerList<E> getDisjunction(Collection<E> collection);

	PowerList<E> getIntersection(Collection<E> list);

	PowerList<E> getUnion(Collection<E> list);

	<T> PowerList<T> getTransformed(Transformation<E, T> transformation);

	PowerList<E> each(Operation<? super E> operation);

}
