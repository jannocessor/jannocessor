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
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaAnnotation;
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
public class JavaPackageData extends JavaElementData implements JavaPackage {

	private static final long serialVersionUID = 1L;

    private PowerList<JavaInterface> interfaces;

    private PowerList<JavaClass> classes;

    private PowerList<JavaEnum> enums;

    private PowerList<JavaAnnotation> annotations;


    public JavaPackage copy() {
        return ModelUtils.copy(this);
    }

    public PowerList<JavaInterface> getInterfaces() {
        return this.interfaces;
    }

    public void setInterfaces(PowerList<JavaInterface> value) {
        this.interfaces = value;
    }

    public PowerList<JavaClass> getClasses() {
        return this.classes;
    }

    public void setClasses(PowerList<JavaClass> value) {
        this.classes = value;
    }

    public PowerList<JavaEnum> getEnums() {
        return this.enums;
    }

    public void setEnums(PowerList<JavaEnum> value) {
        this.enums = value;
    }

    public PowerList<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    public void setAnnotations(PowerList<JavaAnnotation> value) {
        this.annotations = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaPackage)) {
			return false;
		}

		JavaPackage other = (JavaPackage) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getInterfaces(), other.getInterfaces())
				.append(this.getClasses(), other.getClasses())
				.append(this.getEnums(), other.getEnums())
				.append(this.getAnnotations(), other.getAnnotations())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getInterfaces())
				.append(this.getClasses())
				.append(this.getEnums())
				.append(this.getAnnotations())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaPackage.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("interfaces", ToStringUtil.describe(this.getInterfaces()));
        builder.append("classes", ToStringUtil.describe(this.getClasses()));
        builder.append("enums", ToStringUtil.describe(this.getEnums()));
        builder.append("annotations", ToStringUtil.describe(this.getAnnotations()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


