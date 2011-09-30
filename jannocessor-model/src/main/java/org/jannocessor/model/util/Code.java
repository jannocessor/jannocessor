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

package org.jannocessor.model.util;

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.bean.executable.JavaConstructorBean;
import org.jannocessor.model.bean.executable.JavaInstanceInitBean;
import org.jannocessor.model.bean.executable.JavaMethodBean;
import org.jannocessor.model.bean.executable.JavaStaticInitBean;
import org.jannocessor.model.bean.modifier.ClassModifiersBean;
import org.jannocessor.model.bean.modifier.ConstructorModifiersBean;
import org.jannocessor.model.bean.modifier.FieldModifiersBean;
import org.jannocessor.model.bean.modifier.MethodModifiersBean;
import org.jannocessor.model.bean.modifier.NestedClassModifiersBean;
import org.jannocessor.model.bean.structure.JavaAnnotationBean;
import org.jannocessor.model.bean.structure.JavaClassBean;
import org.jannocessor.model.bean.structure.JavaEnumBean;
import org.jannocessor.model.bean.structure.JavaInterfaceBean;
import org.jannocessor.model.bean.structure.JavaPackageBean;
import org.jannocessor.model.bean.structure.JavaTypeParameterBean;
import org.jannocessor.model.bean.type.JavaArrayTypeBean;
import org.jannocessor.model.bean.type.JavaExecutableTypeBean;
import org.jannocessor.model.bean.type.JavaTypeBean;
import org.jannocessor.model.bean.type.JavaTypeVariableBean;
import org.jannocessor.model.bean.type.JavaWildcardTypeBean;
import org.jannocessor.model.bean.variable.JavaEnumConstantBean;
import org.jannocessor.model.bean.variable.JavaExceptionParameterBean;
import org.jannocessor.model.bean.variable.JavaFieldBean;
import org.jannocessor.model.bean.variable.JavaLocalVariableBean;
import org.jannocessor.model.bean.variable.JavaParameterBean;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.ClassModifierValue;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifierValue;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.FieldModifierValue;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.MethodModifierValue;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.NestedClassModifierValue;
import org.jannocessor.model.modifier.NestedClassModifiers;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.variable.JavaParameter;

public class Code {

	public static final PowerList<JavaParameter> NO_PARAMS = Power
			.unmodifiableList();
	public static final PowerList<JavaType> NO_TYPES = Power.unmodifiableList();
	public static final PowerList<JavaTypeParameter> NO_TYPE_PARAMS = Power
			.unmodifiableList();
	public static final PowerList<JavaStaticInit> NO_STATIC_INITS = Power
			.unmodifiableList();
	public static final PowerList<JavaInstanceInit> NO_INSTANCE_INITS = Power
			.unmodifiableList();
	public static final PowerList<JavaNestedClass> NO_NESTED_CLASSES = Power
			.unmodifiableList();
	public static final PowerList<JavaNestedEnum> NO_NESTED_ENUMS = Power
			.unmodifiableList();
	public static final PowerList<JavaNestedInterface> NO_NESTED_INTERFACES = Power
			.unmodifiableList();
	public static final PowerList<JavaNestedAnnotation> NO_NESTED_ANNOTATIONS = Power
			.unmodifiableList();

	private static Name name(String name) {
		return new NameBean(name);
	}

	public static JavaField field(FieldModifiers modifiers, Class<?> type,
			String name) {
		return field(modifiers, type(type), name);
	}

	public static JavaField field(FieldModifiers modifiers, JavaType type,
			String name) {
		return new JavaFieldBean(modifiers, type, name(name));
	}

	public static JavaParameter parameter(Class<?> clazz, String name,
			boolean isFinal) {
		return parameter(type(clazz), name, isFinal);
	}

	public static JavaParameter parameter(JavaType type, String name,
			boolean isFinal) {
		return new JavaParameterBean(type, name, isFinal);
	}

	public static JavaParameter parameter(Class<?> clazz, String name) {
		return parameter(clazz, name, false);
	}

