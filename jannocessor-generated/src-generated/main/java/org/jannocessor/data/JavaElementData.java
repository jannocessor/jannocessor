/**
 * Copyright 2011 jannocessor.org
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
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaElementData extends JavaCodeModelData implements JavaElement {

    private JavaElement parent;

    private PowerList<JavaElement> children;

    private Name name;

    private JavaType type;


    public JavaElement getParent() {
        return this.parent;
    }

    public void setParent(JavaElement value) {
        this.parent = value;
    }

    public PowerList<JavaElement> getChildren() {
        return this.children;
    }

    public void setChildren(PowerList<JavaElement> value) {
        this.children = value;
    }

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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaElement)) {
			return false;
		}

		JavaElement other = (JavaElement) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getChildren(), other.getChildren())
				.append(this.getName(), other.getName())
				.append(this.getType(), other.getType())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getChildren())
				.append(this.getName())
				.append(this.getType())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaElement.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("children", this.getChildren());
        builder.append("name", this.getName());
        builder.append("type", this.getType());
	}

}


