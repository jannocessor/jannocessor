/**
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
