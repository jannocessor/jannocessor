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
import org.jannocessor.model.type.JavaType;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaTypeKind;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeProxy extends JavaCodeModelProxy implements JavaType {

	private static final long serialVersionUID = 1L;

    private transient JavaType adapter;

    private JavaTypeData data;

    public JavaTypeProxy(JavaType adapter, JavaTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeClassInitialized = false;

	private boolean getSimpleNameInitialized = false;

	private boolean getPackageNameInitialized = false;

	private boolean getDefaultValueInitialized = false;

	private boolean getKindInitialized = false;


	@Override
    public JavaType copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public Class<?> getTypeClass() {
        if (!getTypeClassInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setTypeClass(adapter.getTypeClass());
			getTypeClassInitialized = true;
        }

        return data.getTypeClass();
    }

	@Override
    public Name getSimpleName() {
        if (!getSimpleNameInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setSimpleName(adapter.getSimpleName());
			getSimpleNameInitialized = true;
        }

        return data.getSimpleName();
    }

	@Override
    public Name getPackageName() {
        if (!getPackageNameInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setPackageName(adapter.getPackageName());
			getPackageNameInitialized = true;
        }

        return data.getPackageName();
    }

	@Override
    public String getCanonicalName() {
        return ModelUtils.getCanonicalName(this);
    }

	@Override
    public Object getDefaultValue() {
        if (!getDefaultValueInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setDefaultValue(adapter.getDefaultValue());
			getDefaultValueInitialized = true;
        }

        return data.getDefaultValue();
    }

	@Override
    public JavaTypeKind getKind() {
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

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getTypeClass();
		this.getSimpleName();
		this.getPackageName();
		this.getDefaultValue();
		this.getKind();
	}

}


