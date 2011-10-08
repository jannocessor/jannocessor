/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
