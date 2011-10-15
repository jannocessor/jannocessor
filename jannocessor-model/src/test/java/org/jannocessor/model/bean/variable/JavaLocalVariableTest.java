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
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaLocalVariableTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = Param.identifiers();

	@AutoTwip
	public static JavaType[] TYPES = ModelParam.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@Test
	public void testInstantiation1(Class<?> type, @Values("IDS") String name) {
		JavaLocalVariable var = Code.localVariable(type, name);
		checkLonelyElement(var, name, type);

		assertEquals(Boolean.FALSE, var.isFinal());
	}

	@Test
	public void testInstantiation1(Class<?> type, @Values("IDS") String name,
			Boolean isFinal) {
		JavaLocalVariable var = Code.localVariable(type, name, isFinal);
		checkLonelyElement(var, name, type);

		assertEquals(isFinal, var.isFinal());
	}

	@Test
	public void testInstantiation2(JavaType type, @Values("IDS") String name) {
		JavaLocalVariable var = Code.localVariable(type, name);
		checkLonelyElement(var, name, type);

		assertEquals(Boolean.FALSE, var.isFinal());
	}

	@Test
	public void testInstantiation2(JavaType type, @Values("IDS") String name,
			Boolean isFinal) {
		JavaLocalVariable var = Code.localVariable(type, name, isFinal);
		checkLonelyElement(var, name, type);

		assertEquals(isFinal, var.isFinal());
	}

}
