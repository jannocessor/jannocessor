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
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.data.JavaTypeVariableData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.type.JavaType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeVariableProxy extends JavaTypeProxy implements JavaTypeVariable {

	private static final long serialVersionUID = 1L;

    private transient JavaTypeVariable adapter;

    private JavaTypeVariableData data;

    public JavaTypeVariableProxy(JavaTypeVariable adapter, JavaTypeVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getUpperBoundInitialized = false;

	private boolean getLowerBoundInitialized = false;


	@Override
    public JavaTypeVariable copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public JavaType getUpperBound() {
        if (!getUpperBoundInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setUpperBound(adapter.getUpperBound());
			getUpperBoundInitialized = true;
        }

        return data.getUpperBound();
    }

	@Override
    public JavaType getLowerBound() {
        if (!getLowerBoundInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setLowerBound(adapter.getLowerBound());
			getLowerBoundInitialized = true;
        }

        return data.getLowerBound();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaTypeVariable)) {
			return false;
		}

		JavaTypeVariable other = (JavaTypeVariable) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getUpperBound(), other.getUpperBound())
				.append(this.getLowerBound(), other.getLowerBound())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getUpperBound())
				.append(this.getLowerBound())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaTypeVariable.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("upperBound", ToStringUtil.describe(this.getUpperBound()));
        builder.append("lowerBound", ToStringUtil.describe(this.getLowerBound()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getUpperBound();
		this.getLowerBound();
	}

}


