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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ToStringUtil;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class JavaAnnotationAttributeData extends JavaCodeModelData implements JavaAnnotationAttribute {

    private Name name;

    private JavaType type;

    private Object defaultValue;


    public Name getName() {
        return this.name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public JavaType getType() {
        return this.type;
    }

    public void setType(JavaType value) {
        this.type = value;
    }

    public Object getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(Object value) {
        this.defaultValue = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaAnnotationAttribute)) {
			return false;
		}

		JavaAnnotationAttribute other = (JavaAnnotationAttribute) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getName(), other.getName())
				.append(this.getType(), other.getType())
				.append(this.getDefaultValue(), other.getDefaultValue())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getName())
				.append(this.getType())
				.append(this.getDefaultValue())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaAnnotationAttribute.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("name", ToStringUtil.describe(this.getName()));
        builder.append("type", ToStringUtil.describe(this.getType()));
        builder.append("defaultValue", ToStringUtil.describe(this.getDefaultValue()));
	}

}


