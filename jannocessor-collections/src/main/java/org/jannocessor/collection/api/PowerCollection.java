package org.jannocessor.collection.api;

import java.util.Collection;

import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;

public interface PowerCollection<E> extends Collection<E> {

	PowerCollection<E> add(E... objects);

	PowerCollection<E> remove(E... objects);

	PowerCollection<E> copy();

	PowerCollection<E> getSelection(Criteria<E> criteria);

	PowerCollection<E> remove(Criteria<E> criteria);

	PowerCollection<E> retain(Criteria<E> criteria);

	PowerCollection<E> getDisjunction(Collection<E> collection);

	PowerCollection<E> getIntersection(Collection<E> list);

	PowerCollection<E> getUnion(Collection<E> list);

	<T> PowerCollection<T> getTransformed(Transformation<E, T> transformation);

	PowerCollection<E> each(Operation<? super E> operation);

}
