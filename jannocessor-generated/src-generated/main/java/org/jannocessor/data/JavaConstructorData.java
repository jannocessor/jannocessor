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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.AbstractJavaExecutableData;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorData extends AbstractJavaExecutableData implements JavaConstructor {

	private static final long serialVersionUID = 1L;

    private PowerList<JavaTypeParameter> typeParameters;

    private PowerList<JavaParameter> parameters;

    private Boolean _isVarArgs;

    private PowerList<JavaType> thrownTypes;

    private ConstructorModifiers modifiers;

    private PowerList<JavaMetadata> metadata;


    public JavaConstructor copy() {
        return ModelUtils.copy(this);
    }

    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
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

    public Boolean isDefault() {
        return ModelUtils.isDefault(this);
    }

    public PowerList<JavaType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaType> value) {
        this.thrownTypes = value;
    }

    public ConstructorModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(ConstructorModifiers value) {
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
		if (!(obj instanceof JavaConstructor)) {
			return false;
		}

		JavaConstructor other = (JavaConstructor) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getParameters(), other.getParameters())
				.append(this.isVarArgs(), other.isVarArgs())
				.append(this.isDefault(), other.isDefault())
				.append(this.getThrownTypes(), other.getThrownTypes())
				.append(this.getModifiers(), other.getModifiers())
				.append(this.getMetadata(), other.getMetadata())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getParameters())
				.append(this.isVarArgs())
				.append(this.isDefault())
				.append(this.getThrownTypes())
				.append(this.getModifiers())
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaConstructor.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("parameters", ToStringUtil.describe(this.getParameters()));
        builder.append("_isVarArgs", ToStringUtil.describe(this.isVarArgs()));
        builder.append("_isDefault", ToStringUtil.describe(this.isDefault()));
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


