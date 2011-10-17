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

package org.jannocessor.proxy;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ToStringUtil;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class JavaElementProxy extends JavaCodeModelProxy implements JavaElement {

    private JavaElement adapter;

    private JavaElementData data;

    public JavaElementProxy(JavaElement adapter, JavaElementData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParentInitialized = false;

	private boolean getChildrenInitialized = false;

	private boolean getNameInitialized = false;

	private boolean getTypeInitialized = false;

	private boolean getKindInitialized = false;


    public JavaElement getParent() {
        if (!getParentInitialized) {
            data.setParent(adapter.getParent());
			getParentInitialized = true;
        }

        return data.getParent();
    }

    public PowerList<JavaElement> getChildren() {
        if (!getChildrenInitialized) {
            data.setChildren(adapter.getChildren());
			getChildrenInitialized = true;
        }

        return data.getChildren();
    }

    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

    public JavaType getType() {
        if (!getTypeInitialized) {
            data.setType(adapter.getType());
			getTypeInitialized = true;
        }

        return data.getType();
    }

    public JavaElementKind getKind() {
        if (!getKindInitialized) {
            data.setKind(adapter.getKind());
			getKindInitialized = true;
        }

        return data.getKind();
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
				.append(this.getKind(), other.getKind())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getChildren())
				.append(this.getName())
				.append(this.getType())
				.append(this.getKind())
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
        builder.append("children", ToStringUtil.describe(this.getChildren()));
        builder.append("name", ToStringUtil.describe(this.getName()));
        builder.append("type", ToStringUtil.describe(this.getType()));
        builder.append("kind", ToStringUtil.describe(this.getKind()));
	}

}


