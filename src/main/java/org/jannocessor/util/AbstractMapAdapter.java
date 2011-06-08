/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.util;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapAdapter implements Map<Object, Object> {

	@Override
	public void clear() {
		throw new IllegalAccessError();
	}

	@Override
	public boolean containsValue(Object value) {
		throw new IllegalAccessError();
	}

	@Override
	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		throw new IllegalAccessError();
	}

	@Override
	public Set<Object> keySet() {
		throw new IllegalAccessError();
	}

	@Override
	public Object put(Object key, Object value) {
		throw new IllegalAccessError();
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		throw new IllegalAccessError();
	}

	@Override
	public Object remove(Object key) {
		throw new IllegalAccessError();
	}

	@Override
	public Collection<Object> values() {
		throw new IllegalAccessError();
	}

	@Override
	public int size() {
		throw new IllegalAccessError();
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean containsKey(Object key) {
		return true;
	}

	@Override
	public Object get(Object key) {
		return getValue((Object) key);
	}

	protected abstract Object getValue(Object key);
}
