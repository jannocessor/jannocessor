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
