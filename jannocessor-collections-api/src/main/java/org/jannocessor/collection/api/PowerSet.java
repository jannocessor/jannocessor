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

	<T> PowerSet<T> getTransformed(Transformation<E, T> transformation);

	PowerSet<E> each(Operation<? super E> operation);

}
