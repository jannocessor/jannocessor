package org.jannocessor.model.util;

import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.JavaFieldBean;
import org.jannocessor.model.Name;
import org.jannocessor.model.NameBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.type.JavaAnnotation;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.variable.JavaParameter;

public class Code {

    public static JavaField field(FieldModifiers modifiers, Class<?> type,
	    String name) {
	return field(modifiers, type(type), name);
    }

    public static JavaField field(FieldModifiers modifiers,
	    JavaElementType type, String name) {
	JavaField field = new JavaFieldBean(modifiers, type, name(name));
	return field;
    }

    public static JavaMethod method(Class<?> clazz, String name,
	    JavaParameter... params) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaConstructor constructor(JavaParameter... params) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaMethod getter(JavaField field) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaMethod setter(JavaField field) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaParameter parameter(Class<?> class1, String name) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaParameter parameter(Class<?> class1, String name,
	    boolean isFinal) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaMethod method(MethodModifiers modifiers,
	    Class<Void> class1, String string, JavaParameter param1,
	    JavaParameter param2) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaConstructor constructor(MethodModifiers modifiers,
	    JavaParameter param1, JavaParameter param2) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaInstanceInit instanceInit() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaStaticInit staticInit() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaEnumConstant enumConstant(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaExceptionParameter exceptionParameter(String name) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaLocalVariable localVariable(Class<?> class1, String name) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaLocalVariable localVariable(Class<?> class1, String name,
	    boolean isFinal) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaAnnotation annotation() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaEnum enumeration() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaEnum enumeration(boolean isFinal) {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaClass classs() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaInterface interfacee() {
	// TODO Auto-generated method stub
	return null;
    }

    public static FieldModifiers fieldModifiers() {
	// TODO Auto-generated method stub
	return null;
    }

    public static JavaElementType type(Class<?> type, Class<?>... typeParams) {
	return null;
    }

    private static Name name(String name) {
	return new NameBean(name);
    }

}
