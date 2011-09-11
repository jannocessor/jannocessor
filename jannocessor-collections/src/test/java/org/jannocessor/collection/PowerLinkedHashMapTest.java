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
