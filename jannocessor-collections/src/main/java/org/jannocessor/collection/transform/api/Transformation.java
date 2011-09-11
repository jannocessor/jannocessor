package org.jannocessor.collection.transform.api;

public interface Transformation<T1, T2> {

	T2 transform(T1 input);

}
