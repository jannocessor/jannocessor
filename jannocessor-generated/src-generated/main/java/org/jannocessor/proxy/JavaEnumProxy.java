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
import org.jannocessor.proxy.AbstractJavaEnumProxy;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.data.JavaEnumData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.structure.JavaPackage;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaEnumProxy extends AbstractJavaEnumProxy implements JavaEnum {

	private static final long serialVersionUID = 1L;

    private transient JavaEnum adapter;

    private JavaEnumData data;

    public JavaEnumProxy(JavaEnum adapter, JavaEnumData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getModifiersInitialized = false;


	@Override
    public JavaEnum copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public EnumModifiers getModifiers() {
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
    public JavaPackage getParent() {
        return super.retrieveParent();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaEnum)) {
			return false;
		}

		JavaEnum other = (JavaEnum) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getModifiers(), other.getModifiers())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getModifiers())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaEnum.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("modifiers", ToStringUtil.describe(this.getModifiers()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getModifiers();
	}

}


