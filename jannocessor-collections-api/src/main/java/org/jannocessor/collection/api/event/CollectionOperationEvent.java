package org.jannocessor.collection.api.event;

import org.jannocessor.collection.api.PowerCollection;

public interface CollectionOperationEvent<E> {

	PowerCollection<E> getSource();

	E getElement();

}
