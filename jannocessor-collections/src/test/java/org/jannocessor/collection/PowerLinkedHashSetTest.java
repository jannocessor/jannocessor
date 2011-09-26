package org.jannocessor.collection;

import org.jannocessor.collection.api.PowerSet;
import org.junit.Assert;
import org.junit.Test;

public class PowerLinkedHashSetTest {

	@Test
	public void testBasicOperations() {
		PowerSet<Integer> set = Power.set(1, 3, 5, 1).addAll(1, 2, 3, 4)
				.removeAll(1, 5);
		check(set, 3, 2, 4);
	}

	private void check(PowerSet<?> set, Object... expected) {
		Assert.assertArrayEquals(expected, set.toArray());
	}

}
