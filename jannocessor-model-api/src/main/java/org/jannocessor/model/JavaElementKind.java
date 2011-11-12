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

package org.jannocessor.model;

public enum JavaElementKind {

	/** A package. */
	PACKAGE,

	/* Declared types */

	/** An enum type. */
	ENUM,

	/** A class not described by a more specific kind (like {@code ENUM}). */
	CLASS,

	/** An annotation type. */
	ANNOTATION,

	/**
	 * An interface not described by a more specific kind (like
	 * {@code ANNOTATION}).
	 */
	INTERFACE,

	// Nested declared types

	/** An enum type. */
	NESTED_ENUM,

	/** A class not described by a more specific kind (like {@code ENUM}). */
	NESTED_CLASS,

	/** An annotation type. */
	NESTED_ANNOTATION,

	/**
	 * An interface not described by a more specific kind (like
	 * {@code ANNOTATION_TYPE}).
	 */
	NESTED_INTERFACE,

	/* Variables */

	/** An enum constant. */
	ENUM_CONSTANT,

	/**
	 * A field not described by a more specific kind (like {@code ENUM_CONSTANT}
	 * ).
	 */
	FIELD,

	/** A parameter of a method or constructor. */
	PARAMETER,

	/** A local variable. */
	LOCAL_VARIABLE,

	/** A parameter of an exception handler. */
	EXCEPTION_PARAMETER,

	/* Executables */

	/** A method. */
	METHOD,

	/** A constructor. */
	CONSTRUCTOR,

	/** A static initializer. */
	STATIC_INIT,

	/** An instance initializer. */
	INSTANCE_INIT,

	/* Other */

	/** A type parameter. */
	TYPE_PARAMETER,

}
