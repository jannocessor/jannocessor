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

package org.jannocessor.proxy;

import java.util.List;

import org.jannocessor.data.JavaClassData;
import org.jannocessor.domain.JavaElement;
import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.JavaTypeName;
import org.jannocessor.domain.Name;
import org.jannocessor.domain.Text;
import org.jannocessor.domain.executable.JavaConstructor;
import org.jannocessor.domain.executable.JavaInstanceInit;
import org.jannocessor.domain.executable.JavaMethod;
import org.jannocessor.domain.executable.JavaStaticInit;
import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.domain.type.JavaTypeParameter;
import org.jannocessor.domain.variable.JavaField;

public class JavaClassProxy extends JavaElementProxy implements JavaClass {

	private JavaClass adapter;

	private JavaClassData data;

	public JavaClassProxy(JavaClass adapter, JavaClassData data) {
		super(adapter, data);
		this.adapter = adapter;
		this.data = data;
	}

	@Override
	public JavaElement getParent() {
		if (data.getParent() == null) {
			data.setParent(adapter.getParent());
		}

		return data.getParent();
	}

	@Override
	public List<JavaElement> getChildren() {
		if (data.getChildren() == null) {
			data.setChildren(adapter.getChildren());
		}

		return data.getChildren();
	}

	@Override
	public Name getName() {
		if (data.getName() == null) {
			data.setName(adapter.getName());
		}

		return data.getName();
	}

	@Override
	public Text getKind() {
		if (data.getKind() == null) {
			data.setKind(adapter.getKind());
		}

		return data.getKind();
	}

	@Override
	public JavaElementType getType() {
		if (data.getType() == null) {
			data.setType(adapter.getType());
		}

		return data.getType();
	}

	@Override
	public Text getNesting() {
		if (data.getNesting() == null) {
			data.setNesting(adapter.getNesting());
		}

		return data.getNesting();

	}

	@Override
	public Name getPackageName() {
		if (data.getPackageName() == null) {
			data.setPackageName(adapter.getPackageName());
		}

		return data.getPackageName();

	}

	@Override
	public JavaTypeName getQualifiedName() {
		if (data.getQualifiedName() == null) {
			data.setQualifiedName(adapter.getQualifiedName());
		}

		return data.getQualifiedName();

	}

	@Override
	public JavaElementType getSuperclass() {
		if (data.getSuperclass() == null) {
			data.setSuperclass(adapter.getSuperclass());
		}

		return data.getSuperclass();

	}

	@Override
	public List<JavaElementType> getInterfaces() {
		if (data.getInterfaces() == null) {
			data.setInterfaces(adapter.getInterfaces());
		}

		return data.getInterfaces();

	}

	@Override
	public List<JavaTypeParameter> getParameters() {
		if (data.getParameters() == null) {
			data.setParameters(adapter.getParameters());
		}

		return data.getParameters();

	}

	@Override
	public List<JavaField> getFields() {
		if (data.getFields() == null) {
			data.setFields(adapter.getFields());
		}

		return data.getFields();

	}

	@Override
	public List<JavaConstructor> getConstructors() {
		if (data.getConstructors() == null) {
			data.setConstructors(adapter.getConstructors());
		}

		return data.getConstructors();

	}

	@Override
	public List<JavaMethod> getMethods() {
		if (data.getMethods() == null) {
			data.setMethods(adapter.getMethods());
		}

		return data.getMethods();

	}

	@Override
	public List<JavaStaticInit> getStaticInits() {
		if (data.getStaticInits() == null) {
			data.setStaticInits(adapter.getStaticInits());
		}

		return data.getStaticInits();

	}

	@Override
	public List<JavaInstanceInit> getInstanceInits() {
		if (data.getInstanceInits() == null) {
			data.setInstanceInits(adapter.getInstanceInits());
		}

		return data.getInstanceInits();

	}

}
