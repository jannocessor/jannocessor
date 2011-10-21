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
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.data.JavaTypeParameterData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ModelUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeParameterProxy extends JavaElementProxy implements JavaTypeParameter {

	private static final long serialVersionUID = 1L;

    private transient JavaTypeParameter adapter;

    private JavaTypeParameterData data;

    public JavaTypeParameterProxy(JavaTypeParameter adapter, JavaTypeParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getBoundsInitialized = false;


    public PowerList<JavaType> getBounds() {
        if (!getBoundsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setBounds(ModelUtils.parentedList(adapter.getBounds(), this));
			getBoundsInitialized = true;
        }

        return data.getBounds();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaTypeParameter)) {
			return false;
		}

		JavaTypeParameter other = (JavaTypeParameter) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getBounds(), other.getBounds())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getBounds())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaTypeParameter.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("bounds", ToStringUtil.describe(this.getBounds()));
	}

}


