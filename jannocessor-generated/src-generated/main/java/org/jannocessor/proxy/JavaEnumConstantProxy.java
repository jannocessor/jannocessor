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
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.data.JavaEnumConstantData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.util.ModelUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaEnumConstantProxy extends AbstractJavaVariableProxy implements JavaEnumConstant {

	private static final long serialVersionUID = 1L;

    private transient JavaEnumConstant adapter;

    private JavaEnumConstantData data;

    public JavaEnumConstantProxy(JavaEnumConstant adapter, JavaEnumConstantData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getValuesInitialized = false;


	@Override
    public PowerList<JavaExpression> getValues() {
        if (!getValuesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setValues(ModelUtils.parentedList(adapter.getValues(), this));
			getValuesInitialized = true;
        }

        return data.getValues();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaEnumConstant)) {
			return false;
		}

		JavaEnumConstant other = (JavaEnumConstant) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getValues(), other.getValues())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getValues())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaEnumConstant.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("values", ToStringUtil.describe(this.getValues()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getValues();
	}

}


