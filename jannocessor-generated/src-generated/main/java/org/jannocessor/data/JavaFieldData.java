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
import org.jannocessor.data.AbstractJavaVariableData;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaMetadata;
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
public class JavaFieldData extends AbstractJavaVariableData implements JavaField {

	private static final long serialVersionUID = 1L;

    private FieldModifiers modifiers;

    private JavaExpression value;

    private PowerList<JavaMetadata> metadata;


    public JavaField copy() {
        return ModelUtils.copy(this);
    }

    public FieldModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(FieldModifiers value) {
        this.modifiers = value;
    }

    public JavaExpression getValue() {
        return this.value;
    }

    public void setValue(JavaExpression value) {
        this.value = value;
    }

    public PowerList<JavaMetadata> getMetadata() {
        return this.metadata;
    }

    public void setMetadata(PowerList<JavaMetadata> value) {
        this.metadata = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaField)) {
			return false;
		}

		JavaField other = (JavaField) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getModifiers(), other.getModifiers())
				.append(this.getValue(), other.getValue())
				.append(this.getMetadata(), other.getMetadata())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getModifiers())
				.append(this.getValue())
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaField.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("modifiers", ToStringUtil.describe(this.getModifiers()));
        builder.append("value", ToStringUtil.describe(this.getValue()));
        builder.append("metadata", ToStringUtil.describe(this.getMetadata()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


