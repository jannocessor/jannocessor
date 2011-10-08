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

package org.jannocessor.collection;

import org.jannocessor.collection.api.PowerMap;
import org.junit.Assert;
import org.junit.Test;

public class PowerLinkedHashMapTest {

	@Test
	public void testBasicOperations() {
		PowerMap<String, Integer> map = Power.map();
		map.set("a", 1).set("b", 2);

		Assert.assertEquals(map.size(), 2);
		check(map, "a", 1);
		check(map, "b", 2);
	}

	private void check(PowerMap<?, ?> map, Object key, Object value) {
		Assert.assertEquals(value, map.get(key));
	}

}
