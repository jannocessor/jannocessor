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
import org.jannocessor.data.JavaCodeModelData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaTypeKind;
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
public class JavaTypeData extends JavaCodeModelData implements JavaType {

	private static final long serialVersionUID = 1L;

    private Class<?> typeClass;

    private Name simpleName;

    private Name packageName;

    private Object defaultValue;

    private JavaTypeKind kind;


    public JavaType copy() {
        return ModelUtils.copy(this);
    }

    public Class<?> getTypeClass() {
        return this.typeClass;
    }

    public void setTypeClass(Class<?> value) {
        this.typeClass = value;
    }

    public Name getSimpleName() {
        return this.simpleName;
    }

    public void setSimpleName(Name value) {
        this.simpleName = value;
    }

    public Name getPackageName() {
        return this.packageName;
    }

    public void setPackageName(Name value) {
        this.packageName = value;
    }

    public String getCanonicalName() {
        return ModelUtils.getCanonicalName(this);
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(Object value) {
        this.defaultValue = value;
    }

    public JavaTypeKind getKind() {
        return this.kind;
    }

    public void setKind(JavaTypeKind value) {
        this.kind = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaType)) {
			return false;
		}

		JavaType other = (JavaType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeClass(), other.getTypeClass())
				.append(this.getSimpleName(), other.getSimpleName())
				.append(this.getPackageName(), other.getPackageName())
				.append(this.getCanonicalName(), other.getCanonicalName())
				.append(this.getDefaultValue(), other.getDefaultValue())
				.append(this.getKind(), other.getKind())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeClass())
				.append(this.getSimpleName())
				.append(this.getPackageName())
				.append(this.getCanonicalName())
				.append(this.getDefaultValue())
				.append(this.getKind())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaType.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeClass", ToStringUtil.describe(this.getTypeClass()));
        builder.append("simpleName", ToStringUtil.describe(this.getSimpleName()));
        builder.append("packageName", ToStringUtil.describe(this.getPackageName()));
        builder.append("canonicalName", ToStringUtil.describe(this.getCanonicalName()));
        builder.append("defaultValue", ToStringUtil.describe(this.getDefaultValue()));
        builder.append("kind", ToStringUtil.describe(this.getKind()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


