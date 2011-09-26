package org.jannocessor.collection.event.impl;

import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.api.event.CollectionOperationListener;

public class DefaultCollectionOperationListener implements
		CollectionOperationListener<Integer> {

	@Override
	public void itemAdded(CollectionOperationEvent<Integer> event) {
	}

	@Override
	public void itemRemoved(CollectionOperationEvent<Integer> event) {
	}

}
