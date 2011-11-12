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
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.data.JavaWildcardTypeData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.type.JavaType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaWildcardTypeProxy extends JavaTypeProxy implements JavaWildcardType {

	private static final long serialVersionUID = 1L;

    private transient JavaWildcardType adapter;

    private JavaWildcardTypeData data;

    public JavaWildcardTypeProxy(JavaWildcardType adapter, JavaWildcardTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getExtendsBoundInitialized = false;

	private boolean getSuperBoundInitialized = false;


	@Override
    public JavaWildcardType copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public JavaType getExtendsBound() {
        if (!getExtendsBoundInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setExtendsBound(adapter.getExtendsBound());
			getExtendsBoundInitialized = true;
        }

        return data.getExtendsBound();
    }

	@Override
    public JavaType getSuperBound() {
        if (!getSuperBoundInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setSuperBound(adapter.getSuperBound());
			getSuperBoundInitialized = true;
        }

        return data.getSuperBound();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaWildcardType)) {
			return false;
		}

		JavaWildcardType other = (JavaWildcardType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getExtendsBound(), other.getExtendsBound())
				.append(this.getSuperBound(), other.getSuperBound())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getExtendsBound())
				.append(this.getSuperBound())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaWildcardType.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("extendsBound", ToStringUtil.describe(this.getExtendsBound()));
        builder.append("superBound", ToStringUtil.describe(this.getSuperBound()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getExtendsBound();
		this.getSuperBound();
	}

}


