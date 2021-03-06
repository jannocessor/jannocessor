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

package org.jannocessor.model.util;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.value.MethodModifierValue;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;

public class Methods {

	/** Represents the default method modifier. */
	public static final MethodModifiers DEFAULT_MODIFIER = New.methodModifiers();

	/** Represents "public" method modifiers. */
	public static final MethodModifiers PUBLIC = New.methodModifiers(MethodModifierValue.PUBLIC);

	/** Represents "public static" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC);

	/** Represents "public static final" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

	/** Represents "public static final synchronized" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "public static final synchronized native" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED_NATIVE = New
			.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.NATIVE);

	/** Represents "public static final synchronized strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL_SYNCHRONIZED_STRICTFP = New
			.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.STRICTFP);

	/** Represents "public static final native" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.NATIVE);

	/** Represents "public static final strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.STRICTFP);

	/** Represents "public static synchronized" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "public static synchronized native" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "public static synchronized strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "public static native" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

	/** Represents "public static strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_STATIC_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

	/** Represents "public final" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.FINAL);

	/** Represents "public final synchronized" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED = New
			.methodModifiers(MethodModifierValue.PUBLIC, MethodModifierValue.FINAL,
					MethodModifierValue.SYNCHRONIZED);

	/** Represents "public final synchronized native" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "public final synchronized strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "public final native" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

	/** Represents "public final strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

	/** Represents "public abstract" method modifiers. */
	public static final MethodModifiers PUBLIC_ABSTRACT = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.ABSTRACT);

	/** Represents "public synchronized" method modifiers. */
	public static final MethodModifiers PUBLIC_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED);

	/** Represents "public synchronized native" method modifiers. */
	public static final MethodModifiers PUBLIC_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.NATIVE);

	/** Represents "public synchronized strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.STRICTFP);

	/** Represents "public native" method modifiers. */
	public static final MethodModifiers PUBLIC_NATIVE = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.NATIVE);

	/** Represents "public strictfp" method modifiers. */
	public static final MethodModifiers PUBLIC_STRICTFP = New.methodModifiers(
			MethodModifierValue.PUBLIC, MethodModifierValue.STRICTFP);

	/** Represents "protected" method modifiers. */
	public static final MethodModifiers PROTECTED = New
			.methodModifiers(MethodModifierValue.PROTECTED);

	/** Represents "protected static" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC);

	/** Represents "protected static final" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_FINAL = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

	/** Represents "protected static final synchronized" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED);

	/**
	 * Represents "protected static final synchronized native" method modifiers.
	 */
	public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED_NATIVE = New
			.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.NATIVE);

	/**
	 * Represents "protected static final synchronized strictfp" method
	 * modifiers.
	 */
	public static final MethodModifiers PROTECTED_STATIC_FINAL_SYNCHRONIZED_STRICTFP = New
			.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.STRICTFP);

	/** Represents "protected static final native" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.NATIVE);

	/** Represents "protected static final strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.STRICTFP);

	/** Represents "protected static synchronized" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "protected static synchronized native" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "protected static synchronized strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_SYNCHRONIZED_STRICTFP = New
			.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
					MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "protected static native" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

	/** Represents "protected static strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_STATIC_STRICTFP = New
			.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.STATIC,
					MethodModifierValue.STRICTFP);

	/** Represents "protected final" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.FINAL);

	/** Represents "protected final synchronized" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "protected final synchronized native" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "protected final synchronized strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL_SYNCHRONIZED_STRICTFP = New
			.methodModifiers(MethodModifierValue.PROTECTED, MethodModifierValue.FINAL,
					MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "protected final native" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

	/** Represents "protected final strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

	/** Represents "protected abstract" method modifiers. */
	public static final MethodModifiers PROTECTED_ABSTRACT = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.ABSTRACT);

	/** Represents "protected synchronized" method modifiers. */
	public static final MethodModifiers PROTECTED_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED);

	/** Represents "protected synchronized native" method modifiers. */
	public static final MethodModifiers PROTECTED_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.NATIVE);

	/** Represents "protected synchronized strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.STRICTFP);

	/** Represents "protected native" method modifiers. */
	public static final MethodModifiers PROTECTED_NATIVE = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.NATIVE);

	/** Represents "protected strictfp" method modifiers. */
	public static final MethodModifiers PROTECTED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PROTECTED, MethodModifierValue.STRICTFP);

	/** Represents "private" method modifiers. */
	public static final MethodModifiers PRIVATE = New.methodModifiers(MethodModifierValue.PRIVATE);

	/** Represents "private static" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC);

	/** Represents "private static final" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_FINAL = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL);

	/** Represents "private static final synchronized" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "private static final synchronized native" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED_NATIVE = New
			.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.NATIVE);

	/**
	 * Represents "private static final synchronized strictfp" method modifiers.
	 */
	public static final MethodModifiers PRIVATE_STATIC_FINAL_SYNCHRONIZED_STRICTFP = New
			.methodModifiers(MethodModifierValue.PRIVATE, MethodModifierValue.STATIC,
					MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.STRICTFP);

	/** Represents "private static final native" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.NATIVE);

	/** Represents "private static final strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.STRICTFP);

	/** Represents "private static synchronized" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "private static synchronized native" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "private static synchronized strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "private static native" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

	/** Represents "private static strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_STATIC_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

	/** Represents "private final" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL);

	/** Represents "private final synchronized" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED);

	/** Represents "private final synchronized native" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "private final synchronized strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "private final native" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

	/** Represents "private final strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

	/** Represents "private synchronized" method modifiers. */
	public static final MethodModifiers PRIVATE_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED);

	/** Represents "private synchronized native" method modifiers. */
	public static final MethodModifiers PRIVATE_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.NATIVE);

	/** Represents "private synchronized strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.STRICTFP);

	/** Represents "private native" method modifiers. */
	public static final MethodModifiers PRIVATE_NATIVE = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.NATIVE);

	/** Represents "private strictfp" method modifiers. */
	public static final MethodModifiers PRIVATE_STRICTFP = New.methodModifiers(
			MethodModifierValue.PRIVATE, MethodModifierValue.STRICTFP);

	/** Represents "static" method modifiers. */
	public static final MethodModifiers STATIC = New.methodModifiers(MethodModifierValue.STATIC);

	/** Represents "static final" method modifiers. */
	public static final MethodModifiers STATIC_FINAL = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.FINAL);

	/** Represents "static final synchronized" method modifiers. */
	public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED = New
			.methodModifiers(MethodModifierValue.STATIC, MethodModifierValue.FINAL,
					MethodModifierValue.SYNCHRONIZED);

	/** Represents "static final synchronized native" method modifiers. */
	public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "static final synchronized strictfp" method modifiers. */
	public static final MethodModifiers STATIC_FINAL_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.FINAL,
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "static final native" method modifiers. */
	public static final MethodModifiers STATIC_FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

	/** Represents "static final strictfp" method modifiers. */
	public static final MethodModifiers STATIC_FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

	/** Represents "static synchronized" method modifiers. */
	public static final MethodModifiers STATIC_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED);

	/** Represents "static synchronized native" method modifiers. */
	public static final MethodModifiers STATIC_SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.NATIVE);

	/** Represents "static synchronized strictfp" method modifiers. */
	public static final MethodModifiers STATIC_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.STRICTFP);

	/** Represents "static native" method modifiers. */
	public static final MethodModifiers STATIC_NATIVE = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.NATIVE);

	/** Represents "static strictfp" method modifiers. */
	public static final MethodModifiers STATIC_STRICTFP = New.methodModifiers(
			MethodModifierValue.STATIC, MethodModifierValue.STRICTFP);

	/** Represents "final" method modifiers. */
	public static final MethodModifiers FINAL = New.methodModifiers(MethodModifierValue.FINAL);

	/** Represents "final synchronized" method modifiers. */
	public static final MethodModifiers FINAL_SYNCHRONIZED = New.methodModifiers(
			MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED);

	/** Represents "final synchronized native" method modifiers. */
	public static final MethodModifiers FINAL_SYNCHRONIZED_NATIVE = New
			.methodModifiers(MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
					MethodModifierValue.NATIVE);

	/** Represents "final synchronized strictfp" method modifiers. */
	public static final MethodModifiers FINAL_SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.FINAL, MethodModifierValue.SYNCHRONIZED,
			MethodModifierValue.STRICTFP);

	/** Represents "final native" method modifiers. */
	public static final MethodModifiers FINAL_NATIVE = New.methodModifiers(
			MethodModifierValue.FINAL, MethodModifierValue.NATIVE);

	/** Represents "final strictfp" method modifiers. */
	public static final MethodModifiers FINAL_STRICTFP = New.methodModifiers(
			MethodModifierValue.FINAL, MethodModifierValue.STRICTFP);

	/** Represents "abstract" method modifiers. */
	public static final MethodModifiers ABSTRACT = New
			.methodModifiers(MethodModifierValue.ABSTRACT);

	/** Represents "synchronized" method modifiers. */
	public static final MethodModifiers SYNCHRONIZED = New
			.methodModifiers(MethodModifierValue.SYNCHRONIZED);

	/** Represents "synchronized native" method modifiers. */
	public static final MethodModifiers SYNCHRONIZED_NATIVE = New.methodModifiers(
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.NATIVE);

	/** Represents "synchronized strictfp" method modifiers. */
	public static final MethodModifiers SYNCHRONIZED_STRICTFP = New.methodModifiers(
			MethodModifierValue.SYNCHRONIZED, MethodModifierValue.STRICTFP);

	/** Represents "native" method modifiers. */
	public static final MethodModifiers NATIVE = New.methodModifiers(MethodModifierValue.NATIVE);

	/** Represents "strictfp" method modifiers. */
	public static final MethodModifiers STRICTFP = New
			.methodModifiers(MethodModifierValue.STRICTFP);

	public static JavaMethod getter(JavaField field) {
		String getterName = field.getName().copy().insertPart(0, "get").toString();
		JavaMethod getter = New.method(Methods.PUBLIC, field.getType(), getterName);

		getter.getBody().setHardcoded("return this.%s;", field.getName().toString());

		return getter;
	}

	public static JavaMethod setter(JavaField field) {
		String setterName = field.getName().copy().insertPart(0, "set").toString();
		String fieldName = field.getName().toString();

		JavaParameter param = New.parameter(field.getType(), fieldName);
		JavaMethod setter = New.method(Methods.PUBLIC, New.type(void.class), setterName, param);

		setter.getBody().setHardcoded("this.%s = %s;", fieldName, fieldName);

		return setter;
	}

	public static JavaMethod delegator(JavaMethod method, JavaField delegate) {
		JavaMethod delegator = method.copy();

		delegator.getModifiers().assign(Methods.PUBLIC);
		PowerList<Name> args = method.getParameters().getTransformed(Get.NAME);
		delegator.getBody().setMacroName("delegator");
		delegator.getBody().setAttributes(Power.map("delegate", delegate, "args", args));

		return delegator;
	}

}
