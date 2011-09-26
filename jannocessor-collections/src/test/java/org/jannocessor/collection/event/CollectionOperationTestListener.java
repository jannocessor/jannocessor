package org.jannocessor.collection.event;

import java.util.ArrayList;
import java.util.List;

import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.api.event.CollectionOperationListener;

public class CollectionOperationTestListener<E> implements
		CollectionOperationListener<E> {

	private List<CollectionOperationEvent<E>> added = new ArrayList<CollectionOperationEvent<E>>();
	private List<CollectionOperationEvent<E>> removed = new ArrayList<CollectionOperationEvent<E>>();

	@Override
	public void itemAdded(CollectionOperationEvent<E> event) {
		added.add(event);
	}

	@Override
	public void itemRemoved(CollectionOperationEvent<E> event) {
		removed.add(event);
	}

	public void reset() {
		added.clear();
		removed.clear();
	}

	public List<CollectionOperationEvent<E>> getAdded() {
		return added;
	}

	public List<CollectionOperationEvent<E>> getRemoved() {
		return removed;
	}

}
