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

	@Test
	public void testInstantiations() {
		PowerMap<String, Integer> map = Power.map("a", 1);

		Assert.assertEquals(map.size(), 1);
		check(map, "a", 1);

		PowerMap<String, Integer> map2 = Power.map("a", 1, "b", 2);

		Assert.assertEquals(map2.size(), 2);
		check(map2, "a", 1);
		check(map2, "b", 2);

		PowerMap<String, Integer> map3 = Power.map("a", 1, "b", 2, "c", 3);

		Assert.assertEquals(map3.size(), 3);
		check(map3, "a", 1);
		check(map3, "b", 2);
		check(map3, "c", 3);
	}

	private void check(PowerMap<?, ?> map, Object key, Object value) {
		Assert.assertEquals(value, map.get(key));
	}

}
