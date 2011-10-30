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
import org.jannocessor.proxy.AbstractJavaVariableProxy;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.data.JavaFieldData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaMetadata;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaFieldProxy extends AbstractJavaVariableProxy implements JavaField {

	private static final long serialVersionUID = 1L;

    private transient JavaField adapter;

    private JavaFieldData data;

    public JavaFieldProxy(JavaField adapter, JavaFieldData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getModifiersInitialized = false;

	private boolean getValueInitialized = false;

	private boolean getMetadataInitialized = false;


	@Override
    public JavaField copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public FieldModifiers getModifiers() {
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
    public JavaExpression getValue() {
        if (!getValueInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setValue(adapter.getValue());
			getValueInitialized = true;
        }

        return data.getValue();
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
		if (!(obj instanceof JavaField)) {
			return false;
		}

		JavaField other = (JavaField) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getModifiers(), other.getModifiers())
				.append(this.getValue(), other.getValue())
				.append(this.getMetadata(), other.getMetadata())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getModifiers())
				.append(this.getValue())
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaField.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("modifiers", ToStringUtil.describe(this.getModifiers()));
        builder.append("value", ToStringUtil.describe(this.getValue()));
        builder.append("metadata", ToStringUtil.describe(this.getMetadata()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getModifiers();
		this.getValue();
		this.getMetadata();
	}

}


