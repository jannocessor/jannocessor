package org.jannocessor.collection.api;

import java.util.Map;

import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;

public interface PowerMap<K, V> extends Map<K, V> {

	PowerMap<K, V> copy();

	PowerMap<K, V> set(K key, V value);

	PowerMap<K, V> getSelection(Criteria<Entry<K, V>> criteria);

	PowerMap<K, V> remove(Criteria<Entry<K, V>> criteria);

	PowerMap<K, V> retain(Criteria<Entry<K, V>> criteria);

	PowerMap<K, V> each(Operation<? super Entry<K, V>> operation);

}
