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

package org.jannocessor.model.type;

import javax.lang.model.type.NoType;

public enum JavaTypeKind {

	/**
	 * The primitive type {@code boolean}.
	 */
	BOOLEAN,

	/**
	 * The primitive type {@code byte}.
	 */
	BYTE,

	/**
	 * The primitive type {@code short}.
	 */
	SHORT,

	/**
	 * The primitive type {@code int}.
	 */
	INT,

	/**
	 * The primitive type {@code long}.
	 */
	LONG,

	/**
	 * The primitive type {@code char}.
	 */
	CHAR,

	/**
	 * The primitive type {@code float}.
	 */
	FLOAT,

	/**
	 * The primitive type {@code double}.
	 */
	DOUBLE,

	/**
	 * The pseudo-type corresponding to the keyword {@code void}.
	 *
	 * @see NoType
	 */
	VOID,

	/**
	 * A pseudo-type used where no actual type is appropriate.
	 *
	 * @see NoType
	 */
	NONE,

	/**
	 * The null type.
	 */
	NULL,

	/**
	 * An array type.
	 */
	ARRAY,

	/**
	 * A class or interface type.
	 */
	DECLARED,

	/**
	 * A class or interface type that could not be resolved.
	 */
	ERROR,

	/**
	 * A type variable.
	 */
	TYPEVAR,

	/**
	 * A wildcard type argument.
	 */
	WILDCARD,

	/**
	 * A pseudo-type corresponding to a package element.
	 *
	 * @see NoType
	 */
	PACKAGE,

	/**
	 * A method, constructor, or initializer.
	 */
	EXECUTABLE;

	/**
	 * Returns {@code true} if this kind corresponds to a primitive type and
	 * {@code false} otherwise.
	 *
	 * @return {@code true} if this kind corresponds to a primitive type
	 */
	public boolean isPrimitive() {
		switch (this) {
		case BOOLEAN:
		case BYTE:
		case SHORT:
		case INT:
		case LONG:
		case CHAR:
		case FLOAT:
		case DOUBLE:
			return true;

		default:
			return false;
		}
	}

	public boolean isDeclared() {
		return this == DECLARED;
	}

	public boolean isArray() {
		return this == ARRAY;
	}

}
