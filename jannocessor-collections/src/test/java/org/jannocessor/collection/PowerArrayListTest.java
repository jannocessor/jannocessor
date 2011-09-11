package org.jannocessor.collection;

import org.jannocessor.collection.api.PowerList;
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

	private void check(PowerList<?> list, Object... expected) {
		Assert.assertArrayEquals(expected, list.toArray());
	}

}
