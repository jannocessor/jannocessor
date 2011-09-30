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

import javax.annotation.Generated;
import org.jannocessor.proxy.AbstractJavaTypeProxy;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.data.JavaClassData;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaClassProxy extends AbstractJavaTypeProxy implements JavaClass {

    private JavaClass adapter;

    private JavaClassData data;

    public JavaClassProxy(JavaClass adapter, JavaClassData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getModifiersInitialized = false;

	private boolean getFieldsInitialized = false;

	private boolean getConstructorsInitialized = false;

	private boolean getMethodsInitialized = false;

	private boolean getStaticInitsInitialized = false;

	private boolean getInstanceInitsInitialized = false;

	private boolean getNestedClassesInitialized = false;

	private boolean getNestedEnumsInitialized = false;

	private boolean getNestedInterfacesInitialized = false;

	private boolean getNestedAnnotationsInitialized = false;


    public ClassModifiers getModifiers() {
        if (!getModifiersInitialized) {
            data.setModifiers(adapter.getModifiers());
			getModifiersInitialized = true;
        }

        return data.getModifiers();
    }

    public PowerList<JavaField> getFields() {
        if (!getFieldsInitialized) {
            data.setFields(adapter.getFields());
			getFieldsInitialized = true;
        }

        return data.getFields();
    }

    public PowerList<JavaConstructor> getConstructors() {
        if (!getConstructorsInitialized) {
            data.setConstructors(adapter.getConstructors());
			getConstructorsInitialized = true;
        }

        return data.getConstructors();
    }

    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        if (!getStaticInitsInitialized) {
            data.setStaticInits(adapter.getStaticInits());
			getStaticInitsInitialized = true;
        }

        return data.getStaticInits();
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        if (!getInstanceInitsInitialized) {
            data.setInstanceInits(adapter.getInstanceInits());
			getInstanceInitsInitialized = true;
        }

        return data.getInstanceInits();
    }

    public PowerList<JavaNestedClass> getNestedClasses() {
        if (!getNestedClassesInitialized) {
            data.setNestedClasses(adapter.getNestedClasses());
			getNestedClassesInitialized = true;
        }

        return data.getNestedClasses();
    }

    public PowerList<JavaNestedEnum> getNestedEnums() {
        if (!getNestedEnumsInitialized) {
            data.setNestedEnums(adapter.getNestedEnums());
			getNestedEnumsInitialized = true;
        }

        return data.getNestedEnums();
    }

    public PowerList<JavaNestedInterface> getNestedInterfaces() {
        if (!getNestedInterfacesInitialized) {
            data.setNestedInterfaces(adapter.getNestedInterfaces());
			getNestedInterfacesInitialized = true;
        }

        return data.getNestedInterfaces();
    }

    public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
        if (!getNestedAnnotationsInitialized) {
            data.setNestedAnnotations(adapter.getNestedAnnotations());
			getNestedAnnotationsInitialized = true;
        }

        return data.getNestedAnnotations();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaClass)) {
			return false;
		}

		JavaClass other = (JavaClass) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getModifiers(), other.getModifiers())
				.append(this.getFields(), other.getFields())
				.append(this.getConstructors(), other.getConstructors())
				.append(this.getMethods(), other.getMethods())
				.append(this.getStaticInits(), other.getStaticInits())
				.append(this.getInstanceInits(), other.getInstanceInits())
				.append(this.getNestedClasses(), other.getNestedClasses())
				.append(this.getNestedEnums(), other.getNestedEnums())
				.append(this.getNestedInterfaces(), other.getNestedInterfaces())
				.append(this.getNestedAnnotations(), other.getNestedAnnotations())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getModifiers())
				.append(this.getFields())
				.append(this.getConstructors())
				.append(this.getMethods())
				.append(this.getStaticInits())
				.append(this.getInstanceInits())
				.append(this.getNestedClasses())
				.append(this.getNestedEnums())
				.append(this.getNestedInterfaces())
				.append(this.getNestedAnnotations())
				.toHashCode();
	}


	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("modifiers", this.getModifiers());
        builder.append("fields", this.getFields());
        builder.append("constructors", this.getConstructors());
        builder.append("methods", this.getMethods());
        builder.append("staticInits", this.getStaticInits());
        builder.append("instanceInits", this.getInstanceInits());
        builder.append("nestedClasses", this.getNestedClasses());
        builder.append("nestedEnums", this.getNestedEnums());
        builder.append("nestedInterfaces", this.getNestedInterfaces());
        builder.append("nestedAnnotations", this.getNestedAnnotations());
	}

}


