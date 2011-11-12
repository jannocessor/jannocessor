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
