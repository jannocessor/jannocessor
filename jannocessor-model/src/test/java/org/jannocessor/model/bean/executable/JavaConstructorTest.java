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

package org.jannocessor.model.bean.executable;

import static org.junit.Assert.assertNotNull;
import net.sf.twip.TwiP;

import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaParameter;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaConstructorTest {

	@Test
	public void testInstantiation() {
		JavaConstructor constructor = Code.constructor();
		assertNotNull(constructor);

		MethodModifiers modifiers = Code.methodModifiers();
		JavaParameter param1 = Code.parameter(String.class, "foo");
		JavaParameter param2 = Code.parameter(int.class, "bar", true);

		JavaConstructor constructor1 = Code.constructor(param1, param2);
		assertNotNull(constructor1);

		JavaConstructor constructor2 = Code.constructor(modifiers, param1,
				param2);
		assertNotNull(constructor2);
	}

}
