/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
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
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.New;
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
	public static JavaType[] TYPES = less(ModelParam.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(ModelParam.typeParams());

	@AutoTwip
	public static ClassModifiers[] CL_MODIF = less(ModelParam.classModifiers());

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
		return less(Param.groups(JavaType.class, type1, type2));
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
		JavaClass obj1 = New.classs(modifiers, name, superclass, interfaces,
				fields, constructors, methods, parameters);
		checkClass(obj1, modifiers, name, superclass, interfaces, fields,
				constructors, methods, parameters);

		JavaClass obj2 = New.classs(modifiers, name, superclass, interfaces,
				fields, constructors, methods);
		checkClass(obj2, modifiers, name, superclass, interfaces, fields,
				constructors, methods, New.NO_TYPE_PARAMS);

		JavaClass obj3 = New.classs(modifiers, name, superclass, interfaces,
				fields, constructors);
		checkClass(obj3, modifiers, name, superclass, interfaces, fields,
				constructors, New.NO_METHODS, New.NO_TYPE_PARAMS);

		JavaClass obj4 = New.classs(modifiers, name, superclass, interfaces,
				fields);
		checkClass(obj4, modifiers, name, superclass, interfaces, fields,
				New.NO_CONSTRUCTORS, New.NO_METHODS, New.NO_TYPE_PARAMS);

		JavaClass obj5 = New.classs(modifiers, name, superclass, interfaces);
		checkClass(obj5, modifiers, name, superclass, interfaces,
				New.NO_FIELDS, New.NO_CONSTRUCTORS, New.NO_METHODS,
				New.NO_TYPE_PARAMS);

		JavaClass obj6 = New.classs(modifiers, name, superclass);
		checkClass(obj6, modifiers, name, superclass, New.NO_TYPES,
				New.NO_FIELDS, New.NO_CONSTRUCTORS, New.NO_METHODS,
				New.NO_TYPE_PARAMS);

		JavaClass obj7 = New.classs(modifiers, name);
		checkClass(obj7, modifiers, name, null, New.NO_TYPES,
				New.NO_FIELDS, New.NO_CONSTRUCTORS, New.NO_METHODS,
				New.NO_TYPE_PARAMS);

		JavaClass obj8 = New.classs(modifiers, name, fields, methods);
		checkClass(obj8, modifiers, name, null, New.NO_TYPES, fields,
				New.NO_CONSTRUCTORS, methods, New.NO_TYPE_PARAMS);

		JavaClass obj9 = New.classs(modifiers, name, fields, methods,
				constructors);
		checkClass(obj9, modifiers, name, null, New.NO_TYPES, fields,
				constructors, methods, New.NO_TYPE_PARAMS);

		return new JavaClass[] { obj1, obj2, obj3, obj4, obj5, obj6, obj7,
				obj8, obj9 };
	}

}
