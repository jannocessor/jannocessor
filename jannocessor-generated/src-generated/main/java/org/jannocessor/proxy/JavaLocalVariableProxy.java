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
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.data.JavaLocalVariableData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaLocalVariableProxy extends AbstractJavaVariableProxy implements JavaLocalVariable {

	private static final long serialVersionUID = 1L;

    private transient JavaLocalVariable adapter;

    private JavaLocalVariableData data;

    public JavaLocalVariableProxy(JavaLocalVariable adapter, JavaLocalVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean isFinalInitialized = false;


	@Override
    public JavaLocalVariable copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public Boolean isFinal() {
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
    public AbstractJavaExecutable getParent() {
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
		if (!(obj instanceof JavaLocalVariable)) {
			return false;
		}

		JavaLocalVariable other = (JavaLocalVariable) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.isFinal(), other.isFinal())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.isFinal())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaLocalVariable.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("_isFinal", ToStringUtil.describe(this.isFinal()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.isFinal();
	}

}


