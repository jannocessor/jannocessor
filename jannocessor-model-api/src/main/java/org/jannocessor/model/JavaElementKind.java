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
