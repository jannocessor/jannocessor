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
