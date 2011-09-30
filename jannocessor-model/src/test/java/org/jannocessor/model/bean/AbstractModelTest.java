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
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaParameter;

public class AbstractModelTest {

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

	public static <T> T[] less(T[] values) {
		return Arrays.copyOf(values, 1);
	}

}
