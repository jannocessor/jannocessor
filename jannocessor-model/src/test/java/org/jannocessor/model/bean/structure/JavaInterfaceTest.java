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

import java.util.List;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.collection.Power;
import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Interfaces;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaInterfaceTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = less(Param.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(Param.typeParams());

	@AutoTwip
	public static InterfaceModifiers[] IN_MODIF = less(Param
			.interfaceModifiers());

	@AutoTwip
	public static MethodModifiers[] M_MODIF = less(Param.methodModifiers());

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

	/* *********************** METHOD COMBINATIONS ************************ */

	@AutoTwip
	public static JavaMethod[] methods(MethodModifiers modifiers,
			JavaType returnType, @Values("IDS") String name,
			JavaParameter[] params) {
		return new JavaMethod[] { Code.method(modifiers, returnType, name,
				params) };
	}

	@AutoTwip
	public static JavaMethod[][] methodGroups(JavaMethod method1,
			JavaMethod method2) {
		return Param.groups(JavaMethod.class, method1, method2);
	}

	/* **************************** TESTS ****************************** */

	@Test
	public void testConvenienceMethods() {
		InterfaceModifiers modifiers = Interfaces.PUBLIC;
		String name = "TestInterface";
		List<JavaType> interfaces = Power.list();
		List<JavaMethod> methods = Power.list();
		List<JavaTypeParameter> parameters = Power.list();

		JavaInterface[] instances = allInstances(modifiers, name, interfaces,
				methods, parameters);

		checkAllEquall(instances);
	}

	@Test
	public void testCombinations(InterfaceModifiers modifiers,
			@Values("IDS") String name, JavaType[] superInterfaces,
			JavaMethod[] methods, JavaTypeParameter[] parameters) {

		JavaInterface[] instances1 = allInstances(modifiers, name,
				Power.list(superInterfaces), Power.list(methods),
				Power.list(parameters));

		JavaInterface[] instances2 = allInstances(modifiers, name,
				Power.list(superInterfaces), Power.list(methods),
				Power.list(parameters));

		Assert.assertArrayEquals(instances1, instances2);

		for (JavaInterface interfacee : instances1) {
			checkElementName(interfacee, name);
		}
	}

	private JavaInterface[] allInstances(InterfaceModifiers modifiers,
			String name, List<JavaType> interfaces, List<JavaMethod> methods,
			List<JavaTypeParameter> parameters) {

		JavaInterface obj1 = Code.interfacee(modifiers, name, interfaces,
				methods, parameters);
		checkInterface(obj1, modifiers, name, interfaces, methods, parameters);

		JavaInterface obj2 = Code.interfacee(modifiers, name, interfaces,
				methods);
		checkInterface(obj2, modifiers, name, interfaces, methods,
				Code.NO_TYPE_PARAMS);

		JavaInterface obj3 = Code.interfacee(name, interfaces, methods);
		checkInterface(obj3, Interfaces.PUBLIC, name, interfaces, methods,
				Code.NO_TYPE_PARAMS);

		JavaInterface obj4 = Code.interfacee(name, methods);
		checkInterface(obj4, Interfaces.PUBLIC, name, Code.NO_TYPES, methods,
				Code.NO_TYPE_PARAMS);

		return new JavaInterface[] { obj1, obj2, obj3, obj4 };
	}

}
