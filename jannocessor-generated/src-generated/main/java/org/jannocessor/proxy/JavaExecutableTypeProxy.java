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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.data.JavaExecutableTypeData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableTypeProxy extends JavaTypeProxy implements JavaExecutableType {

	private static final long serialVersionUID = 1L;

    private transient JavaExecutableType adapter;

    private JavaExecutableTypeData data;

    public JavaExecutableTypeProxy(JavaExecutableType adapter, JavaExecutableTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParameterTypesInitialized = false;

	private boolean getReturnTypeInitialized = false;

	private boolean getThrownTypesInitialized = false;

	private boolean getTypeVariablesInitialized = false;


	@Override
    public JavaExecutableType copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public PowerList<JavaType> getParameterTypes() {
        if (!getParameterTypesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setParameterTypes(ModelUtils.parentedList(adapter.getParameterTypes(), this));
			getParameterTypesInitialized = true;
        }

        return data.getParameterTypes();
    }

	@Override
    public JavaType getReturnType() {
        if (!getReturnTypeInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setReturnType(adapter.getReturnType());
			getReturnTypeInitialized = true;
        }

        return data.getReturnType();
    }

	@Override
    public PowerList<JavaDeclaredType> getThrownTypes() {
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
    public PowerList<JavaTypeVariable> getTypeVariables() {
        if (!getTypeVariablesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setTypeVariables(ModelUtils.parentedList(adapter.getTypeVariables(), this));
			getTypeVariablesInitialized = true;
        }

        return data.getTypeVariables();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaExecutableType)) {
			return false;
		}

		JavaExecutableType other = (JavaExecutableType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getParameterTypes(), other.getParameterTypes())
				.append(this.getReturnType(), other.getReturnType())
				.append(this.getThrownTypes(), other.getThrownTypes())
				.append(this.getTypeVariables(), other.getTypeVariables())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getParameterTypes())
				.append(this.getReturnType())
				.append(this.getThrownTypes())
				.append(this.getTypeVariables())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaExecutableType.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("parameterTypes", ToStringUtil.describe(this.getParameterTypes()));
        builder.append("returnType", ToStringUtil.describe(this.getReturnType()));
        builder.append("thrownTypes", ToStringUtil.describe(this.getThrownTypes()));
        builder.append("typeVariables", ToStringUtil.describe(this.getTypeVariables()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getParameterTypes();
		this.getReturnType();
		this.getThrownTypes();
		this.getTypeVariables();
	}

}


