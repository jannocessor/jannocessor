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
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.data.AbstractJavaStructureData;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaStructureProxy extends JavaElementProxy implements AbstractJavaStructure {

    private AbstractJavaStructure adapter;

    private AbstractJavaStructureData data;

    public AbstractJavaStructureProxy(AbstractJavaStructure adapter, AbstractJavaStructureData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNestingInitialized = false;

	private boolean getPackageNameInitialized = false;

	private boolean getQualifiedNameInitialized = false;

	private boolean getSuperclassInitialized = false;

	private boolean getInterfacesInitialized = false;

	private boolean getMethodsInitialized = false;

	private boolean getNestedClassesInitialized = false;

	private boolean getNestedEnumsInitialized = false;

	private boolean getNestedInterfacesInitialized = false;

	private boolean getNestedAnnotationsInitialized = false;


    public String getNesting() {
        if (!getNestingInitialized) {
            data.setNesting(adapter.getNesting());
			getNestingInitialized = true;
        }

        return data.getNesting();
    }

    public Name getPackageName() {
        if (!getPackageNameInitialized) {
            data.setPackageName(adapter.getPackageName());
			getPackageNameInitialized = true;
        }

        return data.getPackageName();
    }

    public Name getQualifiedName() {
        if (!getQualifiedNameInitialized) {
            data.setQualifiedName(adapter.getQualifiedName());
			getQualifiedNameInitialized = true;
        }

        return data.getQualifiedName();
    }

    public JavaType getSuperclass() {
        if (!getSuperclassInitialized) {
            data.setSuperclass(adapter.getSuperclass());
			getSuperclassInitialized = true;
        }

        return data.getSuperclass();
    }

    public PowerList<JavaType> getInterfaces() {
        if (!getInterfacesInitialized) {
            data.setInterfaces(adapter.getInterfaces());
			getInterfacesInitialized = true;
        }

        return data.getInterfaces();
    }

    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
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
		if (!(obj instanceof AbstractJavaStructure)) {
			return false;
		}

		AbstractJavaStructure other = (AbstractJavaStructure) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getNesting(), other.getNesting())
				.append(this.getPackageName(), other.getPackageName())
				.append(this.getQualifiedName(), other.getQualifiedName())
				.append(this.getSuperclass(), other.getSuperclass())
				.append(this.getInterfaces(), other.getInterfaces())
				.append(this.getMethods(), other.getMethods())
				.append(this.getNestedClasses(), other.getNestedClasses())
				.append(this.getNestedEnums(), other.getNestedEnums())
				.append(this.getNestedInterfaces(), other.getNestedInterfaces())
				.append(this.getNestedAnnotations(), other.getNestedAnnotations())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getNesting())
				.append(this.getPackageName())
				.append(this.getQualifiedName())
				.append(this.getSuperclass())
				.append(this.getInterfaces())
				.append(this.getMethods())
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
        builder.append("nesting", this.getNesting());
        builder.append("packageName", this.getPackageName());
        builder.append("qualifiedName", this.getQualifiedName());
        builder.append("superclass", this.getSuperclass());
        builder.append("interfaces", this.getInterfaces());
        builder.append("methods", this.getMethods());
        builder.append("nestedClasses", this.getNestedClasses());
        builder.append("nestedEnums", this.getNestedEnums());
        builder.append("nestedInterfaces", this.getNestedInterfaces());
        builder.append("nestedAnnotations", this.getNestedAnnotations());
	}

}


