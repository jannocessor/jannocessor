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
import org.jannocessor.model.variable.JavaParameter;
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
public class JavaParameterData extends AbstractJavaVariableData implements JavaParameter {

	private static final long serialVersionUID = 1L;

    private boolean _isFinal;

    private PowerList<JavaMetadata> metadata;


    public JavaParameter copy() {
        return ModelUtils.copy(this);
    }

    public boolean isFinal() {
        return this._isFinal;
    }

    public void setFinal(boolean value) {
        this._isFinal = value;
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
		if (!(obj instanceof JavaParameter)) {
			return false;
		}

		JavaParameter other = (JavaParameter) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.isFinal(), other.isFinal())
				.append(this.getMetadata(), other.getMetadata())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.isFinal())
				.append(this.getMetadata())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaParameter.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("_isFinal", ToStringUtil.describe(this.isFinal()));
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


