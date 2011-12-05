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
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.type.JavaType;
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
public class JavaWildcardTypeData extends JavaTypeData implements JavaWildcardType {

	private static final long serialVersionUID = 1L;

    private JavaType extendsBound;

    private JavaType superBound;


    public JavaWildcardType copy() {
        return ModelUtils.copy(this);
    }

    public JavaType getExtendsBound() {
        return this.extendsBound;
    }

    public void setExtendsBound(JavaType value) {
        this.extendsBound = value;
    }

    public JavaType getSuperBound() {
        return this.superBound;
    }

    public void setSuperBound(JavaType value) {
        this.superBound = value;
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

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


