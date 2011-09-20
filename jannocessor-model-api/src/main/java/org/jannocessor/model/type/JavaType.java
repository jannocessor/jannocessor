/**
 * Copyright 2011 jannocessor.org
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

import org.jannocessor.annotation.DomainModel;
import org.jannocessor.model.Name;
import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;

@DomainModel
public interface JavaType extends JavaCodeModel {

	Class<?> getTypeClass();

	Name getSimpleName();

	Name getCanonicalName();

	boolean hasError();

	boolean isVoid();

	boolean isNull();

	/* Primitive types: boolean, byte, char, double, float, int, long, short */

	boolean isPrimitive();

	/* Declared types: class, interface, enumeration */

	boolean isDeclared();

	JavaDeclaredType asDeclared();

	/* Class */

	boolean isClass();

	JavaClass asClass();

	/* Interface */

	boolean isInterface();

	JavaInterface asInterface();

	/* Enumeration */

	boolean isEnum();

	JavaEnum asEnum();

	/* Array */

	boolean isArray();

	JavaArrayType asArray();

	/* Wildcard */

	boolean isWildcard();

	JavaWildcardType asWildcard();

	/* Type variable */

	boolean isTypeVariable();

	JavaTypeVariable asTypeVariable();

	/* Executable */

	boolean isExecutable();

	JavaExecutableType asExecutable();

}
