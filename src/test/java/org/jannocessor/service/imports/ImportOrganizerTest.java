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

import junit.framework.Assert;

import org.jannocessor.service.api.ImportOrganizer;
import org.jannocessor.service.imports.ImportOrganizerImpl;
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
	public void testJavaLang() {
		checkImport("java.lang.String", null);
		checkImport("java.lang.Integer", null);

		checkUsage("java.lang.String", "String");
		checkUsage("java.lang.Integer", "Integer");
	}

	@Test
	public void testNonConflicting() {
		checkImport("java.util.List", "java.util.List");
		checkImport("java.util.Map", "java.util.Map");

		checkImport("java.util.List", null);
		checkImport("java.util.Map", null);

		checkUsage("java.util.List", "List");
		checkUsage("java.util.Map", "Map");
	}

	@Test
	public void testConflicting() {
		checkImport("java.util.Date", "java.util.Date");
		checkImport("java.sql.Date", null);

		checkImport("java.util.Date", null);
		checkImport("java.sql.Date", null);

		checkUsage("java.util.Date", "Date");
		checkUsage("java.sql.Date", "java.sql.Date");
	}

	private void checkImport(String classname, String expected) {
		Assert.assertEquals(expected, organizer.getTypeImport(classname));
	}

	private void checkUsage(String classname, String expected) {
		Assert.assertEquals(expected, organizer.getTypeUsage(classname));
	}

}
