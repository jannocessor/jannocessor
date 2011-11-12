/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.adapter;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
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
import org.jannocessor.adapter.type.AbstractJavaTypeAdapter;
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
import org.jannocessor.data.JavaElementData;
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
import org.jannocessor.data.JavaTypeData;
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
import org.jannocessor.proxy.JavaElementProxy;
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
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.proxy.JavaTypeVariableProxy;
import org.jannocessor.proxy.JavaVoidTypeProxy;
import org.jannocessor.proxy.JavaWildcardTypeProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AdapterFactory {

	protected static final Logger logger = LoggerFactory
			.getLogger(AdapterFactory.class);

	private static Map<Element, JavaElementAdapter> ELEMENT_ADAPTERS = new HashMap<Element, JavaElementAdapter>();
	private static Map<TypeMirror, JavaType> TYPE_ADAPTERS = new HashMap<TypeMirror, JavaType>();
	private static Map<AnnotationMirror, JavaMetadata> METADATA_ADAPTERS = new HashMap<AnnotationMirror, JavaMetadata>();

	@SuppressWarnings("unchecked")
	public static <T extends JavaElement> T getElementModel(Element element,
			Class<T> clazz, Elements elementUtils, Types typeUtils) {

		if (element != null) {

			Class<? extends JavaElementAdapter> adapterClass;
			Class<? extends JavaElementProxy> proxyClass;
			Class<? extends JavaElementData> dataClass;

			TypeElement typeElement;

			ElementKind kind = element.getKind();
			switch (kind) {

			/* Package and types */

			case PACKAGE:
				adapterClass = JavaPackageAdapter.class;
				proxyClass = JavaPackageProxy.class;
				dataClass = JavaPackageData.class;
				break;

			case ENUM:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					adapterClass = JavaNestedEnumAdapter.class;
					proxyClass = JavaNestedEnumProxy.class;
					dataClass = JavaNestedEnumData.class;
				} else {
					adapterClass = JavaEnumAdapter.class;
					proxyClass = JavaEnumProxy.class;
					dataClass = JavaEnumData.class;
				}
				break;

			case CLASS:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					adapterClass = JavaNestedClassAdapter.class;
					proxyClass = JavaNestedClassProxy.class;
					dataClass = JavaNestedClassData.class;
				} else {
					adapterClass = JavaClassAdapter.class;
					proxyClass = JavaClassProxy.class;
					dataClass = JavaClassData.class;
				}
				break;

			case ANNOTATION_TYPE:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					adapterClass = JavaNestedAnnotationAdapter.class;
					proxyClass = JavaNestedAnnotationProxy.class;
					dataClass = JavaNestedAnnotationData.class;
				} else {
					adapterClass = JavaAnnotationAdapter.class;
					proxyClass = JavaAnnotationProxy.class;
					dataClass = JavaAnnotationData.class;
				}
				break;

			case INTERFACE:
				typeElement = (TypeElement) element;
				if (typeElement.getNestingKind().isNested()) {
					adapterClass = JavaNestedInterfaceAdapter.class;
					proxyClass = JavaNestedInterfaceProxy.class;
					dataClass = JavaNestedInterfaceData.class;
				} else {
					adapterClass = JavaInterfaceAdapter.class;
					proxyClass = JavaInterfaceProxy.class;
					dataClass = JavaInterfaceData.class;
				}
				break;

			case TYPE_PARAMETER:
				adapterClass = JavaTypeParameterAdapter.class;
				proxyClass = JavaTypeParameterProxy.class;
				dataClass = JavaTypeParameterData.class;
				break;

			/* Variables */

			case ENUM_CONSTANT:
				adapterClass = JavaEnumConstantAdapter.class;
				proxyClass = JavaEnumConstantProxy.class;
				dataClass = JavaEnumConstantData.class;
				break;

			case FIELD:
				adapterClass = JavaFieldAdapter.class;
				proxyClass = JavaFieldProxy.class;
				dataClass = JavaFieldData.class;
				break;

			case PARAMETER:
				adapterClass = JavaParameterAdapter.class;
				proxyClass = JavaParameterProxy.class;
				dataClass = JavaParameterData.class;
				break;

			case LOCAL_VARIABLE:
				adapterClass = JavaLocalVariableAdapter.class;
				proxyClass = JavaLocalVariableProxy.class;
				dataClass = JavaLocalVariableData.class;
				break;

			case EXCEPTION_PARAMETER:
				adapterClass = JavaExceptionParameterAdapter.class;
				proxyClass = JavaExceptionParameterProxy.class;
				dataClass = JavaExceptionParameterData.class;
				break;

			/* Executables */

			case METHOD:
				adapterClass = JavaMethodAdapter.class;
				proxyClass = JavaMethodProxy.class;
				dataClass = JavaMethodData.class;
				break;

			case CONSTRUCTOR:
				adapterClass = JavaConstructorAdapter.class;
				proxyClass = JavaConstructorProxy.class;
				dataClass = JavaConstructorData.class;
				break;

			case STATIC_INIT:
				adapterClass = JavaStaticInitAdapter.class;
				proxyClass = JavaStaticInitProxy.class;
				dataClass = JavaStaticInitData.class;
				break;

			case INSTANCE_INIT:
				adapterClass = JavaInstanceInitAdapter.class;
				proxyClass = JavaInstanceInitProxy.class;
				dataClass = JavaInstanceInitData.class;
				break;

			default:
				throw new IllegalStateException("Unexpected element kind!");
			}

			JavaElement model = getElementAdapter(element, adapterClass,
					proxyClass, dataClass, elementUtils, typeUtils);

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

			Class<? extends AbstractJavaTypeAdapter> adapterClass;
			Class<? extends JavaTypeProxy> proxyClass;
			Class<? extends JavaTypeData> dataClass;

			switch (typeMirror.getKind()) {

			case ARRAY:
				adapterClass = JavaArrayTypeAdapter.class;
				proxyClass = JavaArrayTypeProxy.class;
				dataClass = JavaArrayTypeData.class;
				break;

			case DECLARED:
				adapterClass = JavaDeclaredTypeAdapter.class;
				proxyClass = JavaDeclaredTypeProxy.class;
				dataClass = JavaDeclaredTypeData.class;
				break;

			case EXECUTABLE:
				adapterClass = JavaExecutableTypeAdapter.class;
				proxyClass = JavaExecutableTypeProxy.class;
				dataClass = JavaExecutableTypeData.class;
				break;

			case TYPEVAR:
				adapterClass = JavaTypeVariableAdapter.class;
				proxyClass = JavaTypeVariableProxy.class;
				dataClass = JavaTypeVariableData.class;
				break;

			case WILDCARD:
				adapterClass = JavaWildcardTypeAdapter.class;
				proxyClass = JavaWildcardTypeProxy.class;
				dataClass = JavaWildcardTypeData.class;
				break;

			case NONE:
			case PACKAGE:
			case VOID:
				adapterClass = JavaVoidTypeAdapter.class;
				proxyClass = JavaVoidTypeProxy.class;
				dataClass = JavaVoidTypeData.class;
				break;

			case NULL:
				adapterClass = JavaNullTypeAdapter.class;
				proxyClass = JavaNullTypeProxy.class;
				dataClass = JavaNullTypeData.class;
				break;

			case ERROR:
				adapterClass = JavaErrorTypeAdapter.class;
				proxyClass = JavaErrorTypeProxy.class;
				dataClass = JavaErrorTypeData.class;
				break;

			default:
				adapterClass = JavaPrimitiveTypeAdapter.class;
				proxyClass = JavaPrimitiveTypeProxy.class;
				dataClass = JavaPrimitiveTypeData.class;
				break;
			}

			JavaType type = getTypeAdapter(typeMirror, adapterClass,
					proxyClass, dataClass, elementUtils, typeUtils);

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
			JavaMetadata metadata = METADATA_ADAPTERS.get(annotationMirror);
			if (metadata != null) {
				// it was in the cache already
				return metadata;
			}

			metadata = new JavaMetadataProxy(new JavaMetadataAdapter(
					annotationMirror, elementUtils, typeUtils),
					new JavaMetadataData());

			// put it to cache
			METADATA_ADAPTERS.put(annotationMirror, metadata);

			return metadata;
		} else {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	private static <T extends JavaElement> T getElementAdapter(Element element,
			Class<? extends JavaElementAdapter> adapterClass,
			Class<? extends JavaElementProxy> proxyClass,
			Class<? extends JavaElementData> dataClass, Elements elementUtils,
			Types typeUtils) {

		return (T) createModel(ELEMENT_ADAPTERS, element, adapterClass,
				proxyClass, dataClass, elementUtils, typeUtils);
	}

	private static JavaType getTypeAdapter(TypeMirror typeMirror,
			Class<? extends AbstractJavaTypeAdapter> adapterClass,
			Class<? extends JavaTypeProxy> proxyClass,
			Class<? extends JavaTypeData> dataClass, Elements elementUtils,
			Types typeUtils) {

		return (JavaType) createModel(TYPE_ADAPTERS, typeMirror, adapterClass,
				proxyClass, dataClass, elementUtils, typeUtils);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static <T> T createModel(Map map, Object target,
			Class<?> adapterClass, Class<?> proxyClass, Class<?> dataClass,
			Elements elementUtils, Types typeUtils) {
		try {
			Object adapter = map.get(target);

			if (adapter == null) {
				Constructor<?> constructor = adapterClass.getConstructors()[0];
				if (constructor != null) {
					adapter = constructor.newInstance(target, elementUtils,
							typeUtils);
					map.put(target, adapter);
				} else {
					throw new RuntimeException(
							"Cannot find adapter constructor!");
				}
			}

			Object data = dataClass.newInstance();
			T proxy = (T) proxyClass.getConstructors()[0].newInstance(adapter,
					data);

			return proxy;
		} catch (Exception e) {
			throw new RuntimeException("Cannot create element adapter!", e);
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
