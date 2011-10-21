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
import org.jannocessor.proxy.JavaCodeModelProxy;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.ParentedElement;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.collection.api.PowerList;
import org.apache.commons.lang.NotImplementedException;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.JavaElementKind;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaElementProxy extends JavaCodeModelProxy implements JavaElement, ParentedElement {

	private static final long serialVersionUID = 1L;

    private transient JavaElement adapter;

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



	private JavaElement parent;

	private boolean hasOriginalParent = true;

	@Override
	public void setParent(JavaElement parent) {
		this.parent = parent;
		hasOriginalParent = false;
	}

	@Override
	public JavaElement getParent() {
		if (hasOriginalParent) {
			return adapter.getParent();
		} else {
			return parent;
		}
	}


	@Override
    public PowerList<JavaElement> getChildren() {
        throw new NotImplementedException();
    }

	@Override
    public Name getName() {
        if (!getNameInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

	@Override
    public JavaType getType() {
        if (!getTypeInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setType(adapter.getType());
			getTypeInitialized = true;
        }

        return data.getType();
    }

	@Override
    public JavaElementKind getKind() {
        if (!getKindInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
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


