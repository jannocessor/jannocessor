package org.jannocessor.test;

import static org.junit.Assert.*;

import java.util.List;

public abstract class AbstractTest {

	@SuppressWarnings("unchecked")
	protected void checkList(Object value, Object... items) {
		if (value instanceof List) {
			List<Object> list = (List<Object>) value;
			assertArrayEquals(items, list.toArray());
		} else {
			fail("Expected a list");
		}
	}

}
