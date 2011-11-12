/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

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

	public static <K, V> PowerMap<K, V> map(Class<K> keyClass,
			Class<V> valueClass) {
		return PowerLinkedHashMap.powerMap();
	}

	public static <K, V> PowerMap<K, V> map(K key, V value) {
		return PowerLinkedHashMap.powerMap(key, value);
	}

	public static <K, V> PowerMap<K, V> map(K key1, V value1, K key2, V value2) {
		return PowerLinkedHashMap.powerMap(key1, value1, key2, value2);
	}

	public static <K, V> PowerMap<K, V> map(K key1, V value1, K key2, V value2,
			K key3, V value3) {
		return PowerLinkedHashMap.powerMap(key1, value1, key2, value2, key3,
				value3);
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
