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
