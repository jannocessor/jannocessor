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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HashFlexyMap extends HashMap<Object, Object> implements FlexyMap {

	private static final long serialVersionUID = 3025165722821921765L;

	@Override
	public FlexyMap sub(Object... keys) {
		FlexyMap subMap = this;

		for (Object key : keys) {
			Object value = subMap.get(key);
			if (value == null) {
				FlexyMap newMap = new HashFlexyMap();
				subMap.put(key, newMap);
				subMap = newMap;
			} else if (value instanceof FlexyMap) {
				subMap = (FlexyMap) value;
			} else {
				String msg = String.format("Expected sub-map for key '%s', "
						+ "but found value: %s", key, value);
				throw new IllegalArgumentException(msg);
			}
		}

		return subMap;
	}

	@SuppressWarnings("unchecked")
	@Override
	public FlexyMap add(Object key, Object item) {
		Object value = get(key);

		List<Object> coll;
		if (value == null) {
			coll = new ArrayList<Object>();
			put(key, coll);
		} else if (value instanceof List) {
			coll = (List<Object>) value;
		} else {
			String msg = String.format("Expected list for key '%s', "
					+ "but found value: %s", key, value);
			throw new IllegalArgumentException(msg);
		}

		coll.add(item);
		return this;
	}

	@Override
	public FlexyMap set(Object key, Object value) {
		put(key, value);

		return this;
	}

}
