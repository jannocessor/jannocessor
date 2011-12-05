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
import org.jannocessor.proxy.AbstractJavaVariableProxy;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.data.JavaEnumConstantData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.structure.AbstractJavaEnum;
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
    public JavaEnumConstant copy() {
        return ModelUtils.copy(this);
    }

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
    public AbstractJavaEnum getParent() {
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


