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
import org.jannocessor.proxy.AbstractJavaExecutableProxy;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.data.JavaConstructorData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorProxy extends AbstractJavaExecutableProxy implements JavaConstructor {

    private JavaConstructor adapter;

    private JavaConstructorData data;

    public JavaConstructorProxy(JavaConstructor adapter, JavaConstructorData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

	private boolean getParametersInitialized = false;

	private boolean isVarArgsInitialized = false;

	private boolean getThrownTypesInitialized = false;

	private boolean getModifiersInitialized = false;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        if (!getTypeParametersInitialized) {
            data.setTypeParameters(adapter.getTypeParameters());
			getTypeParametersInitialized = true;
        }

        return data.getTypeParameters();
    }

    public PowerList<JavaParameter> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }

    public Boolean isVarArgs() {
        if (!isVarArgsInitialized) {
            data.setVarArgs(adapter.isVarArgs());
			isVarArgsInitialized = true;
        }

        return data.isVarArgs();
    }

    public PowerList<JavaType> getThrownTypes() {
        if (!getThrownTypesInitialized) {
            data.setThrownTypes(adapter.getThrownTypes());
			getThrownTypesInitialized = true;
        }

        return data.getThrownTypes();
    }

    public ConstructorModifiers getModifiers() {
        if (!getModifiersInitialized) {
            data.setModifiers(adapter.getModifiers());
			getModifiersInitialized = true;
        }

        return data.getModifiers();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaConstructor)) {
			return false;
		}

		JavaConstructor other = (JavaConstructor) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getParameters(), other.getParameters())
				.append(this.isVarArgs(), other.isVarArgs())
				.append(this.getThrownTypes(), other.getThrownTypes())
				.append(this.getModifiers(), other.getModifiers())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getParameters())
				.append(this.isVarArgs())
				.append(this.getThrownTypes())
				.append(this.getModifiers())
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
        builder.append("typeParameters", this.getTypeParameters());
        builder.append("parameters", this.getParameters());
        builder.append("_isVarArgs", this.isVarArgs());
        builder.append("thrownTypes", this.getThrownTypes());
        builder.append("modifiers", this.getModifiers());
	}

}