	public static JavaParameter parameter(JavaType type, String name) {
		return parameter(type, name, false);
	}

	public static JavaInstanceInit instanceInit() {
		return new JavaInstanceInitBean();
	}

	public static JavaStaticInit staticInit() {
		return new JavaStaticInitBean();
	}

	public static JavaEnumConstant enumConstant(String name) {
		return new JavaEnumConstantBean(name);
	}

	public static JavaExceptionParameter exceptionParameter(JavaType type,
			String name) {
		return new JavaExceptionParameterBean(type, name);
	}

	public static JavaExceptionParameter exceptionParameter(Class<?> type,
			String name) {
		return exceptionParameter(type(type), name);
	}

	public static JavaLocalVariable localVariable(JavaType type, String name,
			boolean isFinal) {
		return new JavaLocalVariableBean(type, name, isFinal);
	}

	public static JavaLocalVariable localVariable(Class<?> clazz, String name,
			boolean isFinal) {
		return localVariable(type(clazz), name, isFinal);
	}

	public static JavaLocalVariable localVariable(JavaType type, String name) {
		return localVariable(type, name, false);
	}

	public static JavaLocalVariable localVariable(Class<?> type, String name) {
		return localVariable(type, name, false);
	}

	public static JavaAnnotation annotation() {
		return new JavaAnnotationBean();
	}

	public static JavaEnum enumeration(String name) {
		return enumeration(name, false);
	}

	public static JavaEnum enumeration(String name, boolean isFinal) {
		return new JavaEnumBean(name, isFinal);
	}

	public static JavaInterface interfacee(String name) {
		return new JavaInterfaceBean(name);
	}

	public static ClassModifiers classModifiers(
			final ClassModifierValue... values) {
		return new ClassModifiersBean(values);
	}

	public static FieldModifiers fieldModifiers(
			final FieldModifierValue... values) {
		return new FieldModifiersBean(values);
	}

	public static NestedClassModifiers nestedClassModifiers(
			final NestedClassModifierValue... values) {
		return new NestedClassModifiersBean(values);
	}

	public static MethodModifiers methodModifiers(
			final MethodModifierValue... values) {
		return new MethodModifiersBean(values);
	}

	public static ConstructorModifiers constructorModifiers(
			final ConstructorModifierValue... values) {
		return new ConstructorModifiersBean(values);
	}

	public static JavaPackage packagee() {
		return new JavaPackageBean();
	}

	public static JavaTypeParameter typeParameter(String name) {
		return new JavaTypeParameterBean(name);
	}

	public static JavaType type(Class<?> type, Class<?>... typeParams) {
		return new JavaTypeBean(type, typeParams);
	}

	public static PowerList<JavaType> types(Class<?>... classes) {
		PowerList<JavaType> result = Power.list();

		for (Class<?> clazz : classes) {
			result.add(type(clazz));
		}

		return result;
	}

	public static PowerList<JavaType> types(JavaType... types) {
		return Power.list(types);
	}

	public static JavaType arrayType(JavaType type) {
		return new JavaArrayTypeBean(type);
	}

	public static JavaType arrayType(Class<?> type, Class<?>... typeParams) {
		return arrayType(type(type, typeParams));
	}

	public static JavaType executableType(JavaType returnType,
			List<JavaType> parameterTypes, List<JavaType> thrownTypes,
			List<JavaType> typeVariables) {
		return new JavaExecutableTypeBean(returnType, parameterTypes,
				thrownTypes, typeVariables);
	}

	public static JavaType executableType(JavaType returnType,
			List<JavaType> parameterTypes, List<JavaType> thrownTypes) {
		List<JavaType> noTypeVariables = Power.list();
		return executableType(returnType, parameterTypes, thrownTypes,
				noTypeVariables);
	}

	public static JavaType executableType(JavaType returnType,
			PowerList<JavaType> parameterTypes) {
		PowerList<JavaType> noThrownTypes = Power.list();
		return executableType(returnType, parameterTypes, noThrownTypes);
	}

