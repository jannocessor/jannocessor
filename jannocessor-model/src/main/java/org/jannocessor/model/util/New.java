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

package org.jannocessor.model.util;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringEscapeUtils;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.bean.ReadonlyNameBean;
import org.jannocessor.model.bean.executable.JavaConstructorBean;
import org.jannocessor.model.bean.executable.JavaInstanceInitBean;
import org.jannocessor.model.bean.executable.JavaMethodBean;
import org.jannocessor.model.bean.executable.JavaStaticInitBean;
import org.jannocessor.model.bean.modifier.AnnotationModifiersBean;
import org.jannocessor.model.bean.modifier.ClassModifiersBean;
import org.jannocessor.model.bean.modifier.ConstructorModifiersBean;
import org.jannocessor.model.bean.modifier.EnumModifiersBean;
import org.jannocessor.model.bean.modifier.FieldModifiersBean;
import org.jannocessor.model.bean.modifier.InterfaceModifiersBean;
import org.jannocessor.model.bean.modifier.MethodModifiersBean;
import org.jannocessor.model.bean.modifier.NestedAnnotationModifiersBean;
import org.jannocessor.model.bean.modifier.NestedClassModifiersBean;
import org.jannocessor.model.bean.modifier.NestedEnumModifiersBean;
import org.jannocessor.model.bean.modifier.NestedInterfaceModifiersBean;
import org.jannocessor.model.bean.structure.JavaAnnotationBean;
import org.jannocessor.model.bean.structure.JavaClassBean;
import org.jannocessor.model.bean.structure.JavaEnumBean;
import org.jannocessor.model.bean.structure.JavaInterfaceBean;
import org.jannocessor.model.bean.structure.JavaMetadataBean;
import org.jannocessor.model.bean.structure.JavaNestedAnnotationBean;
import org.jannocessor.model.bean.structure.JavaNestedClassBean;
import org.jannocessor.model.bean.structure.JavaNestedEnumBean;
import org.jannocessor.model.bean.structure.JavaNestedInterfaceBean;
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
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.code.bean.JavaBodyBean;
import org.jannocessor.model.code.bean.JavaExpressionBean;
import org.jannocessor.model.code.bean.SourceCodeBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.AnnotationModifiers;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.NestedAnnotationModifiers;
import org.jannocessor.model.modifier.NestedClassModifiers;
import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.modifier.NestedInterfaceModifiers;
import org.jannocessor.model.modifier.value.AnnotationModifierValue;
import org.jannocessor.model.modifier.value.ClassModifierValue;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;
import org.jannocessor.model.modifier.value.EnumModifierValue;
import org.jannocessor.model.modifier.value.FieldModifierValue;
import org.jannocessor.model.modifier.value.InterfaceModifierValue;
import org.jannocessor.model.modifier.value.MethodModifierValue;
import org.jannocessor.model.modifier.value.NestedAnnotationModifierValue;
import org.jannocessor.model.modifier.value.NestedClassModifierValue;
import org.jannocessor.model.modifier.value.NestedEnumModifierValue;
import org.jannocessor.model.modifier.value.NestedInterfaceModifierValue;
import org.jannocessor.model.structure.JavaAnnotation;
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
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.variable.JavaParameter;

public class New {

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
	public static final List<JavaMethod> NO_METHODS = Power.unmodifiableList();
	public static final List<JavaConstructor> NO_CONSTRUCTORS = Power
			.unmodifiableList();
	public static final List<JavaField> NO_FIELDS = Power.unmodifiableList();
	public static final List<JavaExpression> NO_EXPRESSIONS = Power
			.unmodifiableList();

	public static Name name(String name) {
		return name != null ? new NameBean(name) : null;
	}

	public static Name readonlyName(String name) {
		return name != null ? new ReadonlyNameBean(name) : null;
	}

	public static JavaTypeKind typeKind(Class<?> type) {
		if (type == null) {
			return JavaTypeKind.NULL;
		} else if (type.equals(void.class)) {
			return JavaTypeKind.VOID;
		} else if (type.isPrimitive()) {
			return JavaTypeKind.valueOf(type.getSimpleName().toUpperCase());
		} else if (type.isArray()) {
			return JavaTypeKind.ARRAY;
		} else {
			return JavaTypeKind.DECLARED;
		}
	}

