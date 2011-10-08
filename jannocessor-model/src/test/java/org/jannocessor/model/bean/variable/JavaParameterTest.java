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

package org.jannocessor.model.bean.variable;

import static junit.framework.Assert.assertEquals;
import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaParameterTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = Param.identifiers();

	@AutoTwip
	public static JavaType[] TYPES = Param.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@Test
	public void testInstantiation1(Class<?> type, @Values("IDS") String name) {
		JavaParameter param = Code.parameter(type, name);
		checkLonelyElement(param, name, type);

		assertEquals(false, param.isFinal());
	}

	@Test
	public void testInstantiation2(Class<?> type, @Values("IDS") String name,
			boolean isFinal) {
		JavaParameter param = Code.parameter(type, name, isFinal);
		checkLonelyElement(param, name, type);

		assertEquals(isFinal, param.isFinal());
	}

	@Test
	public void testInstantiation3(JavaType type, @Values("IDS") String name) {
		JavaParameter param = Code.parameter(type, name);
		checkLonelyElement(param, name, type);

		assertEquals(false, param.isFinal());
	}

	@Test
	public void testInstantiation4(JavaType type, @Values("IDS") String name,
			boolean isFinal) {
		JavaParameter param = Code.parameter(type, name, isFinal);
		checkLonelyElement(param, name, type);

		assertEquals(isFinal, param.isFinal());
	}

}
