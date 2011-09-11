package org.jannocessor.collection.filter.api;

public interface Condition<E> {

	boolean satisfies(E object);

}
