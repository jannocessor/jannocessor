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
import org.jannocessor.data.JavaCodeModelData;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.JavaElement;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaMetadataData extends JavaCodeModelData implements JavaMetadata {

	private static final long serialVersionUID = 1L;

    private JavaType annotation;

    private PowerMap<String,? extends Object> values;


    public JavaMetadata copy() {
        return ModelUtils.copy(this);
    }

    public JavaType getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(JavaType value) {
        this.annotation = value;
    }

    public PowerMap<String,? extends Object> getValues() {
        return this.values;
    }

    public void setValues(PowerMap<String,? extends Object> value) {
        this.values = value;
    }

    @Override
    public JavaElement getParent() {
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
		if (!(obj instanceof JavaMetadata)) {
			return false;
		}

		JavaMetadata other = (JavaMetadata) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getAnnotation(), other.getAnnotation())
				.append(this.getValues(), other.getValues())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getAnnotation())
				.append(this.getValues())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaMetadata.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("annotation", ToStringUtil.describe(this.getAnnotation()));
        builder.append("values", ToStringUtil.describe(this.getValues()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


