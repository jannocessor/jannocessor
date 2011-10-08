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

import java.util.Iterator;
import java.util.List;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.collection.api.event.CollectionOperationEvent;
import org.jannocessor.collection.event.CollectionOperationTestListener;
import org.jannocessor.collection.filter.api.Condition;
import org.jannocessor.collection.filter.api.Criteria;
import org.jannocessor.collection.transform.api.Operation;
import org.jannocessor.collection.transform.api.Transformation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PowerArrayListTest {

	private Criteria<String> moreThanOne;

	private Criteria<String> allUpper;

	private PowerList<String> notificationList = Power.list("a", "b", "c");

	private CollectionOperationTestListener<String> counter = new CollectionOperationTestListener<String>();

	@Before
	public void initialize() {
		moreThanOne = Power.criteria(new Condition<String>() {
			public boolean satisfies(String s) {
				return s.length() > 1;
			}
		});

		allUpper = Power.criteria(new Condition<String>() {
			public boolean satisfies(String s) {
				return s.toUpperCase().equals(s);
			}
		});

		notificationList.addCollectionOperationListener(counter);
	}

	@Test
	public void testGetSelection() {
		PowerList<String> list = Power.list("a", "BB", "C", "ddd");

		check(list.getSelection(moreThanOne.xor(allUpper)), "C", "ddd");

		check(list.getSelection(moreThanOne), "BB", "ddd");
	}

	@Test
	public void testGetUnion() {
		check(Power.list(1, 2).getUnion(Power.list(2, 3)), 1, 2, 3);
	}

	@Test
	public void testRetain() {
		PowerList<String> list = Power.list("a", "BB", "C", "ddd");

		PowerList<String> list3 = list.copy().retain(moreThanOne.not());
		check(list, "a", "BB", "C", "ddd");
		// original list not changed
		check(list3, "a", "C");

		check(list3.retain(allUpper), "C");
	}

	@Test
	public void testEach() {
		PowerList<String> list = Power.list("a", "b", "c");
		final PowerList<String> collected = Power.list();

		Operation<String> collect = new Operation<String>() {
			public void execute(String target) {
				collected.add(target);
			}
		};

		list.each(collect);

		check(collected, "a", "b", "c");
	}

	@Test
	public void testGetTransformed() {
		Transformation<String, Integer> size = new Transformation<String, Integer>() {
			public Integer transform(String input) {
				return input.length();
			}
		};

		PowerList<String> list = Power.list("a", "BB", "C", "ddd");
		check(list.getTransformed(size), 1, 2, 1, 3);
	}

	@Test
	public void testAddNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		notificationList.add("x");
		checkAdded(counter, "x");
	}

	@Test
	public void testAddNotification2() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		notificationList.add(7, "x");
		checkAdded(counter, "x");
	}

	@Test
	public void testAddNotification3() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		notificationList.addAll("x", "y", "z");
		checkAdded(counter, "x", "y", "z");
	}

	@Test
	public void testAddAllNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		notificationList.addAll(Power.list("x", "y", "z"));
		checkAdded(counter, "x", "y", "z");
	}

	@Test
	public void testAddAllNotification2() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		notificationList.addAll(0, Power.list("x", "y", "z"));
		checkAdded(counter, "x", "y", "z");
	}

	@Test
	public void testClearNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.clear();
		checkRemoved(counter, items);
	}

	@Test
	public void testRemoveNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Criteria<String> criteria = Power.criteria(new Condition<String>() {
			public boolean satisfies(String s) {
				return true;
			}
		});

		Object[] items = notificationList.toArray();
		notificationList.remove(criteria);
		checkRemoved(counter, items);
	}

	@Test
	public void testRemoveNotification2() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.remove(0);
		checkRemoved(counter, items[0]);
	}

	@Test
	public void testRemoveNotification3() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.remove(items[0]);
		checkRemoved(counter, items[0]);
	}

	@Test
	public void testRemoveNotification4() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.removeAll((String) items[0], (String) items[1]);
		checkRemoved(counter, items[0], items[1]);
	}

	@Test
	public void testRemoveNotification5() {
		notificationList.assign(Power.list("A", "B", "C", "D", "E"));
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.removeAll(Power.list(items[0], items[1]));
		checkRemoved(counter, items[0], items[1]);
	}

	@Test
	public void testRetainNotification() {
		notificationList.assign(Power.list("A", "B", "C", "D", "E"));
		counter.reset();

		Criteria<String> criteria = Power.criteria(new Condition<String>() {
			public boolean satisfies(String s) {
				return false;
			}
		});

		Object[] items = notificationList.toArray();
		notificationList.retain(criteria);
		checkRemoved(counter, items);
	}

	@Test
	public void testRetainNotification2() {
		notificationList.assign(Power.list("A", "B", "C", "D", "E"));
		counter.reset();

		Criteria<String> criteria = Power.criteria(new Condition<String>() {
			public boolean satisfies(String s) {
				return false;
			}
		});

		Object[] items = notificationList.toArray();
		notificationList.retain(criteria);
		checkRemoved(counter, items);
	}

	@Test
	public void testRetainAllNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();
		notificationList.retainAll(Power.list("STRANGE1", "STRANGE2"));
		checkRemoved(counter, items);
	}

	@Test
	public void testIteratorRemoveNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();

		for (Iterator<String> iterator = notificationList.iterator(); iterator
				.hasNext();) {
			iterator.next();
			iterator.remove();
		}

		checkRemoved(counter, items);
	}

	@Test
	public void testSublistRemoveNotification() {
		notificationList.assign("A", "B", "C", "D", "E");
		counter.reset();

		Object[] items = notificationList.toArray();

		notificationList.subList(1, 2).remove(0);

		checkRemoved(counter, items[1]);
	}

	private void check(PowerList<?> list, Object... expected) {
		Assert.assertArrayEquals(expected, list.toArray());
	}

	private void checkAdded(CollectionOperationTestListener<String> counter,
			Object... expected) {
		List<CollectionOperationEvent<String>> events = counter.getAdded();
		Assert.assertEquals(expected.length, events.size());

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], events.get(i).getElement());
			Assert.assertTrue(events.get(i).getSource() == notificationList);
		}
	}

	private void checkRemoved(CollectionOperationTestListener<String> counter,
			Object... expected) {
		List<CollectionOperationEvent<String>> events = counter.getRemoved();
		Assert.assertEquals(expected.length, events.size());

		for (int i = 0; i < expected.length; i++) {
			Assert.assertEquals(expected[i], events.get(i).getElement());
			Assert.assertTrue(events.get(i).getSource() == notificationList);
		}
	}

}
