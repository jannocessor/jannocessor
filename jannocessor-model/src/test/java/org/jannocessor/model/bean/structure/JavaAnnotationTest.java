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
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.test.Param;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaAnnotationTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = less(Param.identifiers());

	@AutoTwip
	public static JavaType[] TYPES = less(ModelParam.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(ModelParam.typeParams());

	@AutoTwip
	public static AnnotationModifiers[] AN_MODIF = ModelParam.annotationModifiers();

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
		AnnotationModifiers modifiers = Annotations.PUBLIC;
		String name = "TestAnnotation";
		List<JavaMethod> methods = Power.list();

		JavaAnnotation[] instances = allInstances(modifiers, name, methods);

		checkAllEquall(instances);
	}

	@Test
	public void testCombinations(AnnotationModifiers modifiers,
			@Values("IDS") String name, JavaMethod[] methods) {

		JavaAnnotation[] instances1 = allInstances(modifiers, name,
				Power.list(methods));

		JavaAnnotation[] instances2 = allInstances(modifiers, name,
				Power.list(methods));

		Assert.assertArrayEquals(instances1, instances2);

		for (JavaAnnotation interfacee : instances1) {
			checkElementName(interfacee, name);
		}
	}

	private JavaAnnotation[] allInstances(AnnotationModifiers modifiers,
			String name, List<JavaMethod> methods) {

		JavaAnnotation obj1 = New.annotation(modifiers, name, methods);
		checkAnnotation(obj1, modifiers, name, methods);

		JavaAnnotation obj2 = New.annotation(modifiers, name);
		checkAnnotation(obj2, modifiers, name, New.NO_METHODS);

		JavaAnnotation obj3 = New.annotation(name, methods);
		checkAnnotation(obj3, Annotations.PUBLIC, name, methods);

		return new JavaAnnotation[] { obj1, obj2, obj3 };
	}

}
