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

import javax.annotation.Generated;
import org.jannocessor.data.AbstractJavaStructureData;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
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
public class AbstractJavaClassData extends AbstractJavaStructureData implements AbstractJavaClass {

    private PowerList<JavaTypeParameter> parameters;

    private PowerList<JavaField> fields;

    private PowerList<JavaConstructor> constructors;

    private PowerList<JavaMethod> methods;

    private PowerList<JavaStaticInit> staticInits;

    private PowerList<JavaInstanceInit> instanceInits;

    private PowerList<JavaNestedClass> nestedClasses;

    private PowerList<JavaNestedEnum> nestedEnums;

    private PowerList<JavaNestedInterface> nestedInterfaces;

    private PowerList<JavaNestedAnnotation> nestedAnnotations;


    public PowerList<JavaTypeParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaTypeParameter> value) {
        this.parameters = value;
    }

    public PowerList<JavaField> getFields() {
        return this.fields;
    }

    public void setFields(PowerList<JavaField> value) {
        this.fields = value;
    }

    public PowerList<JavaConstructor> getConstructors() {
        return this.constructors;
    }

    public void setConstructors(PowerList<JavaConstructor> value) {
        this.constructors = value;
    }

    public PowerList<JavaMethod> getMethods() {
        return this.methods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this.methods = value;
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        return this.staticInits;
    }

    public void setStaticInits(PowerList<JavaStaticInit> value) {
        this.staticInits = value;
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        return this.instanceInits;
    }

    public void setInstanceInits(PowerList<JavaInstanceInit> value) {
        this.instanceInits = value;
    }

    public PowerList<JavaNestedClass> getNestedClasses() {
        return this.nestedClasses;
    }

    public void setNestedClasses(PowerList<JavaNestedClass> value) {
        this.nestedClasses = value;
    }

    public PowerList<JavaNestedEnum> getNestedEnums() {
        return this.nestedEnums;
    }

    public void setNestedEnums(PowerList<JavaNestedEnum> value) {
        this.nestedEnums = value;
    }

    public PowerList<JavaNestedInterface> getNestedInterfaces() {
        return this.nestedInterfaces;
    }

    public void setNestedInterfaces(PowerList<JavaNestedInterface> value) {
        this.nestedInterfaces = value;
    }

    public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
        return this.nestedAnnotations;
    }

    public void setNestedAnnotations(PowerList<JavaNestedAnnotation> value) {
        this.nestedAnnotations = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaClass)) {
			return false;
		}

		AbstractJavaClass other = (AbstractJavaClass) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getParameters(), other.getParameters())
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
				.append(this.getParameters())
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
        builder.append("parameters", this.getParameters());
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


