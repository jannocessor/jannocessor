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
				"Map<Set<Integer[]>[], int[]>[]");
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
	public void testParameterTypes() {
		String type1 = "m.X<T extends Object>";
		checkImport(type1, "m.X");
		checkImport(type1);
		checkUsage(type1, "X<T extends Object>");

		String type2 = "a.Y<Ttt extends b.Z>";
		checkImport(type2, "a.Y", "b.Z");
		checkImport(type2);
		checkUsage(type2, "Y<Ttt extends Z>");
	}

	@Test
	public void testComplexBoundTypes() {
		String type = "m.Map<x.y.List<? extends Object>, s.Set<? super x.y.List<? extends a.b.X>>>";

		checkImport(type, "m.Map", "x.y.List", "s.Set", "a.b.X");

		checkImport(type);

		checkUsage(type, "Map<List<? extends Object>, Set<? super List<? extends X>>>");
	}

	@Test
	public void testSimpleGenerics() {
		checkImport("java.util.List<java.lang.String,int>", "java.util.List");
		checkImport("java.util.Map<java.lang.Integer, java.lang.Boolean>",
				"java.util.Map");

		checkImport("java.util.List<java.lang.String,int>");
		checkImport("java.util.Map<java.lang.Integer, java.lang.Boolean>");

		checkUsage("java.util.List<java.lang.String, int>", "List<String, int>");
	}

	@Test
	public void testComplexGenerics() {
		checkImport("java.util.Map<java.sql.Date, a.b.SomeClass>",
				"java.util.Map", "java.sql.Date", "a.b.SomeClass");

		checkImport("java.util.Map<java.sql.Date, a.b.SomeClass>");

		checkUsage("java.util.Map<java.sql.Date, a.b.SomeClass>",
				"Map<Date, SomeClass>");
	}

	@Test
	public void testNestedGenerics() {
		checkImport("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>",
				"a.X", "b.Y", "c.Z", "d.K", "e.L");

		checkImport("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>");

		checkUsage("a.X<b.Y<c.Z, java.lang.String>, d.K<b.Y, int, e.L>>",
				"X<Y<Z, String>, K<Y, int, L>>");
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
