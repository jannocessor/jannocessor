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

package org.jannocessor.model.bean.executable;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.collection.Power;
import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaConstructorTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = Param.types();

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = Param.typeParams();

	@AutoTwip
	public static ConstructorModifiers[] MODIF = Param.constructorModifiers();

	/* ********************* PARAMETER COMBINATIONS ******************** */

	@AutoTwip
	public static JavaParameter[] parameters(JavaType type,
			@Values("IDS") String name) {
		return new JavaParameter[] { Code.parameter(type, name) };
	}

	@AutoTwip
	public static JavaParameter[][] parameterGroups(JavaParameter param1,
			JavaParameter param2) {
		return Param.groups(JavaParameter.class, param1, param2);
	}

	/* ********************** TYPE COMBINATIONS ************************** */

	@AutoTwip
	public static JavaType[][] typeGroups(JavaType type1, JavaType type2) {
		return Param.groups(JavaType.class, type1, type2);
	}

	/* ********************* TYPE PARAM COMBINATIONS ********************** */

	@AutoTwip
	public static JavaTypeParameter[][] typeParamGroups(
			JavaTypeParameter typeParam1, JavaTypeParameter typeParam2) {
		return Param.groups(JavaTypeParameter.class, typeParam1, typeParam2);
	}

	/* **************************** TESTS ****************************** */

	@Test
	public void testInstantiation1() {
		JavaConstructor constructor = Code.constructor();

		checkConstructor(constructor, Constructors.PUBLIC, Code.NO_PARAMS,
				Code.NO_TYPES, Code.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation2(JavaParameter[] params) {
		JavaConstructor constructor = Code.constructor(params);

		checkConstructor(constructor, Constructors.PUBLIC, Power.list(params),
				Code.NO_TYPES, Code.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation3(ConstructorModifiers modifiers,
			JavaParameter[] params) {
		JavaConstructor constructor = Code.constructor(modifiers, params);

		checkConstructor(constructor, modifiers, Power.list(params),
				Code.NO_TYPES, Code.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation4(ConstructorModifiers modifiers,
			JavaParameter[] params) {
		JavaConstructor constructor = Code.constructor(modifiers,
				Power.list(params));

		checkConstructor(constructor, modifiers, Power.list(params),
				Code.NO_TYPES, Code.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation5(ConstructorModifiers modifiers,
			JavaParameter[] params, JavaType[] thrownTypes) {
		JavaConstructor constructor = Code.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes));

		checkConstructor(constructor, modifiers, Power.list(params),
				Power.list(thrownTypes), Code.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation6(ConstructorModifiers modifiers,
			JavaParameter[] params, JavaType[] thrownTypes,
			JavaTypeParameter[] typeParams) {
		JavaConstructor constructor = Code.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParams));

		checkConstructor(constructor, modifiers, Power.list(params),
				Power.list(thrownTypes), Power.list(typeParams), false);
	}

}
