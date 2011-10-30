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
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.data.JavaParameterData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaMetadata;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaParameterProxy extends AbstractJavaVariableProxy implements JavaParameter {

	private static final long serialVersionUID = 1L;

    private transient JavaParameter adapter;

    private JavaParameterData data;

    public JavaParameterProxy(JavaParameter adapter, JavaParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean isFinalInitialized = false;

	private boolean getMetadataInitialized = false;


	@Override
    public JavaParameter copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public boolean isFinal() {
        if (!isFinalInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setFinal(adapter.isFinal());
			isFinalInitialized = true;
        }

        return data.isFinal();
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
		if (!(obj instanceof JavaParameter)) {
			return false;
		}

		JavaParameter other = (JavaParameter) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.isFinal(), other.isFinal())
				.append(this.getMetadata(), other.getMetadata())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.isFinal())
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaParameter.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("_isFinal", ToStringUtil.describe(this.isFinal()));
        builder.append("metadata", ToStringUtil.describe(this.getMetadata()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.isFinal();
		this.getMetadata();
	}

}


