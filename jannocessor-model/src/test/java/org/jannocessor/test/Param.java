package org.jannocessor.test;

import java.lang.reflect.Array;
import java.util.List;

import net.sf.twip.AutoTwip;

import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.util.Enums;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Interfaces;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.variable.JavaEnumConstant;

public class Param {

	@AutoTwip
	public static FieldModifiers[] fieldModifiers() {
		return new FieldModifiers[] { Fields.PRIVATE, Fields.PRIVATE_FINAL,
				Fields.FINAL_TRANSIENT };
	}

	@AutoTwip
	public static JavaType[] types() {
		return new JavaType[] { Code.type(List.class, String.class) };
	}

	@AutoTwip
	public static JavaTypeParameter[] typeParams() {
		return new JavaTypeParameter[] { Code.typeParameter("E"),
				Code.typeParameter("TYPE1") };
	}

	@AutoTwip
	public static String[] identifiers() {
		return new String[] { "x", "FOO", "FooBar", "foo_bar" };
	}

	@AutoTwip
	public static Class<?>[] classes() {
		return new Class<?>[] { String.class, int.class, void.class };
	}

	public static ClassModifiers[] classModifiers() {
		return new ClassModifiers[] { Classes.DEFAULT_MODIFIER,
				Classes.ABSTRACT, Classes.PUBLIC_FINAL };
	}

	public static InterfaceModifiers[] interfaceModifiers() {
		return new InterfaceModifiers[] { Interfaces.DEFAULT_MODIFIER,
				Interfaces.PUBLIC, Interfaces.PUBLIC_ABSTRACT };
	}

	public static EnumModifiers[] enumModifiers() {
		return new EnumModifiers[] { Enums.DEFAULT_MODIFIER, Enums.PUBLIC };
	}

	public static MethodModifiers[] methodModifiers() {
		return new MethodModifiers[] { Methods.PRIVATE, Methods.PRIVATE_FINAL,
				Methods.PUBLIC_STATIC_FINAL };
	}

	public static ConstructorModifiers[] constructorModifiers() {
		return new ConstructorModifiers[] { Constructors.PRIVATE,
				Constructors.PROTECTED, Constructors.PUBLIC };
	}

	@SuppressWarnings("unchecked")
	public static <T> T[][] groups(Class<T> clazz, T param1, T param2) {
		T[] group1 = (T[]) Array.newInstance(clazz, 0);

		T[] group2 = (T[]) Array.newInstance(clazz, 1);
		group2[0] = param1;

		T[] group3 = (T[]) Array.newInstance(clazz, 2);
		group3[0] = param1;
		group3[1] = param2;

		T[][] result = (T[][]) Array.newInstance(group1.getClass(), 3);
		result[0] = group1;
		result[1] = group2;
		result[2] = group3;
		return result;
	}

	public static JavaEnumConstant[] enumConstants() {
		return new JavaEnumConstant[] { Code.enumConstant("A"),
				Code.enumConstant("BB") };
	}

}