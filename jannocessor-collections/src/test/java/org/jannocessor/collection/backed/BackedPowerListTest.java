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

package org.jannocessor.collection.backed;

import junit.framework.Assert;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.backed.api.BackedPowerList;
import org.jannocessor.collection.backed.api.CollectionDispatcher;
import org.junit.Before;
import org.junit.Test;

public class BackedPowerListTest<E> {

	private PowerList<String> shortElements;
	private PowerList<String> mediumElements;
	private PowerList<String> longElements;
	private BackedPowerList<String> backed;

	@Before
	public void init() {
		shortElements = Power.list();
		mediumElements = Power.list();
		longElements = Power.list();

		backed = new BackedPowerArrayList<String>(new CollectionDispatcher<String>() {
			@Override
			public int getTargetCollectionIndex(String s) {
				return s.length();
			}
		});

		backed.setIndexedCollection(1, shortElements);
		backed.setIndexedCollection(2, shortElements);

		backed.setIndexedCollection(3, mediumElements);
		backed.setIndexedCollection(4, mediumElements);

		backed.setIndexedCollection(5, longElements);
		backed.setIndexedCollection(6, longElements);
	}

	@Test
	public void shouldDelegateOperationsToCollections() {
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

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailOnIncorrectDispatch() {
		backed.add("TOO BIG STRING");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldFailOnIncorrectDispatch2() {
		backed.add("");
	}

}
