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

package org.jannocessor.model.test;

import java.util.List;

import net.sf.twip.AutoTwip;

import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Annotations;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Constructors;
import org.jannocessor.model.util.Enums;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.Interfaces;
import org.jannocessor.model.util.Methods;
import org.jannocessor.model.variable.JavaEnumConstant;

public class ModelParam {

	@AutoTwip
	public static FieldModifiers[] fieldModifiers() {
		return new FieldModifiers[] { Fields.PRIVATE, Fields.PRIVATE_FINAL,
				Fields.FINAL_TRANSIENT };
	}

	@AutoTwip
	public static JavaType[] types() {
		return new JavaType[] { New.type(List.class, String.class) };
	}

	@AutoTwip
	public static JavaTypeParameter[] typeParams() {
		return new JavaTypeParameter[] { New.typeParameter("E"),
				New.typeParameter("TYPE1") };
	}

	public static ClassModifiers[] classModifiers() {
		return new ClassModifiers[] { Classes.DEFAULT_MODIFIER,
				Classes.ABSTRACT, Classes.PUBLIC_FINAL };
	}

	public static InterfaceModifiers[] interfaceModifiers() {
		return new InterfaceModifiers[] { Interfaces.DEFAULT_MODIFIER,
				Interfaces.PUBLIC, Interfaces.PUBLIC_ABSTRACT };
	}

	public static AnnotationModifiers[] annotationModifiers() {
		return new AnnotationModifiers[] { Annotations.DEFAULT_MODIFIER,
				Annotations.PUBLIC, Annotations.PUBLIC_ABSTRACT };
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

	public static JavaEnumConstant[] enumConstants() {
		return new JavaEnumConstant[] { New.enumConstant("A"),
				New.enumConstant("BB") };
	}

}