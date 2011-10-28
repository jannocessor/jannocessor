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

package org.jannocessor.collection.backed;

import junit.framework.Assert;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.backed.api.CollectionDispatcher;
import org.junit.Test;

public class BackedPowerListTest<E> {

	@Test
	public void shouldDelegateOperationsToCollections() {

		CollectionDispatcher<String> dispatcher = new CollectionDispatcher<String>() {
			@Override
			public int getTargetCollectionIndex(String s) {
				return s.length();
			}
		};

		PowerList<String> shortElements = Power.list();
		PowerList<String> mediumElements = Power.list();
		PowerList<String> longElements = Power.list();

		BackedPowerList<String> backed = new BackedPowerList<String>(dispatcher);

		backed.setIndexedCollection(1, shortElements);
		backed.setIndexedCollection(2, shortElements);

		backed.setIndexedCollection(3, mediumElements);
		backed.setIndexedCollection(4, mediumElements);

		backed.setIndexedCollection(5, longElements);
		backed.setIndexedCollection(6, longElements);

		backed.add("a");
		backed.add("bb");
		backed.add("ccc");
		backed.add("dddd");
		backed.add("eeeee");
		backed.add("ffffff");

		Assert.assertEquals(2, shortElements.size());
		Assert.assertTrue(shortElements.contains("a"));
		Assert.assertTrue(shortElements.contains("bb"));

		Assert.assertEquals(2, mediumElements.size());
		Assert.assertTrue(mediumElements.contains("ccc"));
		Assert.assertTrue(mediumElements.contains("dddd"));

		Assert.assertEquals(2, longElements.size());
		Assert.assertTrue(longElements.contains("eeeee"));
		Assert.assertTrue(longElements.contains("ffffff"));
	}

}
