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
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.JavaElement;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class JavaMetadataData extends JavaCodeModelData implements JavaMetadata {

	private static final long serialVersionUID = 1L;

    private JavaType annotation;

    private PowerMap<String,? extends Object> values;

    private PowerMap<String,? extends Object> valuesWithDefaults;

    public JavaMetadata copy() {
        return ModelUtils.copy(this);
    }

    public JavaType getAnnotation() {
        return this.annotation;
    }

    public void setAnnotation(JavaType value) {
        this.annotation = value;
    }

    public PowerMap<String,? extends Object> getValues() {
        return this.values;
    }

    public void setValues(PowerMap<String,? extends Object> value) {
        this.values = value;
    }

    public PowerMap<String,? extends Object> getValuesWithDefaults() {
        return this.valuesWithDefaults;
    }

    public void setValuesWithDefaults(PowerMap<String,? extends Object> value) {
        this.valuesWithDefaults = value;
    }

    @Override
    public JavaElement getParent() {
        return super.retrieveParent();
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
				.append(this.getValuesWithDefaults(), other.getValuesWithDefaults())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getAnnotation())
				.append(this.getValues())
				.append(this.getValuesWithDefaults())
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
        builder.append("annotation", ToStringUtil.describe(this.getAnnotation()));
        builder.append("values", ToStringUtil.describe(this.getValues()));
        builder.append("valuesWithDefaults", ToStringUtil.describe(this.getValuesWithDefaults()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


