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
