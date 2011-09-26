package org.jannocessor.collection.api.event;

public interface CollectionOperationListener<E> {

	void itemAdded(CollectionOperationEvent<E> event);

	void itemRemoved(CollectionOperationEvent<E> event);

}
