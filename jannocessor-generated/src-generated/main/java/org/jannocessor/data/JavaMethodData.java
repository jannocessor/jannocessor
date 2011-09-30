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
import org.jannocessor.data.AbstractJavaExecutableData;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.modifier.MethodModifiers;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaMethodData extends AbstractJavaExecutableData implements JavaMethod {

    private PowerList<JavaTypeParameter> typeParameters;

    private JavaType returnType;

    private PowerList<JavaParameter> parameters;

    private Boolean _isVarArgs;

    private PowerList<JavaType> thrownTypes;

    private MethodModifiers modifiers;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
    }

    public JavaType getReturnType() {
        return this.returnType;
    }

    public void setReturnType(JavaType value) {
        this.returnType = value;
    }

    public PowerList<JavaParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaParameter> value) {
        this.parameters = value;
    }

    public Boolean isVarArgs() {
        return this._isVarArgs;
    }

    public void setVarArgs(Boolean value) {
        this._isVarArgs = value;
    }

    public PowerList<JavaType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaType> value) {
        this.thrownTypes = value;
    }

    public MethodModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(MethodModifiers value) {
        this.modifiers = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaMethod)) {
			return false;
		}

		JavaMethod other = (JavaMethod) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getReturnType(), other.getReturnType())
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
				.append(this.getReturnType())
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
        builder.append("returnType", this.getReturnType());
        builder.append("parameters", this.getParameters());
        builder.append("_isVarArgs", this.isVarArgs());
        builder.append("thrownTypes", this.getThrownTypes());
        builder.append("modifiers", this.getModifiers());
	}

}


