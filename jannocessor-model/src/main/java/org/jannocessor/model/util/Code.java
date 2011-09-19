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

import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.bean.executable.JavaConstructorBean;
import org.jannocessor.model.bean.executable.JavaInstanceInitBean;
import org.jannocessor.model.bean.executable.JavaMethodBean;
import org.jannocessor.model.bean.executable.JavaStaticInitBean;
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
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.ClassModifierValue;
import org.jannocessor.model.modifier.ClassModifiers;
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

    private static Name name(String name) {
        return new NameBean(name);
    }

    public static JavaField field(FieldModifiers modifiers, Class<?> type, String name) {
        return field(modifiers, type(type), name);
    }

    public static JavaField field(FieldModifiers modifiers, JavaType type, String name) {
        return new JavaFieldBean(modifiers, type, name(name));
    }

    public static JavaMethod method(MethodModifiers modifiers, Class<Void> clazz, String name, JavaParameter... params) {
        return method(modifiers, type(clazz), name, params);
    }

    public static JavaMethod method(MethodModifiers modifiers, JavaType type, String name, JavaParameter... params) {
        return new JavaMethodBean(modifiers, type, name, params);
    }

    public static JavaConstructor constructor(JavaParameter... params) {
        return constructor(methodModifiers(), params);
    }

    public static JavaConstructor constructor(MethodModifiers modifiers, JavaParameter... params) {
        return new JavaConstructorBean(modifiers, params);
    }

    public static JavaParameter parameter(Class<?> clazz, String name) {
        return parameter(clazz, name, false);
    }

    public static JavaParameter parameter(Class<?> clazz, String name, boolean isFinal) {
        return new JavaParameterBean(clazz, name, isFinal);
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

    public static JavaExceptionParameter exceptionParameter(String name) {
        return new JavaExceptionParameterBean(name);
    }

    public static JavaLocalVariable localVariable(Class<?> type, String name) {
        return localVariable(type, name, false);
    }

    public static JavaLocalVariable localVariable(Class<?> type, String name, boolean isFinal) {
        return new JavaLocalVariableBean(type, name, isFinal);
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

    public static JavaClass classs(ClassModifiers modifiers, String name) {
        return new JavaClassBean(modifiers, name);
    }

    public static JavaInterface interfacee(String name) {
        return new JavaInterfaceBean(name);
    }

    public static ClassModifiers classModifiers(final ClassModifierValue... values) {
        return new ClassModifiers() {
            @Override
            public ClassModifierValue[] getValues() {
                return values;
            }
        };
    }

    public static FieldModifiers fieldModifiers(final FieldModifierValue... values) {
        return new FieldModifiers() {
            @Override
            public FieldModifierValue[] getValues() {
                return values;
            }
        };
    }

    public static NestedClassModifiers nestedClassModifiers(final NestedClassModifierValue... values) {
        return new NestedClassModifiers() {
            @Override
            public NestedClassModifierValue[] getValues() {
                return values;
            }
        };
    }

    public static MethodModifiers methodModifiers(final MethodModifierValue... values) {
        return new MethodModifiers() {
            @Override
            public MethodModifierValue[] getValues() {
                return values;
            }
        };
    }

    public static JavaPackage packagee() {
        return new JavaPackageBean();
    }

    public static JavaTypeParameter typeParameter() {
        return new JavaTypeParameterBean();
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

    public static JavaType executableType(JavaType returnType, PowerList<JavaType> parameterTypes,
            PowerList<JavaType> thrownTypes, PowerList<JavaType> typeVariables) {
        return new JavaExecutableTypeBean(returnType, parameterTypes, thrownTypes, typeVariables);
    }

    public static JavaType executableType(JavaType returnType, PowerList<JavaType> parameterTypes,
            PowerList<JavaType> thrownTypes) {
        PowerList<JavaType> noTypeVariables = Power.list();
        return executableType(returnType, parameterTypes, thrownTypes, noTypeVariables);
    }

    public static JavaType executableType(JavaType returnType, PowerList<JavaType> parameterTypes) {
        PowerList<JavaType> noThrownTypes = Power.list();
        return executableType(returnType, parameterTypes, noThrownTypes);
    }

    public static JavaType executableType(Class<?> returnType, Class<?>... parameterTypes) {
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

}
