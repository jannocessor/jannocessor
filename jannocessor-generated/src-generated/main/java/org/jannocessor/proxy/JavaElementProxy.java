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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaCodeModelProxy;
import org.jannocessor.model.JavaElement;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


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
				.append(this.getParent(), other.getParent())
				.append(this.getChildren(), other.getChildren())
				.append(this.getName(), other.getName())
				.append(this.getType(), other.getType())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getParent())
				.append(this.getChildren())
				.append(this.getName())
				.append(this.getType())
				.toHashCode();
	}


	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("parent", this.getParent());
        builder.append("children", this.getChildren());
        builder.append("name", this.getName());
        builder.append("type", this.getType());
	}

}


