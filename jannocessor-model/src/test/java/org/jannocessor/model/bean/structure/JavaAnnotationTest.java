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
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Code;
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
	public static JavaType[] TYPES = less(Param.types());

	@AutoTwip
	public static Class<?>[] CLASSES = less(Param.classes());

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = less(Param.typeParams());

	@AutoTwip
	public static AnnotationModifiers[] AN_MODIF = Param.annotationModifiers();

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

		JavaAnnotation obj1 = Code.annotation(modifiers, name, methods);
		checkAnnotation(obj1, modifiers, name, methods);

		JavaAnnotation obj2 = Code.annotation(modifiers, name);
		checkAnnotation(obj2, modifiers, name, Code.NO_METHODS);

		JavaAnnotation obj3 = Code.annotation(name, methods);
		checkAnnotation(obj3, Annotations.PUBLIC, name, methods);

		return new JavaAnnotation[] { obj1, obj2, obj3 };
	}

}
