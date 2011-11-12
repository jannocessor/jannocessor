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
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Interfaces;
import org.jannocessor.model.variable.JavaField;
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
	public static JavaType[] TYPES = less(ModelParam.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(ModelParam.typeParams());

	@AutoTwip
	public static InterfaceModifiers[] IN_MODIF = less(ModelParam
			.interfaceModifiers());

	@AutoTwip
	public static FieldModifiers[] F_MODIF = less(ModelParam.fieldModifiers());

	@AutoTwip
	public static MethodModifiers[] M_MODIF = less(ModelParam.methodModifiers());

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
		return new JavaParameter[] { New.parameter(type, name) };
	}

	@AutoTwip
	public static JavaParameter[][] parameterGroups(JavaParameter param1,
			JavaParameter param2) {
		return Param.groups(JavaParameter.class, param1, param2);
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
		return Param.groups(JavaMethod.class, method1, method2);
	}

	/* **************************** TESTS ****************************** */

	@Test
	public void testConvenienceMethods() {
		InterfaceModifiers modifiers = Interfaces.PUBLIC;
		String name = "TestInterface";
		List<JavaType> interfaces = Power.list();
		List<JavaField> fields = Power.list();
		List<JavaMethod> methods = Power.list();
		List<JavaTypeParameter> parameters = Power.list();

		JavaInterface[] instances = allInstances(modifiers, name, interfaces,
				fields, methods, parameters);

		checkAllEquall(instances);
	}

	@Test
	public void testCombinations(InterfaceModifiers modifiers,
			@Values("IDS") String name, JavaType[] superInterfaces,
			JavaField[] fields, JavaMethod[] methods,
			JavaTypeParameter[] parameters) {

		JavaInterface[] instances1 = allInstances(modifiers, name,
				Power.list(superInterfaces), Power.list(fields),
				Power.list(methods), Power.list(parameters));

		JavaInterface[] instances2 = allInstances(modifiers, name,
				Power.list(superInterfaces), Power.list(fields),
				Power.list(methods), Power.list(parameters));

		Assert.assertArrayEquals(instances1, instances2);

		for (JavaInterface interfacee : instances1) {
			checkElementName(interfacee, name);
		}
	}

	private JavaInterface[] allInstances(InterfaceModifiers modifiers,
			String name, List<JavaType> interfaces, List<JavaField> fields,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {

		JavaInterface obj0 = New.interfacee(modifiers, name, interfaces,
				fields, methods, parameters);
		checkInterface(obj0, modifiers, name, interfaces, fields, methods,
				parameters);

		JavaInterface obj1 = New.interfacee(modifiers, name, interfaces,
				methods, parameters);
		checkInterface(obj1, modifiers, name, interfaces, New.NO_FIELDS,
				methods, parameters);

		JavaInterface obj2 = New.interfacee(modifiers, name, interfaces,
				methods);
		checkInterface(obj2, modifiers, name, interfaces, New.NO_FIELDS,
				methods, New.NO_TYPE_PARAMS);

		JavaInterface obj3 = New.interfacee(name, interfaces, methods);
		checkInterface(obj3, Interfaces.PUBLIC, name, interfaces,
				New.NO_FIELDS, methods, New.NO_TYPE_PARAMS);

		JavaInterface obj4 = New.interfacee(name, methods);
		checkInterface(obj4, Interfaces.PUBLIC, name, New.NO_TYPES,
				New.NO_FIELDS, methods, New.NO_TYPE_PARAMS);

		return new JavaInterface[] { obj0, obj1, obj2, obj3, obj4 };
	}

}
