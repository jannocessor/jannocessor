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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.AbstractJavaExecutableData;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaMethodData extends AbstractJavaExecutableData implements JavaMethod {

	private static final long serialVersionUID = 1L;

    private PowerList<JavaTypeParameter> typeParameters;

    private JavaType returnType;

    private PowerList<JavaParameter> parameters;

    private Boolean _isVarArgs;

    private PowerList<JavaType> thrownTypes;

    private MethodModifiers modifiers;

    private PowerList<JavaMetadata> metadata;


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

    public PowerList<JavaMetadata> getMetadata() {
        return this.metadata;
    }

    public void setMetadata(PowerList<JavaMetadata> value) {
        this.metadata = value;
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
				.append(this.getMetadata(), other.getMetadata())
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
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaMethod.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("returnType", ToStringUtil.describe(this.getReturnType()));
        builder.append("parameters", ToStringUtil.describe(this.getParameters()));
        builder.append("_isVarArgs", ToStringUtil.describe(this.isVarArgs()));
        builder.append("thrownTypes", ToStringUtil.describe(this.getThrownTypes()));
        builder.append("modifiers", ToStringUtil.describe(this.getModifiers()));
        builder.append("metadata", ToStringUtil.describe(this.getMetadata()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


