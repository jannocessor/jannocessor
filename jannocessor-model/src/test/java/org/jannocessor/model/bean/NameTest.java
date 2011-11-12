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

package org.jannocessor.model.bean;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import net.sf.twip.TwiP;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class NameTest extends AbstractModelTest {

	private String smallCamelCase = "firstSecondThird";
	private String bigCamelCase = "FirstSecondThird";
	private String numericCamelCase = "first1Second2Third3";
	private String complexCamelCase = "firstSECONDThird";
	private String complexNumericCamelCase = "first1SECOND2Third3";
	private String smallUnderscore = "first_second_third";
	private String bigUnderscore = "FIRST_SECOND_THIRD";

	/*
	 * TEST SPLITING NAME INTO PARTS
	 */

	@Test
	public void testGetParts() {
		checkParts(smallCamelCase, "first", "Second", "Third");
		checkParts(bigCamelCase, "First", "Second", "Third");
		checkParts(numericCamelCase, "first1", "Second2", "Third3");
		checkParts(complexCamelCase, "first", "SECOND", "Third");
		checkParts(complexNumericCamelCase, "first1", "SECOND2", "Third3");
		checkParts(smallUnderscore, "first", "second", "third");
		checkParts(bigUnderscore, "FIRST", "SECOND", "THIRD");
	}

	private void checkParts(String name, String... expectedParts) {
		String[] parts = name(name).getParts();

		assertEquals(expectedParts.length, parts.length);
		for (int i = 0; i < parts.length; i++) {
			assertEquals(expectedParts[i], parts[i]);
		}
	}

	private NameBean name(String name) {
		return new NameBean(name);
	}

	/*
	 * TEST DELETING NAME PARTS
	 */

	@Test
	public void testDeleteCamelcaseParts() {
		checkDeleteParts(smallCamelCase, "secondThird", 0);
		checkDeleteParts(smallCamelCase, "firstThird", 1);
		checkDeleteParts(smallCamelCase, "firstSecond", -1);

		checkDeleteParts(smallCamelCase, "third", 0, 1);
		checkDeleteParts(smallCamelCase, "first", 1, 2);
		checkDeleteParts(smallCamelCase, "second", 0, 2);
	}

	@Test
	public void testDeleteUnderscoreParts() {
		checkDeleteParts(smallUnderscore, "second_third", 0);
		checkDeleteParts(smallUnderscore, "first_third", -2);
		checkDeleteParts(smallUnderscore, "first_second", 2);

		checkDeleteParts(smallUnderscore, "third", 0, 1);
		checkDeleteParts(smallUnderscore, "first", 1, 2);
		checkDeleteParts(smallUnderscore, "second", -3, 2);
	}

	private void checkDeleteParts(String name, String expectedName,
			int... positions) {
		String newName = name(name).deleteParts(positions).getText();

		assertEquals(expectedName, newName);
	}

	@Test(expected = IllegalStateException.class)
	public void testDeleteAllParts() {
		name(smallCamelCase).deleteParts(0, 1, 2);
	}

	/*
	 * TEST INSERTING NAME PARTS
	 */

	@Test
	public void testInsertCamelcaseParts() {
		checkInsertParts(bigCamelCase, 0, "New", "NewFirstSecondThird");
		checkInsertParts(bigCamelCase, 1, "New", "FirstNewSecondThird");
		checkInsertParts(bigCamelCase, -1, "New", "FirstSecondNewThird");
		checkInsertParts(bigCamelCase, 3, "New", "FirstSecondThirdNew");

		checkInsertParts(smallCamelCase, 0, "new", "newFirstSecondThird");
		checkInsertParts(smallCamelCase, 1, "new", "firstnewSecondThird");
	}


	private void checkInsertParts(String name, int position, String part,
			String expectedName) {
		String newName = name(name).insertPart(position, part).getText();

		assertEquals(expectedName, newName);
	}

	/*
	 * OTHER TESTS
	 */

	@Test
	public void testEquals() {
		assertEquals(name("a"), name("a"));
		assertFalse(name("b").equals(name("c")));
	}


}
