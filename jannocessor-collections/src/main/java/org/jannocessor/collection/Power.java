package org.jannocessor.collection;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.collection.api.PowerSet;
import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.filter.impl.CriteriaImpl;
import org.jannocessor.collection.impl.PowerArrayList;
import org.jannocessor.collection.impl.PowerLinkedHashMap;
import org.jannocessor.collection.impl.PowerLinkedHashSet;

public class Power {

	public static <T> PowerList<T> list(T... items) {
		return PowerArrayList.create(items);
	}

	@SuppressWarnings("unchecked")
	public static <T> PowerList<T> emptyList() {
		return PowerArrayList.create();
	}

	@SuppressWarnings("unchecked")
	public static <T> PowerList<T> emptyList(Class<T> clazz) {
		return PowerArrayList.create();
	}

	public static <T> PowerList<T> unmodifiableList(T... items) {
		// FIXME: Implement this!
		return PowerArrayList.create(items);
	}

	public static <T> PowerList<T> list(Collection<T> collection) {
		return PowerArrayList.powerList(collection);
	}

	public static <T> PowerSet<T> set(T... items) {
		return PowerLinkedHashSet.create(items);
	}

	public static <T> PowerSet<T> set(Collection<T> collection) {
		return PowerLinkedHashSet.powerSet(collection);
	}

	public static <K, V> PowerMap<K, V> map() {
		return PowerLinkedHashMap.powerMap();
	}

	public static <K, V> PowerMap<K, V> map(Map<K, V> map) {
		return PowerLinkedHashMap.powerMap(map);
	}

	public static <K, V> PowerMap<K, V> map(Set<Entry<K, V>> entrySet) {
		return PowerLinkedHashMap.powerMap(entrySet);
	}

	public static <T> Criteria<T> criteria(Condition<T> condition) {
		return CriteriaImpl.create(condition);
	}

}
