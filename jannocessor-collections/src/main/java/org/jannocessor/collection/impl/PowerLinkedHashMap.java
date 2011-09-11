package org.jannocessor.collection.impl;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;

public class PowerLinkedHashMap<K, V> extends LinkedHashMap<K, V> implements
		PowerMap<K, V> {

	private static final long serialVersionUID = 1L;

	public static <K, V> PowerMap<K, V> powerMap() {
		return new PowerLinkedHashMap<K, V>();
	}

	public static <K, V> PowerMap<K, V> powerMap(Map<K, V> map) {
		PowerLinkedHashMap<K, V> powerMap = new PowerLinkedHashMap<K, V>();
		powerMap.putAll(map);
		return powerMap;
	}

	public static <K, V> PowerMap<K, V> powerMap(Set<Entry<K, V>> entrySet) {
		PowerLinkedHashMap<K, V> powerMap = new PowerLinkedHashMap<K, V>();
		for (Entry<K, V> entry : entrySet) {
			powerMap.put(entry.getKey(), entry.getValue());
		}
		return powerMap;
	}

	public PowerMap<K, V> copy() {
		return powerMap(this);
	}

	public PowerMap<K, V> set(K key, V value) {
		put(key, value);
		return this;
	}

	public PowerMap<K, V> getSelection(Criteria<Entry<K, V>> criteria) {
		return copy().retain(criteria);
	}

	public PowerMap<K, V> remove(Criteria<Entry<K, V>> criteria) {
		Set<Entry<K, V>> entries = entrySet();

		for (Iterator<Entry<K, V>> iterator = entries.iterator(); iterator
				.hasNext();) {
			Entry<K, V> entry = (Entry<K, V>) iterator.next();
			if (criteria.satisfies(entry)) {
				iterator.remove();
			}
		}

		return this;
	}

	public PowerMap<K, V> retain(Criteria<Entry<K, V>> criteria) {
		return remove(criteria.not());
	}

	public PowerMap<K, V> each(Operation<? super Entry<K, V>> operation) {
		Set<Entry<K, V>> entries = entrySet();

		for (Entry<K, V> entry : entries) {
			operation.execute(entry);
		}

		return this;
	}

}
