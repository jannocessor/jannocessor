package org.jannocessor.collection.filter.api;

public interface Criteria<E> {

	boolean satisfies(E object);

	Criteria<E> not();

	Criteria<E> and(Criteria<E> criteria);

	Criteria<E> or(Criteria<E> criteria);

	Criteria<E> xor(Criteria<E> criteria);

}
