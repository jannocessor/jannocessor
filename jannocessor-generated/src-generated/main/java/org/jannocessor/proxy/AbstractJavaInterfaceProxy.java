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
import org.jannocessor.proxy.AbstractJavaStructureProxy;
import org.jannocessor.model.structure.AbstractJavaInterface;
import org.jannocessor.data.AbstractJavaInterfaceData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.variable.JavaField;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaInterfaceProxy extends AbstractJavaStructureProxy implements AbstractJavaInterface {

	private static final long serialVersionUID = 1L;

    private transient AbstractJavaInterface adapter;

    private AbstractJavaInterfaceData data;

    public AbstractJavaInterfaceProxy(AbstractJavaInterface adapter, AbstractJavaInterfaceData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

	private boolean getFieldsInitialized = false;


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

    public PowerList<JavaField> getFields() {
        if (!getFieldsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setFields(ModelUtils.parentedList(adapter.getFields(), this));
			getFieldsInitialized = true;
        }

        return data.getFields();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaInterface)) {
			return false;
		}

		AbstractJavaInterface other = (AbstractJavaInterface) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getFields(), other.getFields())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getFields())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaInterface.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("fields", ToStringUtil.describe(this.getFields()));
	}

}


