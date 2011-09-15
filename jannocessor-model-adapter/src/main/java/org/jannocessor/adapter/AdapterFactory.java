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

package org.jannocessor.adapter;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.executable.JavaConstructorAdapter;
import org.jannocessor.adapter.executable.JavaInstanceInitAdapter;
import org.jannocessor.adapter.executable.JavaMethodAdapter;
import org.jannocessor.adapter.executable.JavaStaticInitAdapter;
import org.jannocessor.adapter.type.JavaAnnotationAdapter;
import org.jannocessor.adapter.type.JavaClassAdapter;
import org.jannocessor.adapter.type.JavaEnumAdapter;
import org.jannocessor.adapter.type.JavaInterfaceAdapter;
import org.jannocessor.adapter.type.JavaPackageAdapter;
import org.jannocessor.adapter.type.JavaTypeParameterAdapter;
import org.jannocessor.adapter.variable.JavaEnumConstantAdapter;
import org.jannocessor.adapter.variable.JavaExceptionParameterAdapter;
import org.jannocessor.adapter.variable.JavaFieldAdapter;
import org.jannocessor.adapter.variable.JavaLocalVariableAdapter;
import org.jannocessor.adapter.variable.JavaParameterAdapter;
import org.jannocessor.data.JavaAnnotationData;
import org.jannocessor.data.JavaClassData;
import org.jannocessor.data.JavaConstructorData;
import org.jannocessor.data.JavaElementTypeData;
import org.jannocessor.data.JavaEnumConstantData;
import org.jannocessor.data.JavaEnumData;
import org.jannocessor.data.JavaExceptionParameterData;
import org.jannocessor.data.JavaFieldData;
import org.jannocessor.data.JavaInstanceInitData;
import org.jannocessor.data.JavaInterfaceData;
import org.jannocessor.data.JavaLocalVariableData;
import org.jannocessor.data.JavaMethodData;
import org.jannocessor.data.JavaPackageData;
import org.jannocessor.data.JavaParameterData;
import org.jannocessor.data.JavaStaticInitData;
import org.jannocessor.data.JavaTypeParameterData;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.NameBean;
import org.jannocessor.proxy.JavaAnnotationProxy;
import org.jannocessor.proxy.JavaClassProxy;
import org.jannocessor.proxy.JavaConstructorProxy;
import org.jannocessor.proxy.JavaElementTypeProxy;
import org.jannocessor.proxy.JavaEnumConstantProxy;
import org.jannocessor.proxy.JavaEnumProxy;
import org.jannocessor.proxy.JavaExceptionParameterProxy;
import org.jannocessor.proxy.JavaFieldProxy;
import org.jannocessor.proxy.JavaInstanceInitProxy;
import org.jannocessor.proxy.JavaInterfaceProxy;
import org.jannocessor.proxy.JavaLocalVariableProxy;
import org.jannocessor.proxy.JavaMethodProxy;
import org.jannocessor.proxy.JavaPackageProxy;
import org.jannocessor.proxy.JavaParameterProxy;
import org.jannocessor.proxy.JavaStaticInitProxy;
import org.jannocessor.proxy.JavaTypeParameterProxy;

public class AdapterFactory {

	@SuppressWarnings("unchecked")
	public static <T extends JavaElement> T getElementModel(Element element,
			Class<T> clazz, Elements elementUtils, Types typeUtils) {

		if (element != null) {

			JavaElement model;

			ElementKind kind = element.getKind();
			switch (kind) {

			/* Package and types */

			case PACKAGE:
				model = new JavaPackageProxy(new JavaPackageAdapter(
						(PackageElement) element, elementUtils, typeUtils),
						new JavaPackageData());
				break;

			case ENUM:
				model = new JavaEnumProxy(new JavaEnumAdapter(
						(TypeElement) element, elementUtils, typeUtils),
						new JavaEnumData());
				break;

			case CLASS:
				model = new JavaClassProxy(new JavaClassAdapter(
						(TypeElement) element, elementUtils, typeUtils),
						new JavaClassData());
				break;

			case ANNOTATION_TYPE:
				model = new JavaAnnotationProxy(new JavaAnnotationAdapter(
						(TypeElement) element, elementUtils, typeUtils),
						new JavaAnnotationData());
				break;

			case INTERFACE:
				model = new JavaInterfaceProxy(new JavaInterfaceAdapter(
						(TypeElement) element, elementUtils, typeUtils),
						new JavaInterfaceData());
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
				throw new IllegalStateException();
			}

			if (clazz.isAssignableFrom(model.getClass())) {
				return (T) model;
			} else {
				throw new IllegalStateException("Wrong element type!");
			}
		} else {
			return null;
		}
	}

	public static JavaElementType getTypeModel(TypeMirror typeMirror,
			Elements elementUtils, Types typeUtils) {
		if (typeMirror != null) {
			return new JavaElementTypeProxy(new ElementTypeAdapter(typeMirror,
					elementUtils, typeUtils), new JavaElementTypeData());
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
