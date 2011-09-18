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

package org.jannocessor.service.imports;

import static org.junit.Assert.*;

import org.jannocessor.service.api.ImportOrganizer;
import org.jannocessor.test.AbstractTest;
import org.junit.Before;
import org.junit.Test;

public class ImportOrganizerTest extends AbstractTest {

	private ImportOrganizer organizer;

	@Before
	public void initialize() {
		organizer = new ImportOrganizerImpl();
	}

	@Test
	public void testPrimitives() {
		checkImport("int");
		checkImport("boolean");

		checkUsage("int", "int");
		checkUsage("boolean", "boolean");
	}

	@Test
	public void testJavaLang() {
		checkImport("java.lang.String");
		checkImport("java.lang.Integer");

		checkUsage("java.lang.String", "String");
		checkUsage("java.lang.Integer", "Integer");
	}

	@Test
	public void testNonConflicting() {
		checkImport("java.util.List", "java.util.List");
		checkImport("java.util.Map", "java.util.Map");

		checkImport("java.util.List");
		checkImport("java.util.Map");

		checkUsage("java.util.List", "List");
		checkUsage("java.util.Map", "Map");
	}

	@Test
	public void testConflicting() {
		checkImport("java.util.Date", "java.util.Date");
		checkImport("java.sql.Date");

		checkImport("java.util.Date");
		checkImport("java.sql.Date");

		checkUsage("java.util.Date", "Date");
		checkUsage("java.sql.Date", "java.sql.Date");
	}

	@Test
	public void testSimpleGenerics() {
		checkImport("java.util.List<java.lang.String,int>", "java.util.List");
		checkImport("java.util.Map<java.lang.Integer, java.lang.Boolean>",
				"java.util.Map");

		checkImport("java.util.List<java.lang.String,int>");
		checkImport("java.util.Map<java.lang.Integer, java.lang.Boolean>");

		checkUsage("java.util.List<java.lang.String,int>", "List<String,int>");
	}

	@Test
	public void testComplexGenerics() {
		checkImport("java.util.Map<java.sql.Date, a.b.SomeClass>",
				"java.util.Map", "java.sql.Date", "a.b.SomeClass");

		checkImport("java.util.Map<java.sql.Date, a.b.SomeClass>");

		checkUsage("java.util.Map<java.sql.Date, a.b.SomeClass>",
				"Map<Date,SomeClass>");
	}

	@Test
	public void testNestedGenerics() {
		checkImport("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>",
				"a.X", "b.Y", "c.Z", "d.K", "e.L");

		checkImport("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>");

		checkUsage("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>",
				"X<Y<Z,String>,K<Y,int,L>>");
	}

	@Test
	public void testWhiteSpace() {
		checkImport("a.X<b.Y<c.Z,d.K>,e.L>", "a.X", "b.Y", "c.Z", "d.K", "e.L");

		checkImport("a.X < b.Y < c.Z, d.K >, e.L >");
	}

	private void checkImport(String classname, String... expected) {
		assertArrayEquals(expected, organizer.getTypeImports(classname));
	}

	private void checkUsage(String classname, String expected) {
		assertEquals(expected, organizer.getTypeUsage(classname));
	}

}
