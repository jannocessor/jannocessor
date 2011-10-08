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
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaClassTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = less(Param.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(Param.typeParams());

	@AutoTwip
	public static ClassModifiers[] CL_MODIF = less(Param.classModifiers());

	@AutoTwip
	public static FieldModifiers[] F_MODIF = less(Param.fieldModifiers());

	@AutoTwip
	public static MethodModifiers[] M_MODIF = less(Param.methodModifiers());

	@AutoTwip
	public static ConstructorModifiers[] CO_MODIF = less(Param
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
		return new JavaParameter[] { Code.parameter(type, name) };
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
		return new JavaMethod[] { Code.method(modifiers, returnType, name,
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
		return new JavaField[] { Code.field(modifiers, type, name) };
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

		return new JavaConstructor[] { Code.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParameters)) };
	}

	@AutoTwip
	public static JavaConstructor[][] constructorGroups(
			JavaConstructor constructor1, JavaConstructor constructor2) {
		return few(Param.groups(JavaConstructor.class, constructor1,
				constructor2));
	}

	/* **************************** TESTS ****************************** */

	@Test
	public void testConvenienceMethods() {
		ClassModifiers modifiers = Classes.PUBLIC_FINAL;
		String name = "TestClass";
		JavaType superclass = null;
		List<JavaType> interfaces = Power.list();
		List<JavaField> fields = Power.list();
		List<JavaConstructor> constructors = Power.list();
		List<JavaMethod> methods = Power.list();
		List<JavaTypeParameter> parameters = Power.list();

		JavaClass[] instances = allInstances(modifiers, name, superclass,
				interfaces, fields, constructors, methods, parameters);

		checkAllEquall(instances);
	}

	@Test
	public void testCombinations(ClassModifiers modifiers,
			@Values("IDS") String name, JavaType superclass,
			JavaType[] interfaces, JavaField[] fields,
			JavaConstructor[] constructors, JavaMethod[] methods,
			JavaTypeParameter[] parameters) {

		JavaClass[] instances1 = allInstances(modifiers, name, superclass,
				Power.list(interfaces), Power.list(fields),
				Power.list(constructors), Power.list(methods),
				Power.list(parameters));

		JavaClass[] instances2 = allInstances(modifiers, name, superclass,
				Power.list(interfaces), Power.list(fields),
				Power.list(constructors), Power.list(methods),
				Power.list(parameters));

		Assert.assertArrayEquals(instances1, instances2);

		for (JavaClass clazz : instances1) {
			checkElementName(clazz, name);
		}
	}

	private JavaClass[] allInstances(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		JavaClass obj1 = Code.classs(modifiers, name, superclass, interfaces,
				fields, constructors, methods, parameters);
		checkClass(obj1, modifiers, name, superclass, interfaces, fields,
				constructors, methods, parameters);

		JavaClass obj2 = Code.classs(modifiers, name, superclass, interfaces,
				fields, constructors, methods);
		checkClass(obj2, modifiers, name, superclass, interfaces, fields,
				constructors, methods, Code.NO_TYPE_PARAMS);

		JavaClass obj3 = Code.classs(modifiers, name, superclass, interfaces,
				fields, constructors);
		checkClass(obj3, modifiers, name, superclass, interfaces, fields,
				constructors, Code.NO_METHODS, Code.NO_TYPE_PARAMS);

		JavaClass obj4 = Code.classs(modifiers, name, superclass, interfaces,
				fields);
		checkClass(obj4, modifiers, name, superclass, interfaces, fields,
				Code.NO_CONSTRUCTORS, Code.NO_METHODS, Code.NO_TYPE_PARAMS);

		JavaClass obj5 = Code.classs(modifiers, name, superclass, interfaces);
		checkClass(obj5, modifiers, name, superclass, interfaces,
				Code.NO_FIELDS, Code.NO_CONSTRUCTORS, Code.NO_METHODS,
				Code.NO_TYPE_PARAMS);

		JavaClass obj6 = Code.classs(modifiers, name, superclass);
		checkClass(obj6, modifiers, name, superclass, Code.NO_TYPES,
				Code.NO_FIELDS, Code.NO_CONSTRUCTORS, Code.NO_METHODS,
				Code.NO_TYPE_PARAMS);

		JavaClass obj7 = Code.classs(modifiers, name);
		checkClass(obj7, modifiers, name, null, Code.NO_TYPES,
				Code.NO_FIELDS, Code.NO_CONSTRUCTORS, Code.NO_METHODS,
				Code.NO_TYPE_PARAMS);

		JavaClass obj8 = Code.classs(modifiers, name, fields, methods);
		checkClass(obj8, modifiers, name, null, Code.NO_TYPES, fields,
				Code.NO_CONSTRUCTORS, methods, Code.NO_TYPE_PARAMS);

		JavaClass obj9 = Code.classs(modifiers, name, fields, methods,
				constructors);
		checkClass(obj9, modifiers, name, null, Code.NO_TYPES, fields,
				constructors, methods, Code.NO_TYPE_PARAMS);

		return new JavaClass[] { obj1, obj2, obj3, obj4, obj5, obj6, obj7,
				obj8, obj9 };
	}

}
