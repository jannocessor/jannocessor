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
import org.jannocessor.data.AbstractJavaStructureData;
import org.jannocessor.model.structure.AbstractJavaInterface;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.util.ModelUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaInterfaceData extends AbstractJavaStructureData implements AbstractJavaInterface {

	private static final long serialVersionUID = 1L;

    private PowerList<JavaTypeParameter> typeParameters;

    private PowerList<JavaField> fields;


    public AbstractJavaInterface copy() {
        return ModelUtils.copy(this);
    }

    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
    }

    public PowerList<JavaField> getFields() {
        return this.fields;
    }

    public void setFields(PowerList<JavaField> value) {
        this.fields = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaInterface)) {
			return false;
		}

		AbstractJavaInterface other = (AbstractJavaInterface) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getFields(), other.getFields())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getFields())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaInterface.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("fields", ToStringUtil.describe(this.getFields()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


