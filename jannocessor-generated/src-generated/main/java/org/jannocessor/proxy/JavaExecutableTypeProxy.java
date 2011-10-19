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
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.data.JavaExecutableTypeData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableTypeProxy extends JavaTypeProxy implements JavaExecutableType {

    private JavaExecutableType adapter;

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


    public PowerList<JavaType> getParameterTypes() {
        if (!getParameterTypesInitialized) {
            data.setParameterTypes(ModelUtils.parentedList(adapter.getParameterTypes(), this));
			getParameterTypesInitialized = true;
        }

        return data.getParameterTypes();
    }

    public JavaType getReturnType() {
        if (!getReturnTypeInitialized) {
            data.setReturnType(adapter.getReturnType());
			getReturnTypeInitialized = true;
        }

        return data.getReturnType();
    }

    public PowerList<JavaDeclaredType> getThrownTypes() {
        if (!getThrownTypesInitialized) {
            data.setThrownTypes(ModelUtils.parentedList(adapter.getThrownTypes(), this));
			getThrownTypesInitialized = true;
        }

        return data.getThrownTypes();
    }

    public PowerList<JavaTypeVariable> getTypeVariables() {
        if (!getTypeVariablesInitialized) {
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

}


