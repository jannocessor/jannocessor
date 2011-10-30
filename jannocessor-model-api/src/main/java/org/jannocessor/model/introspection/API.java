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

package org.jannocessor.model.introspection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaErrorType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaNullType;
import org.jannocessor.model.type.JavaPrimitiveType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaVoidType;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.variable.JavaParameter;

@SuppressWarnings("unchecked")
public class API {

	public static final List<Class<? extends JavaCodeModel>> EXECUTABLE;

	public static final List<Class<? extends JavaCodeModel>> STRUCTURE;

	public static final List<Class<? extends JavaCodeModel>> VARIABLE;

	public static final List<Class<? extends JavaCodeModel>> TYPE;

	public static final List<Class<? extends JavaCodeModel>> ALL;

	static {
		EXECUTABLE = list(JavaConstructor.class, JavaInstanceInit.class,
				JavaMethod.class, JavaStaticInit.class);

		STRUCTURE = list(JavaAnnotation.class, JavaAnnotationAttribute.class,
				JavaClass.class, JavaEnum.class, JavaInterface.class,
				JavaNestedAnnotation.class, JavaNestedClass.class,
				JavaNestedEnum.class, JavaNestedInterface.class,
				JavaPackage.class, JavaTypeParameter.class, JavaMetadata.class);

		VARIABLE = list(JavaEnumConstant.class, JavaExceptionParameter.class,
				JavaField.class, JavaLocalVariable.class, JavaParameter.class);

		TYPE = list(JavaArrayType.class, JavaDeclaredType.class,
				JavaErrorType.class, JavaExecutableType.class,
				JavaNullType.class, JavaPrimitiveType.class,
				JavaTypeVariable.class, JavaVoidType.class,
				JavaWildcardType.class);

		ArrayList<Class<? extends JavaCodeModel>> all = new ArrayList<Class<? extends JavaCodeModel>>();
		all.addAll(EXECUTABLE);
		all.addAll(STRUCTURE);
		all.addAll(VARIABLE);
		all.addAll(TYPE);

		ALL = Collections.unmodifiableList(all);
	}

	private static List<Class<? extends JavaCodeModel>> list(
			Class<? extends JavaCodeModel>... classes) {
		List<Class<? extends JavaCodeModel>> list = new ArrayList<Class<? extends JavaCodeModel>>();

		for (Class<? extends JavaCodeModel> clazz : classes) {
			list.add(clazz);
		}

		return Collections.unmodifiableList(list);
	}
}
