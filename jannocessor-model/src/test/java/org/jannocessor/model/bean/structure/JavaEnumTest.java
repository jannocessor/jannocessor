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

package org.jannocessor.model.bean.structure;

import java.util.List;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.collection.Power;
import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Enums;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaEnumTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = less(ModelParam.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaEnumConstant[] E_CONST = less(ModelParam.enumConstants());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(ModelParam.typeParams());

	@AutoTwip
	public static EnumModifiers[] E_MODIF = less(ModelParam.enumModifiers());

	@AutoTwip
	public static FieldModifiers[] F_MODIF = less(ModelParam.fieldModifiers());

	@AutoTwip
	public static MethodModifiers[] M_MODIF = less(ModelParam.methodModifiers());

	@AutoTwip
	public static ConstructorModifiers[] CO_MODIF = less(ModelParam
			.constructorModifiers());

	/* ********************** TYPE COMBINATIONS ************************** */

	@AutoTwip
	public static JavaType[][] typeGroups(JavaType type1, JavaType type2) {
		return few(Param.groups(JavaType.class, type1, type2));
	}

	/* ********************* TYPE PARAM COMBINATIONS ********************** */

	@AutoTwip
	public static JavaTypeParameter[][] typeParamGroups(
			JavaTypeParameter typeParam1, JavaTypeParameter typeParam2) {
		return few(Param
				.groups(JavaTypeParameter.class, typeParam1, typeParam2));
	}

	/* ********************* PARAMETER COMBINATIONS ******************** */

	@AutoTwip
	public static JavaParameter[] parameters(JavaType type,
			@Values("IDS") String name) {
		return new JavaParameter[] { New.parameter(type, name) };
	}

	@AutoTwip
	public static JavaParameter[][] parameterGroups(JavaParameter param1,
			JavaParameter param2) {
		return few(Param.groups(JavaParameter.class, param1, param2));
	}

	/* *********************** METHOD COMBINATIONS ************************ */

	@AutoTwip
	public static JavaMethod[] methods(MethodModifiers modifiers,
			JavaType returnType, @Values("IDS") String name,
			JavaParameter[] params) {
		return new JavaMethod[] { New.method(modifiers, returnType, name,
				params) };
	}

	@AutoTwip
	public static JavaMethod[][] methodGroups(JavaMethod method1,
			JavaMethod method2) {
		return few(Param.groups(JavaMethod.class, method1, method2));
	}

	/* ********************* FIELD COMBINATIONS ************************* */

	@AutoTwip
	public static JavaField[] fields(FieldModifiers modifiers, JavaType type,
			@Values("IDS") String name) {
		return new JavaField[] { New.field(modifiers, type, name) };
	}

	@AutoTwip
	public static JavaField[][] fieldGroups(JavaField field1, JavaField field2) {
		return few(Param.groups(JavaField.class, field1, field2));
	}

	/* ******************** CONSTRUCTOR COMBINATIONS *********************** */

	@AutoTwip
	public static JavaConstructor[] constructors(
			ConstructorModifiers modifiers, JavaParameter[] params,
			JavaType[] thrownTypes, JavaTypeParameter[] typeParameters) {

		return new JavaConstructor[] { New.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParameters)) };
	}

	@AutoTwip
	public static JavaConstructor[][] constructorGroups(
			JavaConstructor constructor1, JavaConstructor constructor2) {
		return few(Param.groups(JavaConstructor.class, constructor1,
				constructor2));
	}

	/* ******************** ENUM VALUES COMBINATIONS *********************** */

	@AutoTwip
	public static JavaEnumConstant[][] enumConstantsGroups(
			JavaEnumConstant const1, JavaEnumConstant const2) {
		return few(Param.groups(JavaEnumConstant.class, const1, const2));
	}

	/* **************************** TESTS ****************************** */

	@Test
	public void testConvenienceMethods() {
		EnumModifiers modifiers = Enums.PUBLIC;
		String name = "TestEnum";
		List<JavaType> interfaces = Power.list();
		List<JavaEnumConstant> values = Power.list();
		List<JavaField> fields = Power.list();
		List<JavaConstructor> constructors = Power.list();
		List<JavaMethod> methods = Power.list();

		JavaEnum[] instances = allInstances(modifiers, name, interfaces,
				values, fields, constructors, methods);

		checkAllEquall(instances);
	}

	@Test
	public void testCombinations(EnumModifiers modifiers,
			@Values("IDS") String name, JavaType[] interfaces,
			JavaEnumConstant[] values, JavaField[] fields,
			JavaConstructor[] constructors, JavaMethod[] methods) {

		JavaEnum[] instances1 = allInstances(modifiers, name,
				Power.list(interfaces), Power.list(values), Power.list(fields),
				Power.list(constructors), Power.list(methods));

		JavaEnum[] instances2 = allInstances(modifiers, name,
				Power.list(interfaces), Power.list(values), Power.list(fields),
				Power.list(constructors), Power.list(methods));

		Assert.assertArrayEquals(instances1, instances2);

		for (JavaEnum clazz : instances1) {
			checkElementName(clazz, name);
		}
	}

	private JavaEnum[] allInstances(EnumModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaEnumConstant> values,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {

		JavaEnum obj1 = New.enumm(modifiers, name, interfaces, values, fields,
				constructors, methods);
		checkEnum(obj1, modifiers, name, interfaces, values, fields,
				constructors, methods);

		JavaEnum obj2 = New.enumm(modifiers, name, values, fields,
				constructors, methods);
		checkEnum(obj2, modifiers, name, New.NO_TYPES, values, fields,
				constructors, methods);

		JavaEnum obj3 = New.enumm(modifiers, name, values, fields,
				constructors);
		checkEnum(obj3, modifiers, name, New.NO_TYPES, values, fields,
				constructors, New.NO_METHODS);

		JavaEnum obj4 = New.enumm(modifiers, name, values);
		checkEnum(obj4, modifiers, name, New.NO_TYPES, values, New.NO_FIELDS,
				New.NO_CONSTRUCTORS, New.NO_METHODS);

		JavaEnum obj5 = New.enumm(name, values);
		checkEnum(obj5, Enums.PUBLIC, name, New.NO_TYPES, values,
				New.NO_FIELDS, New.NO_CONSTRUCTORS, New.NO_METHODS);

		return new JavaEnum[] { obj1, obj2, obj3, obj4, obj5 };
	}

}
