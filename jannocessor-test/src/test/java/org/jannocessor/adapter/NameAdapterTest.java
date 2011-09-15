/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.adapter;

import static org.junit.Assert.assertEquals;

import org.jannocessor.test.AbstractTest;
import org.junit.Test;

public class NameAdapterTest extends AbstractTest {

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

	private NameAdapter name(String name) {
		return new NameAdapter(name);
	}

	/*
	 * TEST DELETING NAME PARTS
	 */

	@Test
	public void testDeleteCamelcaseParts() {
		checkDeleteParts(smallCamelCase, "secondThird", 0);
		checkDeleteParts(smallCamelCase, "firstThird", 1);
		checkDeleteParts(smallCamelCase, "firstSecond", 2);

		checkDeleteParts(smallCamelCase, "third", 0, 1);
		checkDeleteParts(smallCamelCase, "first", 1, 2);
		checkDeleteParts(smallCamelCase, "second", 0, 2);
	}

	@Test
	public void testDeleteUnderscoreParts() {
		checkDeleteParts(smallUnderscore, "second_third", 0);
		checkDeleteParts(smallUnderscore, "first_third", 1);
		checkDeleteParts(smallUnderscore, "first_second", 2);

		checkDeleteParts(smallUnderscore, "third", 0, 1);
		checkDeleteParts(smallUnderscore, "first", 1, 2);
		checkDeleteParts(smallUnderscore, "second", 0, 2);
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
		checkInsertParts(bigCamelCase, 2, "New", "FirstSecondNewThird");
		checkInsertParts(bigCamelCase, 3, "New", "FirstSecondThirdNew");
	}

	private void checkInsertParts(String name, int position, String part,
			String expectedName) {
		String newName = name(name).insertPart(position, part).getText();

		assertEquals(expectedName, newName);
	}

}
