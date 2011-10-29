/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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


