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

package org.jannocessor.data;

import java.util.List;

import org.jannocessor.domain.JavaElementType;
import org.jannocessor.domain.Name;
import org.jannocessor.domain.Name;
import org.jannocessor.domain.Text;
import org.jannocessor.domain.executable.JavaConstructor;
import org.jannocessor.domain.executable.JavaInstanceInit;
import org.jannocessor.domain.executable.JavaMethod;
import org.jannocessor.domain.executable.JavaStaticInit;
import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.domain.type.JavaTypeParameter;
import org.jannocessor.domain.variable.JavaField;

public class JavaClassData extends JavaElementData implements JavaClass {

	private Text nesting;
	private Name packageName;
	private Name qualifiedName;
	private JavaElementType superclass;
	private List<JavaElementType> interfaces;
	private List<JavaTypeParameter> parameters;
	private List<JavaField> fields;
	private List<JavaConstructor> constructors;
	private List<JavaMethod> methods;
	private List<JavaStaticInit> staticInits;
	private List<JavaInstanceInit> instanceInits;

	@Override
	public Text getNesting() {
		return nesting;
	}

	@Override
	public Name getPackageName() {
		return packageName;
	}

	@Override
	public Name getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public JavaElementType getSuperclass() {
		return superclass;
	}

	@Override
	public List<JavaElementType> getInterfaces() {
		return interfaces;
	}

	@Override
	public List<JavaTypeParameter> getParameters() {
		return parameters;
	}

	@Override
	public List<JavaField> getFields() {
		return fields;
	}

	@Override
	public List<JavaConstructor> getConstructors() {
		return constructors;
	}

	@Override
	public List<JavaMethod> getMethods() {
		return methods;
	}

	@Override
	public List<JavaStaticInit> getStaticInits() {
		return staticInits;
	}

	@Override
	public List<JavaInstanceInit> getInstanceInits() {
		return instanceInits;
	}

	public void setNesting(Text nesting) {
		this.nesting = nesting;
	}

	public void setPackageName(Name packageName) {
		this.packageName = packageName;
	}

	public void setQualifiedName(Name qualifiedName) {
		this.qualifiedName = qualifiedName;
	}

	public void setSuperclass(JavaElementType superclass) {
		this.superclass = superclass;
	}

	public void setInterfaces(List<JavaElementType> interfaces) {
		this.interfaces = interfaces;
	}

	public void setParameters(List<JavaTypeParameter> parameters) {
		this.parameters = parameters;
	}

	public void setFields(List<JavaField> fields) {
		this.fields = fields;
	}

	public void setConstructors(List<JavaConstructor> constructors) {
		this.constructors = constructors;
	}

	public void setMethods(List<JavaMethod> methods) {
		this.methods = methods;
	}

	public void setStaticInits(List<JavaStaticInit> staticInits) {
		this.staticInits = staticInits;
	}

	public void setInstanceInits(List<JavaInstanceInit> instanceInits) {
		this.instanceInits = instanceInits;
	}

}
