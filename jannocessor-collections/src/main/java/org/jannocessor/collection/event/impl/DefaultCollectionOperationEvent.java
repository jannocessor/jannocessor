package org.jannocessor.collection.event.impl;

import java.util.EventObject;

import org.jannocessor.collection.api.PowerCollection;
import org.jannocessor.collection.api.event.CollectionOperationEvent;

public class DefaultCollectionOperationEvent<E> extends EventObject implements
		CollectionOperationEvent<E> {

	private static final long serialVersionUID = 1L;

	private final E item;

	public DefaultCollectionOperationEvent(PowerCollection<E> source, E item) {
		super(source);
		this.item = item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PowerCollection<E> getSource() {
		return (PowerCollection<E>) super.getSource();
	}

	@Override
	public E getElement() {
		return item;
	}
}
