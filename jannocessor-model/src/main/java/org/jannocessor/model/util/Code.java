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

import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.JavaAnnotationBean;
import org.jannocessor.model.bean.JavaClassBean;
import org.jannocessor.model.bean.JavaConstructorBean;
import org.jannocessor.model.bean.JavaElementTypeBean;
import org.jannocessor.model.bean.JavaEnumBean;
import org.jannocessor.model.bean.JavaEnumConstantBean;
import org.jannocessor.model.bean.JavaExceptionParameterBean;
import org.jannocessor.model.bean.JavaFieldBean;
import org.jannocessor.model.bean.JavaInstanceInitBean;
import org.jannocessor.model.bean.JavaInterfaceBean;
import org.jannocessor.model.bean.JavaLocalVariableBean;
import org.jannocessor.model.bean.JavaMethodBean;
import org.jannocessor.model.bean.JavaPackageBean;
import org.jannocessor.model.bean.JavaParameterBean;
import org.jannocessor.model.bean.JavaStaticInitBean;
import org.jannocessor.model.bean.JavaTypeParameterBean;
import org.jannocessor.model.bean.NameBean;
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
import org.jannocessor.model.type.JavaAnnotation;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.model.type.JavaPackage;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.variable.JavaParameter;

public class Code {

    private static Name name(String name) {
        return new NameBean(name);
    }

    public static JavaElementType type(Class<?> type, Class<?>... typeParams) {
        return new JavaElementTypeBean(type, typeParams);
    }

    public static JavaField field(FieldModifiers modifiers, Class<?> type, String name) {
        return field(modifiers, type(type), name);
    }

    public static JavaField field(FieldModifiers modifiers, JavaElementType type, String name) {
        return new JavaFieldBean(modifiers, type, name(name));
    }

    public static JavaMethod method(MethodModifiers modifiers, Class<Void> clazz, String name, JavaParameter... params) {
        return method(modifiers, type(clazz), name, params);
    }

    public static JavaMethod method(MethodModifiers modifiers, JavaElementType type, String name,
            JavaParameter... params) {
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

}
