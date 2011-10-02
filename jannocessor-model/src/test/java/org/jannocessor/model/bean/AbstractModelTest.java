package org.jannocessor.model.bean;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.variable.JavaParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractModelTest {

	private static Logger log = LoggerFactory.getLogger("TEST");

	private static final int LESS = 1;

	private static final int FEW = 2;

	private static <T> void info(String operation, T[] values, int target) {
		log.debug("%(%): % -> %", new Object[] { operation,
				values.getClass().getComponentType(), values.length, target });
	}

	protected static <T> T[] less(T[] values) {
		info("Less", values, LESS);
		return Arrays.copyOf(values, LESS);
	}

	protected static <T> T[] few(T[] values) {
		info("Few", values, FEW);
		return Arrays.copyOf(values, FEW);
	}

	protected void checkCodeModel(JavaCodeModel codeModel) {
		assertNotNull(codeModel);
		assertNotNull(codeModel.getCode());
	}

	protected void checkElementName(JavaElement element, String name) {
		if (name != null) {
			assertNotNull(element.getName());
			assertEquals(name, element.getName().getText());
		} else {
			assertNull(element.getName());
		}
	}

	protected void checkElement(JavaElement element, String name, JavaType type) {
		checkCodeModel(element);

		checkElementName(element, name);
		assertEquals(type, element.getType());
	}

	protected void checkElement(JavaElement element, String name, Class<?> type) {
		checkCodeModel(element);

		checkElementName(element, name);
		assertEquals(type.getCanonicalName(), element.getType()
				.getCanonicalName().getText());
	}

	protected void checkElement(JavaElement element, JavaElement parent,
			PowerList<JavaElement> children, String name, JavaType type) {
		checkElement(element, name, type);

		assertEquals(parent, element.getParent());
		assertEquals(children, element.getChildren());
	}

	protected void checkElement(JavaElement element, JavaElement parent,
			PowerList<JavaElement> children, String name, Class<?> type) {
		checkElement(element, name, type);

		assertEquals(parent, element.getParent());
		assertEquals(children, element.getChildren());
	}

	protected void checkLonelyElement(JavaElement element, String name,
			JavaType type) {
		checkElement(element, null, null, name, type);
	}

	protected void checkLonelyElement(JavaElement element, String name,
			Class<?> type) {
		checkElement(element, null, null, name, type);
	}

	protected void checkLonelyElement(JavaElement element) {
		checkElement(element, null, null, null, (JavaType) null);
	}

	protected void checkExecutable(AbstractJavaExecutable executable) {
		checkCodeModel(executable);

		assertNotNull(executable.getBody());
		assertEquals(null, executable.getChildren());
	}

	protected void checkConstructor(JavaConstructor constructor,
			ConstructorModifiers modifiers, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters,
			Boolean isVarArgs) {
		checkExecutable(constructor);

		assertEquals(modifiers, constructor.getModifiers());
		assertEquals(params, constructor.getParameters());
		assertEquals(thrownTypes, constructor.getThrownTypes());
		assertEquals(typeParameters, constructor.getTypeParameters());
		assertEquals(isVarArgs, constructor.isVarArgs());
	}

	protected void checkMethod(JavaMethod method, MethodModifiers modifiers,
			JavaType returnType, String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		checkExecutable(method);

		assertEquals(modifiers, method.getModifiers());
		assertEquals(returnType, method.getReturnType());
		checkElementName(method, name);
		assertEquals(params, method.getParameters());
		assertEquals(thrownTypes, method.getThrownTypes());
		assertEquals(typeParameters, method.getTypeParameters());
	}

	private void checkStructural(AbstractJavaStructure type,
			JavaType superclass, List<JavaType> interfaces) {
		checkCodeModel(type);

		assertEquals(superclass, type.getSuperclass());
		assertEquals(interfaces, type.getInterfaces());
	}

	protected void checkClass(JavaClass clazz, ClassModifiers modifiers,
			String name, JavaType superclass, List<JavaType> interfaces,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		checkStructural(clazz, superclass, interfaces);
		checkElementName(clazz, name);

		assertEquals(modifiers, clazz.getModifiers());
		assertEquals(fields, clazz.getFields());
		assertEquals(constructors, clazz.getConstructors());
		assertEquals(methods, clazz.getMethods());
		assertEquals(parameters, clazz.getParameters());
	}

	protected void checkInterface(JavaInterface interfacee,
			InterfaceModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaMethod> methods,
			List<JavaTypeParameter> parameters) {
		checkStructural(interfacee, null, interfaces);
		checkElementName(interfacee, name);

		assertEquals(modifiers, interfacee.getModifiers());
		assertEquals(methods, interfacee.getMethods());
		assertEquals(parameters, interfacee.getParameters());
	}

	protected void checkAllEquall(JavaCodeModel... models) {
		for (JavaCodeModel model1 : models) {
			for (JavaCodeModel model2 : models) {
				assertEquals(model1, model2);
			}
		}
	}

}
