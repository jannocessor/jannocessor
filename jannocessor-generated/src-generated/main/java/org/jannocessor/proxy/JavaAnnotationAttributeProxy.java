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
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.jannocessor.data.JavaAnnotationAttributeData;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaAnnotationAttributeProxy extends JavaElementProxy implements JavaAnnotationAttribute {

	private static final long serialVersionUID = 1L;

    private transient JavaAnnotationAttribute adapter;

    private JavaAnnotationAttributeData data;

    public JavaAnnotationAttributeProxy(JavaAnnotationAttribute adapter, JavaAnnotationAttributeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getDefaultValueInitialized = false;


    public Object getDefaultValue() {
        if (!getDefaultValueInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setDefaultValue(adapter.getDefaultValue());
			getDefaultValueInitialized = true;
        }

        return data.getDefaultValue();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaAnnotationAttribute)) {
			return false;
		}

		JavaAnnotationAttribute other = (JavaAnnotationAttribute) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getDefaultValue(), other.getDefaultValue())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getDefaultValue())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaAnnotationAttribute.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("defaultValue", ToStringUtil.describe(this.getDefaultValue()));
	}

}


