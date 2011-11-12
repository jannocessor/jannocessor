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

package org.jannocessor.service.representation;

import junit.framework.Assert;
import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;

import org.apache.commons.lang.StringEscapeUtils;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaRepresenterImplTest {

	private JavaRepresenter representer = new JavaRepresenterImpl();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@Test
	public void shouldRepresentJavaNumbers(int value) {
		checkRepresentation(String.valueOf(value), value);
	}

	@Test
	public void shouldRepresentJavaBooleans(boolean value) {
		checkRepresentation(String.valueOf(value), value);
	}

	@Test
	public void shouldRepresentJavaStrings(String value) {
		checkRepresentation('"' + StringEscapeUtils.escapeJava(value) + '"',
				value);
	}

	@Test
	public void shouldEscapeJavaStrings() {
		String value = "a\"b\"c";
		String escaped = "\"a\\\"b\\\"c\"";
		checkRepresentation(escaped, value);
	}

	@Test
	public void shouldRepresentJavaClasses(Class<?> clazz) {
		String escaped = clazz.getSimpleName() + ".class";
		checkRepresentation(escaped, clazz);
	}

	private void checkRepresentation(String expected, Object value) {
		Assert.assertEquals(expected, representer.getJavaRepresentation(value));
	}

}