	public static JavaType executableType(Class<?> returnType,
			Class<?>... parameterTypes) {
		return executableType(type(returnType), types(parameterTypes));
	}

	public static JavaWildcardType wildcardType() {
		return new JavaWildcardTypeBean(null, null);
	}

	public static JavaWildcardType wildcardSuper(Class<?> clazz) {
		return new JavaWildcardTypeBean(clazz, null);
	}

	public static JavaWildcardType wildcardExtends(Class<?> clazz) {
		return new JavaWildcardTypeBean(null, clazz);
	}

	public static JavaTypeVariable typeVar() {
		return new JavaTypeVariableBean(null, null);
	}

	public static JavaTypeVariable typeVarLowerBound(Class<?> clazz) {
		return new JavaTypeVariableBean(clazz, null);
	}

	public static JavaTypeVariable typeVarUpperBound(Class<?> clazz) {
		return new JavaTypeVariableBean(null, clazz);
	}

	public static SourceCode code(String code) {
		return new SourceCodeBean(code, null, null);
	}

	/*************************** CONSTRUCTOR *******************************/

	public static JavaConstructor constructor(ConstructorModifiers modifiers,
			List<JavaParameter> params, List<JavaType> thrownTypes,
			List<JavaTypeParameter> typeParameters) {
		return new JavaConstructorBean(modifiers, params, thrownTypes,
				typeParameters);
	}

	public static JavaConstructor constructor(ConstructorModifiers modifiers,
			List<JavaParameter> params, List<JavaType> thrownTypes) {
		List<JavaTypeParameter> noTypeParameters = Power.list();
		return constructor(modifiers, params, thrownTypes, noTypeParameters);
	}

	public static JavaConstructor constructor(ConstructorModifiers modifiers,
			List<JavaParameter> params) {
		List<JavaType> noThrownTypes = Power.list();
		return constructor(modifiers, params, noThrownTypes);
	}

	public static JavaConstructor constructor(ConstructorModifiers modifiers,
			JavaParameter... params) {
		List<JavaType> noThrownTypes = Power.list();
		return constructor(modifiers, Power.list(params), noThrownTypes);
	}

	public static JavaConstructor constructor(JavaParameter... params) {
		return constructor(Constructors.PUBLIC, Power.list(params));
	}

	public static JavaConstructor constructor() {
		return constructor(new JavaParameter[0]);
	}

	/****************************** METHOD *********************************/

	public static JavaMethod method(MethodModifiers modifiers,
			JavaType returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		return new JavaMethodBean(modifiers, returnType, name, params,
				thrownTypes, typeParameters);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			Class<?> returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		return method(modifiers, type(returnType), name, params, thrownTypes,
				typeParameters);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			JavaType returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes) {
		List<JavaTypeParameter> noTypeParameters = Power.list();
		return method(modifiers, returnType, name, params, thrownTypes,
				noTypeParameters);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			Class<?> returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes) {
		return method(modifiers, type(returnType), name, params, thrownTypes);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			JavaType returnType, String name, List<JavaParameter> params) {
		List<JavaType> noThrownTypes = Power.list();
		return method(modifiers, returnType, name, params, noThrownTypes);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			Class<?> returnType, String name, List<JavaParameter> params) {
		return method(modifiers, type(returnType), name, params);
	}

	public static JavaMethod method(MethodModifiers modifiers,
			JavaType returnType, String name, JavaParameter... params) {
		return method(modifiers, returnType, name, Power.list(params));
	}

	public static JavaMethod method(MethodModifiers modifiers,
			Class<?> returnType, String name, JavaParameter... params) {
		return method(modifiers, type(returnType), name, Power.list(params));
	}

	/****************************** CLASS *********************************/

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		return new JavaClassBean(modifiers, name, superclass, interfaces,
				fields, constructors, methods, parameters);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {
		return classs(modifiers, name, superclass, interfaces, fields,
				constructors, methods, Code.NO_TYPE_PARAMS);
	}

}
