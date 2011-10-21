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
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.data.JavaMetadataData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerMap;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;

@Generated("JAnnocessor-bootstraped")
public class JavaMetadataProxy extends JavaElementProxy implements JavaMetadata {

	private static final long serialVersionUID = 1L;

	private transient JavaMetadata adapter;

	private JavaMetadataData data;

	public JavaMetadataProxy(JavaMetadata adapter, JavaMetadataData data) {
		super(adapter, data);
		this.adapter = adapter;
		this.data = data;
	}

	private boolean getAnnotationInitialized = false;

	private boolean getValuesInitialized = false;

	private boolean getValuesWithDefaultsInitialized = false;

	public JavaType getAnnotation() {
		if (!getAnnotationInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
			data.setAnnotation(adapter.getAnnotation());
			getAnnotationInitialized = true;
		}

		return data.getAnnotation();
	}

	public PowerMap<String, ? extends Object> getValues() {
		if (!getValuesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
			data.setValues(adapter.getValues());
			getValuesInitialized = true;
		}

		return data.getValues();
	}

	public PowerMap<String, ? extends Object> getValuesWithDefaults() {
		if (!getValuesWithDefaultsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
			data.setValuesWithDefaults(adapter.getValuesWithDefaults());
			getValuesWithDefaultsInitialized = true;
		}

		return data.getValuesWithDefaults();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaMetadata)) {
			return false;
		}

		JavaMetadata other = (JavaMetadata) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getAnnotation(), other.getAnnotation())
				.append(this.getValues(), other.getValues())
				.append(this.getValuesWithDefaults(),
						other.getValuesWithDefaults()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(this.getAnnotation())
				.append(this.getValues()).append(this.getValuesWithDefaults())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaMetadata.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
		super.appendDescription(builder);
		builder.append("annotation",
				ToStringUtil.describe(this.getAnnotation()));
		builder.append("values", ToStringUtil.describe(this.getValues()));
		builder.append("valuesWithDefaults",
				ToStringUtil.describe(this.getValuesWithDefaults()));
	}

}
