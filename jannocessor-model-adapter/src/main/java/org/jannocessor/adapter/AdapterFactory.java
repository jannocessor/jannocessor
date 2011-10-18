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

package org.jannocessor.adapter;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.ErrorType;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.NoType;
import javax.lang.model.type.NullType;
import javax.lang.model.type.PrimitiveType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.executable.JavaConstructorAdapter;
import org.jannocessor.adapter.executable.JavaInstanceInitAdapter;
import org.jannocessor.adapter.executable.JavaMethodAdapter;
import org.jannocessor.adapter.executable.JavaStaticInitAdapter;
import org.jannocessor.adapter.structure.JavaAnnotationAdapter;
import org.jannocessor.adapter.structure.JavaClassAdapter;
import org.jannocessor.adapter.structure.JavaEnumAdapter;
import org.jannocessor.adapter.structure.JavaInterfaceAdapter;
import org.jannocessor.adapter.structure.JavaMetadataAdapter;
import org.jannocessor.adapter.structure.JavaNestedAnnotationAdapter;
import org.jannocessor.adapter.structure.JavaNestedClassAdapter;
import org.jannocessor.adapter.structure.JavaNestedEnumAdapter;
import org.jannocessor.adapter.structure.JavaNestedInterfaceAdapter;
import org.jannocessor.adapter.structure.JavaPackageAdapter;
import org.jannocessor.adapter.structure.JavaTypeParameterAdapter;
import org.jannocessor.adapter.type.JavaArrayTypeAdapter;
import org.jannocessor.adapter.type.JavaDeclaredTypeAdapter;
import org.jannocessor.adapter.type.JavaErrorTypeAdapter;
import org.jannocessor.adapter.type.JavaExecutableTypeAdapter;
import org.jannocessor.adapter.type.JavaNullTypeAdapter;
import org.jannocessor.adapter.type.JavaPrimitiveTypeAdapter;
import org.jannocessor.adapter.type.JavaTypeVariableAdapter;
import org.jannocessor.adapter.type.JavaVoidTypeAdapter;
import org.jannocessor.adapter.type.JavaWildcardTypeAdapter;
import org.jannocessor.adapter.variable.JavaEnumConstantAdapter;
import org.jannocessor.adapter.variable.JavaExceptionParameterAdapter;
import org.jannocessor.adapter.variable.JavaFieldAdapter;
import org.jannocessor.adapter.variable.JavaLocalVariableAdapter;
import org.jannocessor.adapter.variable.JavaParameterAdapter;
import org.jannocessor.data.JavaAnnotationData;
import org.jannocessor.data.JavaArrayTypeData;
import org.jannocessor.data.JavaClassData;
import org.jannocessor.data.JavaConstructorData;
import org.jannocessor.data.JavaDeclaredTypeData;
import org.jannocessor.data.JavaEnumConstantData;
import org.jannocessor.data.JavaEnumData;
import org.jannocessor.data.JavaErrorTypeData;
import org.jannocessor.data.JavaExceptionParameterData;
import org.jannocessor.data.JavaExecutableTypeData;
import org.jannocessor.data.JavaFieldData;
import org.jannocessor.data.JavaInstanceInitData;
import org.jannocessor.data.JavaInterfaceData;
import org.jannocessor.data.JavaLocalVariableData;
import org.jannocessor.data.JavaMetadataData;
import org.jannocessor.data.JavaMethodData;
import org.jannocessor.data.JavaNestedAnnotationData;
import org.jannocessor.data.JavaNestedClassData;
import org.jannocessor.data.JavaNestedEnumData;
import org.jannocessor.data.JavaNestedInterfaceData;
import org.jannocessor.data.JavaNullTypeData;
import org.jannocessor.data.JavaPackageData;
import org.jannocessor.data.JavaParameterData;
import org.jannocessor.data.JavaPrimitiveTypeData;
import org.jannocessor.data.JavaStaticInitData;
import org.jannocessor.data.JavaTypeParameterData;
import org.jannocessor.data.JavaTypeVariableData;
import org.jannocessor.data.JavaVoidTypeData;
import org.jannocessor.data.JavaWildcardTypeData;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.proxy.JavaAnnotationProxy;
import org.jannocessor.proxy.JavaArrayTypeProxy;
import org.jannocessor.proxy.JavaClassProxy;
import org.jannocessor.proxy.JavaConstructorProxy;
import org.jannocessor.proxy.JavaDeclaredTypeProxy;
import org.jannocessor.proxy.JavaEnumConstantProxy;
import org.jannocessor.proxy.JavaEnumProxy;
import org.jannocessor.proxy.JavaErrorTypeProxy;
import org.jannocessor.proxy.JavaExceptionParameterProxy;
import org.jannocessor.proxy.JavaExecutableTypeProxy;
import org.jannocessor.proxy.JavaFieldProxy;
import org.jannocessor.proxy.JavaInstanceInitProxy;
import org.jannocessor.proxy.JavaInterfaceProxy;
import org.jannocessor.proxy.JavaLocalVariableProxy;
import org.jannocessor.proxy.JavaMetadataProxy;
import org.jannocessor.proxy.JavaMethodProxy;
import org.jannocessor.proxy.JavaNestedAnnotationProxy;
import org.jannocessor.proxy.JavaNestedClassProxy;
import org.jannocessor.proxy.JavaNestedEnumProxy;
import org.jannocessor.proxy.JavaNestedInterfaceProxy;
import org.jannocessor.proxy.JavaNullTypeProxy;
import org.jannocessor.proxy.JavaPackageProxy;
import org.jannocessor.proxy.JavaParameterProxy;
import org.jannocessor.proxy.JavaPrimitiveTypeProxy;
import org.jannocessor.proxy.JavaStaticInitProxy;
import org.jannocessor.proxy.JavaTypeParameterProxy;
import org.jannocessor.proxy.JavaTypeVariableProxy;
import org.jannocessor.proxy.JavaVoidTypeProxy;
import org.jannocessor.proxy.JavaWildcardTypeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterFactory {

	protected static final Logger logger = LoggerFactory
			.getLogger(AdapterFactory.class);

	@SuppressWarnings("unchecked")
	public static <T extends JavaElement> T getElementModel(Element element,
			Class<T> clazz, Elements elementUtils, Types typeUtils) {

		if (element != null) {

			JavaElement model;
			TypeElement typeElement;

			ElementKind kind = element.getKind();
			switch (kind) {

			/* Package and types */

			case PACKAGE:
				model = new JavaPackageProxy(new JavaPackageAdapter(
						(PackageElement) element, elementUtils, typeUtils),
						new JavaPackageData());
				break;

			case ENUM:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					model = new JavaNestedEnumProxy(new JavaNestedEnumAdapter(
							typeElement, elementUtils, typeUtils),
							new JavaNestedEnumData());
				} else {
					model = new JavaEnumProxy(new JavaEnumAdapter(typeElement,
							elementUtils, typeUtils), new JavaEnumData());
				}
				break;

			case CLASS:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					model = new JavaNestedClassProxy(
							new JavaNestedClassAdapter(typeElement,
									elementUtils, typeUtils),
							new JavaNestedClassData());
				} else {
					model = new JavaClassProxy(new JavaClassAdapter(
							typeElement, elementUtils, typeUtils),
							new JavaClassData());
				}
				break;

			case ANNOTATION_TYPE:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					model = new JavaNestedAnnotationProxy(
							new JavaNestedAnnotationAdapter(typeElement,
									elementUtils, typeUtils),
							new JavaNestedAnnotationData());
				} else {
					model = new JavaAnnotationProxy(new JavaAnnotationAdapter(
							typeElement, elementUtils, typeUtils),
							new JavaAnnotationData());
				}
				break;

			case INTERFACE:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					model = new JavaNestedInterfaceProxy(
							new JavaNestedInterfaceAdapter(typeElement,
									elementUtils, typeUtils),
							new JavaNestedInterfaceData());
				} else {
					model = new JavaInterfaceProxy(new JavaInterfaceAdapter(
							typeElement, elementUtils, typeUtils),
							new JavaInterfaceData());
				}
				break;

			case TYPE_PARAMETER:
				model = new JavaTypeParameterProxy(
						new JavaTypeParameterAdapter(
								(TypeParameterElement) element, elementUtils,
								typeUtils), new JavaTypeParameterData());
				break;

			/* Variables */

			case ENUM_CONSTANT:
				model = new JavaEnumConstantProxy(new JavaEnumConstantAdapter(
						(VariableElement) element, elementUtils, typeUtils),
						new JavaEnumConstantData());
				break;

			case FIELD:
				model = new JavaFieldProxy(new JavaFieldAdapter(
						(VariableElement) element, elementUtils, typeUtils),
						new JavaFieldData());
				break;

			case PARAMETER:
				model = new JavaParameterProxy(new JavaParameterAdapter(
						(VariableElement) element, elementUtils, typeUtils),
						new JavaParameterData());
				break;

			case LOCAL_VARIABLE:
				model = new JavaLocalVariableProxy(
						new JavaLocalVariableAdapter((VariableElement) element,
								elementUtils, typeUtils),
						new JavaLocalVariableData());
				break;

			case EXCEPTION_PARAMETER:
				model = new JavaExceptionParameterProxy(
						new JavaExceptionParameterAdapter(
								(VariableElement) element, elementUtils,
								typeUtils), new JavaExceptionParameterData());
				break;

			/* Executables */

			case METHOD:
				model = new JavaMethodProxy(new JavaMethodAdapter(
						(ExecutableElement) element, elementUtils, typeUtils),
						new JavaMethodData());
				break;

			case CONSTRUCTOR:
				model = new JavaConstructorProxy(new JavaConstructorAdapter(
						(ExecutableElement) element, elementUtils, typeUtils),
						new JavaConstructorData());
				break;

			case STATIC_INIT:
				model = new JavaStaticInitProxy(new JavaStaticInitAdapter(
						(ExecutableElement) element, elementUtils, typeUtils),
						new JavaStaticInitData());
				break;

			case INSTANCE_INIT:
				model = new JavaInstanceInitProxy(new JavaInstanceInitAdapter(
						(ExecutableElement) element, elementUtils, typeUtils),
						new JavaInstanceInitData());
				break;

			default:
				throw new IllegalStateException("Unexpected element kind!");
			}

			if (clazz.isAssignableFrom(model.getClass())) {
				return (T) model;
			} else {
				String msg = "Wrong element type: %s is not assignable to %s!";
				throw new IllegalStateException(String.format(msg,
						model.getClass(), clazz));
			}
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends JavaType> T getTypeModel(TypeMirror typeMirror,
			Class<T> clazz, Elements elementUtils, Types typeUtils) {
		if (typeMirror != null) {
			JavaType type;
			switch (typeMirror.getKind()) {

			case ARRAY:
				type = new JavaArrayTypeProxy(new JavaArrayTypeAdapter(
						(ArrayType) typeMirror, elementUtils, typeUtils),
						new JavaArrayTypeData());
				break;

			case DECLARED:
				type = new JavaDeclaredTypeProxy(new JavaDeclaredTypeAdapter(
						(DeclaredType) typeMirror, elementUtils, typeUtils),
						new JavaDeclaredTypeData());
				break;

			case EXECUTABLE:
				type = new JavaExecutableTypeProxy(
						new JavaExecutableTypeAdapter(
								(ExecutableType) typeMirror, elementUtils,
								typeUtils), new JavaExecutableTypeData());
				break;

			case TYPEVAR:
				type = new JavaTypeVariableProxy(new JavaTypeVariableAdapter(
						(TypeVariable) typeMirror, elementUtils, typeUtils),
						new JavaTypeVariableData());
				break;

			case WILDCARD:
				type = new JavaWildcardTypeProxy(new JavaWildcardTypeAdapter(
						(WildcardType) typeMirror, elementUtils, typeUtils),
						new JavaWildcardTypeData());
				break;

			case NONE:
			case PACKAGE:
			case VOID:
				type = new JavaVoidTypeProxy(new JavaVoidTypeAdapter(
						(NoType) typeMirror, elementUtils, typeUtils),
						new JavaVoidTypeData());
				break;

			case NULL:
				type = new JavaNullTypeProxy(new JavaNullTypeAdapter(
						(NullType) typeMirror, elementUtils, typeUtils),
						new JavaNullTypeData());
				break;

			case ERROR:
				type = new JavaErrorTypeProxy(new JavaErrorTypeAdapter(
						(ErrorType) typeMirror, elementUtils, typeUtils),
						new JavaErrorTypeData());
				break;

			default:
				type = new JavaPrimitiveTypeProxy(new JavaPrimitiveTypeAdapter(
						(PrimitiveType) typeMirror, elementUtils, typeUtils),
						new JavaPrimitiveTypeData());
				break;
			}

			if (clazz.isAssignableFrom(type.getClass())) {
				return (T) type;
			} else {
				String msg = "Wrong type: %s is not assignable to %s!";
				throw new IllegalStateException(String.format(msg,
						type.getClass(), clazz));
			}
		} else {
			return null;
		}
	}

	public static JavaMetadata getMetadataAdapter(
			AnnotationMirror annotationMirror, Elements elementUtils,
			Types typeUtils) {
		if (annotationMirror != null) {
			return new JavaMetadataProxy(new JavaMetadataAdapter(
					annotationMirror, elementUtils, typeUtils),
					new JavaMetadataData());
		} else {
			return null;
		}
	}

	public static Name getNameModel(String text) {
		if (text != null) {
			return new NameBean(text);
		} else {
			return null;
		}
	}

}
