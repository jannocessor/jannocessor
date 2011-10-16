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

package org.jannocessor.service.imports;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.jannocessor.service.api.ImportOrganizer;
import org.junit.Before;
import org.junit.Test;

public class ImportOrganizerTest {

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
	public void testArray() {
		checkImport("int[][]");
		checkImport("java.lang.String[]");
		checkImport("java.util.Date[]", "java.util.Date");
		checkImport("java.util.List<java.util.Map[]>", "java.util.List",
				"java.util.Map");
		checkImport("java.sql.Date[]");

		checkUsage("java.lang.String[]", "String[]");
		checkUsage("int[][]", "int[][]");
		checkUsage("java.util.Date[]", "Date[]");
		checkUsage("java.util.List<java.util.Map[]>", "List<Map[]>");
		checkUsage("java.util.List<java.util.Map[]>[][][][]",
				"List<Map[]>[][][][]");
		checkUsage("java.sql.Date[]", "java.sql.Date[]");
	}

	@Test
	public void testComplexCombinations() {
		checkImport("java.util.Map<java.util.Set<Integer[]>[],int[]>[]",
				"java.util.Map", "java.util.Set");

		checkUsage("java.util.Map<java.util.Set<Integer[]>[],int[]>[]",
				"Map<Set<Integer[]>[],int[]>[]");
	}

	@Test
	public void testBoundTypes() {
		String type1 = "m.X<? extends Object>";
		checkImport(type1, "m.X");
		checkImport(type1);
		checkUsage(type1, "X<? extends Object>");

		String type2 = "a.Y<? extends b.Z>";
		checkImport(type2, "a.Y", "b.Z");
		checkImport(type2);
		checkUsage(type2, "Y<? extends Z>");
	}

	@Test
	public void testComplexBoundTypes() {
		String type = "m.Map<x.y.List<? extends Object>, s.Set<? super x.y.List<? extends a.b.X>>>";

		checkImport(type, "m.Map", "x.y.List", "s.Set", "a.b.X");

		checkImport(type);

		checkUsage(type, "Map<List<? extends Object>,Set<? super List<? extends X>>>");
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
