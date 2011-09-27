package org.jannocessor.model.introspection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
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

		STRUCTURE = list(JavaAnnotation.class, JavaClass.class, JavaEnum.class,
				JavaInterface.class, JavaPackage.class, JavaTypeParameter.class);

		VARIABLE = list(JavaEnumConstant.class, JavaExceptionParameter.class,
				JavaField.class, JavaLocalVariable.class, JavaParameter.class);

		TYPE = list(JavaArrayType.class, JavaDeclaredType.class,
				JavaExecutableType.class, JavaType.class,
				JavaTypeVariable.class, JavaWildcardType.class);

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
