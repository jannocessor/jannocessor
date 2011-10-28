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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.AbstractJavaExecutableProxy;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.data.JavaConstructorData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorProxy extends AbstractJavaExecutableProxy implements JavaConstructor {

	private static final long serialVersionUID = 1L;

    private transient JavaConstructor adapter;

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

	private boolean getMetadataInitialized = false;


	@Override
    public PowerList<JavaTypeParameter> getTypeParameters() {
        if (!getTypeParametersInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setTypeParameters(ModelUtils.parentedList(adapter.getTypeParameters(), this));
			getTypeParametersInitialized = true;
        }

        return data.getTypeParameters();
    }

	@Override
    public PowerList<JavaParameter> getParameters() {
        if (!getParametersInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setParameters(ModelUtils.parentedList(adapter.getParameters(), this));
			getParametersInitialized = true;
        }

        return data.getParameters();
    }

	@Override
    public Boolean isVarArgs() {
        if (!isVarArgsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setVarArgs(adapter.isVarArgs());
			isVarArgsInitialized = true;
        }

        return data.isVarArgs();
    }

	@Override
    public Boolean isDefault() {
        return ModelUtils.isDefault(this);
    }

	@Override
    public PowerList<JavaType> getThrownTypes() {
        if (!getThrownTypesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setThrownTypes(ModelUtils.parentedList(adapter.getThrownTypes(), this));
			getThrownTypesInitialized = true;
        }

        return data.getThrownTypes();
    }

	@Override
    public ConstructorModifiers getModifiers() {
        if (!getModifiersInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setModifiers(adapter.getModifiers());
			getModifiersInitialized = true;
        }

        return data.getModifiers();
    }

	@Override
    public PowerList<JavaMetadata> getMetadata() {
        if (!getMetadataInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setMetadata(ModelUtils.parentedList(adapter.getMetadata(), this));
			getMetadataInitialized = true;
        }

        return data.getMetadata();
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

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getTypeParameters();
		this.getParameters();
		this.isVarArgs();
		this.getThrownTypes();
		this.getModifiers();
		this.getMetadata();
	}

}


