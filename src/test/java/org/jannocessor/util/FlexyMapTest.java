package org.jannocessor.util;

import static org.junit.Assert.*;

import org.jannocessor.test.AbstractTest;
import org.junit.Before;
import org.junit.Test;

public class FlexyMapTest extends AbstractTest {

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

}
