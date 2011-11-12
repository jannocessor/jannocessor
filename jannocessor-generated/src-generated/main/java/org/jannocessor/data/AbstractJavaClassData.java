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
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;
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
public class AbstractJavaClassData extends AbstractJavaStructureData implements AbstractJavaClass {

	private static final long serialVersionUID = 1L;

    private PowerList<JavaTypeParameter> typeParameters;

    private PowerList<JavaField> fields;

    private PowerList<JavaConstructor> constructors;

    private PowerList<JavaStaticInit> staticInits;

    private PowerList<JavaInstanceInit> instanceInits;


    public AbstractJavaClass copy() {
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

    public PowerList<JavaConstructor> getConstructors() {
        return this.constructors;
    }

    public void setConstructors(PowerList<JavaConstructor> value) {
        this.constructors = value;
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        return this.staticInits;
    }

    public void setStaticInits(PowerList<JavaStaticInit> value) {
        this.staticInits = value;
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        return this.instanceInits;
    }

    public void setInstanceInits(PowerList<JavaInstanceInit> value) {
        this.instanceInits = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaClass)) {
			return false;
		}

		AbstractJavaClass other = (AbstractJavaClass) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getFields(), other.getFields())
				.append(this.getConstructors(), other.getConstructors())
				.append(this.getStaticInits(), other.getStaticInits())
				.append(this.getInstanceInits(), other.getInstanceInits())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getFields())
				.append(this.getConstructors())
				.append(this.getStaticInits())
				.append(this.getInstanceInits())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaClass.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("fields", ToStringUtil.describe(this.getFields()));
        builder.append("constructors", ToStringUtil.describe(this.getConstructors()));
        builder.append("staticInits", ToStringUtil.describe(this.getStaticInits()));
        builder.append("instanceInits", ToStringUtil.describe(this.getInstanceInits()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


