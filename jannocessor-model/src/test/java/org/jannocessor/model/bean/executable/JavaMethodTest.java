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
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaMethodTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = ModelParam.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = ModelParam.typeParams();

	@AutoTwip
	public static MethodModifiers[] MODIF = less(ModelParam.methodModifiers());

	/* ********************* PARAMETER COMBINATIONS ******************** */

	@AutoTwip
	public static JavaParameter[] parameters(JavaType type,
			@Values("IDS") String name) {
		return new JavaParameter[] { New.parameter(type, name) };
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
	public void testInstantiation1(MethodModifiers modifiers,
			JavaType returnType, @Values("IDS") String name,
			JavaParameter[] params) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params));

		checkMethod(method, modifiers, returnType, name, Power.list(params),
				New.NO_TYPES, New.NO_TYPE_PARAMS);
	}

	@Test
	public void testInstantiation2(MethodModifiers modifiers,
			Class<?> returnType, @Values("IDS") String name,
			JavaParameter[] params) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params));

		checkMethod(method, modifiers, New.type(returnType), name,
				Power.list(params), New.NO_TYPES, New.NO_TYPE_PARAMS);
	}

	@Test
	public void testInstantiation3(MethodModifiers modifiers,
			JavaType returnType, @Values("IDS") String name,
			JavaParameter[] params, JavaType[] thrownTypes) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params), Power.list(thrownTypes));

		checkMethod(method, modifiers, returnType, name, Power.list(params),
				Power.list(thrownTypes), New.NO_TYPE_PARAMS);
	}

	@Test
	public void testInstantiation4(MethodModifiers modifiers,
			Class<?> returnType, @Values("IDS") String name,
			JavaParameter[] params, JavaType[] thrownTypes) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params), Power.list(thrownTypes));

		checkMethod(method, modifiers, New.type(returnType), name,
				Power.list(params), Power.list(thrownTypes),
				New.NO_TYPE_PARAMS);
	}

	@Test
	public void testInstantiation5(MethodModifiers modifiers,
			JavaType returnType, @Values("IDS") String name,
			JavaParameter[] params, JavaType[] thrownTypes,
			JavaTypeParameter[] typeParams) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParams));

		checkMethod(method, modifiers, returnType, name, Power.list(params),
				Power.list(thrownTypes), Power.list(typeParams));
	}

	@Test
	public void testInstantiation6(MethodModifiers modifiers,
			Class<?> returnType, @Values("IDS") String name,
			JavaParameter[] params, JavaType[] thrownTypes,
			JavaTypeParameter[] typeParams) {

		JavaMethod method = New.method(modifiers, returnType, name,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParams));

		checkMethod(method, modifiers, New.type(returnType), name,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParams));
	}

}
