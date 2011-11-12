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

package org.jannocessor.model.bean.executable;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.collection.Power;
import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
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
	public static JavaType[] TYPES = ModelParam.types();

	@AutoTwip
	public static JavaTypeParameter[] TYPE_PARAM = ModelParam.typeParams();

	@AutoTwip
	public static ConstructorModifiers[] MODIF = ModelParam.constructorModifiers();

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
	public void testInstantiation1() {
		JavaConstructor constructor = New.constructor();

		checkConstructor(constructor, Constructors.PUBLIC, New.NO_PARAMS,
				New.NO_TYPES, New.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation2(JavaParameter[] params) {
		JavaConstructor constructor = New.constructor(params);

		checkConstructor(constructor, Constructors.PUBLIC, Power.list(params),
				New.NO_TYPES, New.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation3(ConstructorModifiers modifiers,
			JavaParameter[] params) {
		JavaConstructor constructor = New.constructor(modifiers, params);

		checkConstructor(constructor, modifiers, Power.list(params),
				New.NO_TYPES, New.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation4(ConstructorModifiers modifiers,
			JavaParameter[] params) {
		JavaConstructor constructor = New.constructor(modifiers,
				Power.list(params));

		checkConstructor(constructor, modifiers, Power.list(params),
				New.NO_TYPES, New.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation5(ConstructorModifiers modifiers,
			JavaParameter[] params, JavaType[] thrownTypes) {
		JavaConstructor constructor = New.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes));

		checkConstructor(constructor, modifiers, Power.list(params),
				Power.list(thrownTypes), New.NO_TYPE_PARAMS, false);
	}

	@Test
	public void testInstantiation6(ConstructorModifiers modifiers,
			JavaParameter[] params, JavaType[] thrownTypes,
			JavaTypeParameter[] typeParams) {
		JavaConstructor constructor = New.constructor(modifiers,
				Power.list(params), Power.list(thrownTypes),
				Power.list(typeParams));

		checkConstructor(constructor, modifiers, Power.list(params),
				Power.list(thrownTypes), Power.list(typeParams), false);
	}

}
