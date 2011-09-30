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

package org.jannocessor.model.bean.structure;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaClassTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = Param.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = Param.typeParams();

	@AutoTwip
	public static MethodModifiers[] MODIF = less(Param.methodModifiers());

	@AutoTwip
	public static JavaType[][] typeGroups(JavaType type1, JavaType type2) {
		return Param.groups(JavaType.class, type1, type2);
	}

	@AutoTwip
	public static JavaTypeParameter[][] typeParamGroups(
			JavaTypeParameter typeParam1, JavaTypeParameter typeParam2) {
		return Param.groups(JavaTypeParameter.class, typeParam1, typeParam2);
	}

	/******************************** TESTS ********************************/

	@Test
	public void testInstantiation() {
	}

}