	public static JavaField field(FieldModifiers modifiers, JavaType type,
			String name, JavaExpression value) {
		return new JavaFieldBean(modifiers, type, name(name), value);
	}

	public static JavaField field(FieldModifiers modifiers, Class<?> type,
			String name, JavaExpression value) {
		return field(modifiers, type(type), name, value);
	}

	public static JavaField field(FieldModifiers modifiers, Class<?> type,
			String name) {
		return field(modifiers, type, name, expression());
	}

	public static JavaField field(FieldModifiers modifiers, JavaType type,
			String name) {
		return field(modifiers, type, name, expression());
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

	public static JavaInstanceInit instanceInit(JavaBody body) {
		return new JavaInstanceInitBean(body);
	}

	public static JavaStaticInit staticInit(JavaBody body) {
		return new JavaStaticInitBean(body);
	}

	public static JavaEnumConstant enumConstant(String name,
			List<JavaExpression> values) {
		return new JavaEnumConstantBean(name, values);
	}

	public static JavaEnumConstant enumConstant(String name,
			JavaExpression... values) {
		return enumConstant(name, Power.list(values));
	}

	public static JavaEnumConstant enumConstant(String name) {
		return enumConstant(name, NO_EXPRESSIONS);
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

	public static ClassModifiers classModifiers(ClassModifierValue... values) {
		return new ClassModifiersBean(values);
	}

	public static InterfaceModifiers interfaceModifiers(
			InterfaceModifierValue... values) {
		return new InterfaceModifiersBean(values);
	}

	public static EnumModifiers enumModifiers(EnumModifierValue... values) {
		return new EnumModifiersBean(values);
	}

	public static AnnotationModifiers annotationModifiers(
			AnnotationModifierValue... values) {
		return new AnnotationModifiersBean(values);
	}

	public static FieldModifiers fieldModifiers(FieldModifierValue... values) {
		return new FieldModifiersBean(values);
	}

	public static NestedClassModifiers nestedClassModifiers(
			NestedClassModifierValue... values) {
		return new NestedClassModifiersBean(values);
	}

	public static NestedAnnotationModifiers nestedAnnotationModifiers(
			NestedAnnotationModifierValue... values) {
		return new NestedAnnotationModifiersBean(values);
	}

	public static NestedInterfaceModifiers nestedInterfaceModifiers(
			NestedInterfaceModifierValue... values) {
		return new NestedInterfaceModifiersBean(values);
	}

	public static NestedEnumModifiers nestedEnumModifiers(
			NestedEnumModifierValue... values) {
		return new NestedEnumModifiersBean(values);
	}

	public static MethodModifiers methodModifiers(MethodModifierValue... values) {
		return new MethodModifiersBean(values);
	}

	public static ConstructorModifiers constructorModifiers(
			ConstructorModifierValue... values) {
		return new ConstructorModifiersBean(values);
	}

	public static JavaPackage packagee(String name) {
		return new JavaPackageBean(name);
	}

	/******************************** TYPES **********************************/

	public static JavaType type(Class<?> type, Class<?>... typeParams) {
		return new JavaTypeBean(type, typeParams);
	}

	public static JavaType type(String canonicalName, JavaTypeKind kind) {
		return new JavaTypeBean(canonicalName, kind);
	}

	public static JavaType type(String packageName, String simpleName,
			JavaTypeKind kind) {
		return new JavaTypeBean(packageName, simpleName, kind);
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

	public static JavaArrayType arrayType(JavaType type) {
		return new JavaArrayTypeBean(type);
	}

	public static JavaArrayType arrayType(Class<?> type, Class<?>... typeParams) {
		return arrayType(type(type, typeParams));
	}

	public static JavaExecutableType executableType(JavaType returnType,
			List<JavaType> parameterTypes, List<JavaType> thrownTypes,
			List<JavaType> typeVariables) {
		return new JavaExecutableTypeBean(returnType, parameterTypes,
				thrownTypes, typeVariables);
	}

	public static JavaExecutableType executableType(JavaType returnType,
			List<JavaType> parameterTypes, List<JavaType> thrownTypes) {
		List<JavaType> noTypeVariables = Power.list();
		return executableType(returnType, parameterTypes, thrownTypes,
				noTypeVariables);
	}

	public static JavaExecutableType executableType(JavaType returnType,
			PowerList<JavaType> parameterTypes) {
		PowerList<JavaType> noThrownTypes = Power.list();
		return executableType(returnType, parameterTypes, noThrownTypes);
	}

	public static JavaExecutableType executableType(Class<?> returnType,
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
				constructors, methods, NO_TYPE_PARAMS);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors) {
		return classs(modifiers, name, superclass, interfaces, fields,
				constructors, NO_METHODS);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields) {
		return classs(modifiers, name, superclass, interfaces, fields,
				NO_CONSTRUCTORS);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass, List<JavaType> interfaces) {
		return classs(modifiers, name, superclass, interfaces, NO_FIELDS);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			JavaType superclass) {
		return classs(modifiers, name, superclass, NO_TYPES);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name) {
		return classs(modifiers, name, null);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			List<JavaField> fields, List<JavaMethod> methods) {
		return classs(modifiers, name, null, NO_TYPES, fields, NO_CONSTRUCTORS,
				methods);
	}

	public static JavaClass classs(ClassModifiers modifiers, String name,
			List<JavaField> fields, List<JavaMethod> methods,
			List<JavaConstructor> constructors) {
		return classs(modifiers, name, null, NO_TYPES, fields, constructors,
				methods);
	}

	/**************************** INTERFACE *******************************/

	public static JavaInterface interfacee(InterfaceModifiers modifiers,
			String name, List<JavaType> superInterfaces,
			List<JavaField> fields, List<JavaMethod> methods,
			List<JavaTypeParameter> parameters) {
		return new JavaInterfaceBean(modifiers, name, superInterfaces, fields,
				methods, parameters);
	}

	public static JavaInterface interfacee(InterfaceModifiers modifiers,
			String name, List<JavaType> superInterfaces,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		return interfacee(modifiers, name, superInterfaces, NO_FIELDS, methods,
				parameters);
	}

	public static JavaInterface interfacee(InterfaceModifiers modifiers,
			String name, List<JavaType> superInterfaces,
			List<JavaMethod> methods) {
		return interfacee(modifiers, name, superInterfaces, methods,
				NO_TYPE_PARAMS);
	}

	public static JavaInterface interfacee(String name,
			List<JavaType> superInterfaces, List<JavaMethod> methods) {
		return interfacee(Interfaces.PUBLIC, name, superInterfaces, methods);
	}

	public static JavaInterface interfacee(String name, List<JavaMethod> methods) {
		return interfacee(name, NO_TYPES, methods);
	}

	/****************************** ENUM *********************************/

	public static JavaEnum enumm(EnumModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaEnumConstant> values,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {
		return new JavaEnumBean(modifiers, name, interfaces, values, fields,
				constructors, methods);
	}

	public static JavaEnum enumm(EnumModifiers modifiers, String name,
			List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors, List<JavaMethod> methods) {
		return enumm(modifiers, name, NO_TYPES, values, fields, constructors,
				methods);
	}

	public static JavaEnum enumm(EnumModifiers modifiers, String name,
			List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors) {
		return enumm(modifiers, name, values, fields, constructors, NO_METHODS);
	}

	public static JavaEnum enumm(EnumModifiers modifiers, String name,
			List<JavaEnumConstant> values) {
		return enumm(modifiers, name, values, NO_FIELDS, NO_CONSTRUCTORS);
	}

	public static JavaEnum enumm(String name, List<JavaEnumConstant> values) {
		return enumm(Enums.PUBLIC, name, values);
	}

	/*************************** ANNOTATION ******************************/

	public static JavaAnnotation annotation(AnnotationModifiers modifiers,
			String name, List<JavaMethod> methods) {
		return new JavaAnnotationBean(modifiers, name, methods);
	}

	public static JavaAnnotation annotation(String name,
			List<JavaMethod> methods) {
		return annotation(Annotations.PUBLIC, name, methods);
	}

	public static JavaAnnotation annotation(AnnotationModifiers modifiers,
			String name) {
		return annotation(modifiers, name, NO_METHODS);
	}

	public static JavaAnnotation annotation(String name) {
		return annotation(name, NO_METHODS);
	}

	/************************* NESTED CLASS *****************************/

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		return new JavaNestedClassBean(modifiers, name, superclass, interfaces,
				fields, constructors, methods, parameters);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {
		return nestedClass(modifiers, name, superclass, interfaces, fields,
				constructors, methods, NO_TYPE_PARAMS);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors) {
		return nestedClass(modifiers, name, superclass, interfaces, fields,
				constructors, NO_METHODS);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields) {
		return nestedClass(modifiers, name, superclass, interfaces, fields,
				NO_CONSTRUCTORS);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces) {
		return nestedClass(modifiers, name, superclass, interfaces, NO_FIELDS);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, JavaType superclass) {
		return nestedClass(modifiers, name, superclass, NO_TYPES);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name) {
		return nestedClass(modifiers, name, null);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, List<JavaField> fields, List<JavaMethod> methods) {
		return nestedClass(modifiers, name, null, NO_TYPES, fields,
				NO_CONSTRUCTORS, methods);
	}

	public static JavaNestedClass nestedClass(NestedClassModifiers modifiers,
			String name, List<JavaField> fields, List<JavaMethod> methods,
			List<JavaConstructor> constructors) {
		return nestedClass(modifiers, name, null, NO_TYPES, fields,
				constructors, methods);
	}

	/************************ NESTED INTERFACE **************************/

	public static JavaNestedInterface nestedInterface(
			NestedInterfaceModifiers modifiers, String name,
			List<JavaType> superInterfaces, List<JavaMethod> methods,
			List<JavaTypeParameter> parameters) {
		return new JavaNestedInterfaceBean(modifiers, name, superInterfaces,
				methods, parameters);
	}

	public static JavaNestedInterface nestedInterface(
			NestedInterfaceModifiers modifiers, String name,
			List<JavaType> superInterfaces, List<JavaMethod> methods) {
		return nestedInterface(modifiers, name, superInterfaces, methods,
				NO_TYPE_PARAMS);
	}

	public static JavaNestedInterface nestedInterface(String name,
			List<JavaType> superInterfaces, List<JavaMethod> methods) {
		return nestedInterface(NestedInterfaces.PUBLIC, name, superInterfaces,
				methods);
	}

	public static JavaNestedInterface nestedInterface(String name,
			List<JavaMethod> methods) {
		return nestedInterface(name, NO_TYPES, methods);
	}

	/*************************** NESTED ENUM ******************************/

	public static JavaNestedEnum nestedEnum(NestedEnumModifiers modifiers,
			String name, List<JavaType> interfaces,
			List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors, List<JavaMethod> methods) {
		return new JavaNestedEnumBean(modifiers, name, interfaces, values,
				fields, constructors, methods);
	}

	public static JavaNestedEnum nestedEnum(NestedEnumModifiers modifiers,
			String name, List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors, List<JavaMethod> methods) {
		return nestedEnum(modifiers, name, NO_TYPES, values, fields,
				constructors, methods);
	}

	public static JavaNestedEnum nestedEnum(NestedEnumModifiers modifiers,
			String name, List<JavaEnumConstant> values, List<JavaField> fields,
			List<JavaConstructor> constructors) {
		return nestedEnum(modifiers, name, values, fields, constructors,
				NO_METHODS);
	}

	public static JavaNestedEnum nestedEnum(NestedEnumModifiers modifiers,
			String name, List<JavaEnumConstant> values) {
		return nestedEnum(modifiers, name, values, NO_FIELDS, NO_CONSTRUCTORS);
	}

	public static JavaNestedEnum nestedEnum(String name,
			List<JavaEnumConstant> values) {
		return nestedEnum(NestedEnums.PUBLIC, name, values);
	}

	/************************ NESTED ANNOTATION **************************/

	public static JavaNestedAnnotation nestedAnnotation(
			NestedAnnotationModifiers modifiers, String name,
			List<JavaMethod> methods) {
		return new JavaNestedAnnotationBean(modifiers, name, methods);
	}

	public static JavaNestedAnnotation nestedAnnotation(String name,
			List<JavaMethod> methods) {
		return nestedAnnotation(NestedAnnotations.PUBLIC, name, methods);
	}

	public static JavaNestedAnnotation nestedAnnotation(
			NestedAnnotationModifiers modifiers, String name) {
		return nestedAnnotation(modifiers, name, NO_METHODS);
	}

	public static JavaNestedAnnotation nestedAnnotation(String name) {
		return nestedAnnotation(name, NO_METHODS);
	}

	/******************************* METADATA *********************************/

	public static JavaMetadata metadata(JavaType type,
			Map<String, ? extends Object> attributes) {
		return new JavaMetadataBean(type, attributes);
	}

	public static JavaMetadata metadata(Class<?> type,
			Map<String, ? extends Object> attributes) {
		return metadata(type(type), attributes);
	}

	public static <T> JavaMetadata metadata(JavaType type, T... values) {
		if (values.length == 0) {
			return metadata(type, Power.map(String.class, Object.class));
		} else if (values.length == 1) {
			return metadata(type, Power.map("value", values[0]));
		} else {
			return metadata(type, Power.map("value", Power.list(values)));
		}
	}

	public static <T> JavaMetadata metadata(Class<?> type, T... values) {
		return metadata(type(type), values);
	}

	/*************************** TYPE PARAMETERS *****************************/

	public static JavaTypeParameter typeParameter(String name,
			List<JavaType> bounds) {
		return new JavaTypeParameterBean(name, bounds);
	}

	public static JavaTypeParameter typeParameter(String name) {
		return typeParameter(name, NO_TYPES);
	}

	/*************************** SOURCE CODE *****************************/

	public static SourceCode code() {
		return new SourceCodeBean(null, null, null);
	}

	public static SourceCode code(String code) {
		return new SourceCodeBean(code, null, null);
	}

	public static SourceCode codeByTemplate(String template) {
		return new SourceCodeBean(null, template, null);
	}

	public static SourceCode codeByTemplateName(String templateName) {
		return new SourceCodeBean(null, null, templateName);
	}

	public static SourceCode code(Class<? extends JavaCodeModel> model) {
		return codeByTemplateName(Templates.defaultName(model));
	}

	/***************************** BODY *******************************/

	public static JavaBody body() {
		return new JavaBodyBean(null, null, null);
	}

	public static JavaBody body(String code) {
		return new JavaBodyBean(code, null, null);
	}

	public static JavaBody bodyByTemplate(String template) {
		return new JavaBodyBean(null, template, null);
	}

	public static JavaBody bodyByTemplateName(String templateName) {
		return new JavaBodyBean(null, null, templateName);
	}

	/**************************** EXPRESSION ******************************/

	public static JavaExpression expression() {
		return new JavaExpressionBean(null, null, null);
	}

	public static JavaExpression expression(String expression) {
		return new JavaExpressionBean(expression, null, null);
	}

	public static JavaExpression expressionByTemplate(String template) {
		return new JavaExpressionBean(null, template, null);
	}

	public static JavaExpression expressionByTemplateName(String templateName) {
		return new JavaExpressionBean(null, null, templateName);
	}

	/**************************** LITERAL ******************************/

	public static JavaExpression literal(String string) {
		return expression('"' + StringEscapeUtils.escapeJava(string) + '"');
	}

	public static JavaExpression literal(long number) {
		return expression(String.valueOf(number));
	}

	public static JavaExpression literal(boolean bool) {
		return expression(String.valueOf(bool));
	}

	public static JavaExpression literal(Class<?> clazz) {
		return expression(clazz.getSimpleName() + ".class");
	}

}
