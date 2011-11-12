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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.AbstractJavaVariableData;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaLocalVariableData extends AbstractJavaVariableData implements JavaLocalVariable {

	private static final long serialVersionUID = 1L;

    private Boolean _isFinal;


    public JavaLocalVariable copy() {
        return ModelUtils.copy(this);
    }

    public Boolean isFinal() {
        return this._isFinal;
    }

    public void setFinal(Boolean value) {
        this._isFinal = value;
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

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


