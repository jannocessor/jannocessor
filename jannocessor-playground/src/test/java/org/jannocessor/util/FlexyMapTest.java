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

package org.jannocessor.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlexyMapTest {

	private static final String A = "A";
	private static final String B = "B";

	private FlexyMap flexyMap;

	@Before
	public void init() {
		flexyMap = new HashFlexyMap();
	}

	@Test
	public void testPutAndGet() {
		flexyMap.put(1, A);
		flexyMap.put(2, B);

		assertEquals(flexyMap.get(1), A);
		assertEquals(flexyMap.get(2), B);
	}

	@Test
	public void testSetAndGet() {
		flexyMap.set(1, A).set(2, B);

		assertEquals(flexyMap.get(1), A);
		assertEquals(flexyMap.get(2), B);
	}

	@Test
	public void testSubSingleton() {
		FlexyMap subMap = flexyMap.sub(1);
		FlexyMap subMap2 = flexyMap.sub(1);

		assertTrue(subMap == subMap2);
	}

	@Test
	public void testSub() {
		flexyMap.sub(1).put(2, A);
		flexyMap.sub(3).put(4, B);

		assertEquals(flexyMap.sub(1).get(2), A);
		assertEquals(flexyMap.sub(3).get(4), B);
	}

	@Test
	public void testSubSub() {
		flexyMap.sub(1).sub(2).put(3, A);

		assertEquals(A, flexyMap.sub(1, 2).get(3));
	}

	@Test
	public void testAdd() {
		flexyMap.add(1, A);
		flexyMap.add(1, B);

		checkList(flexyMap.get(1), A, B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotList() {
		flexyMap.set(1, A).add(1, B);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNotMap() {
		flexyMap.set(1, A).sub(1);
	}

	@SuppressWarnings("unchecked")
	protected void checkList(Object value, Object... items) {
		if (value instanceof List) {
			List<Object> list = (List<Object>) value;
			Assert.assertArrayEquals(items, list.toArray());
		} else {
			Assert.fail("Expected a list");
		}
	}

}
