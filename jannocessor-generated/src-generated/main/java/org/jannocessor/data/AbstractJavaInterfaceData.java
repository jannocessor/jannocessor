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
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.AbstractJavaInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.util.ToStringUtil;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaInterfaceData extends AbstractJavaStructureData implements AbstractJavaInterface {

    private PowerList<JavaTypeParameter> typeParameters;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaInterface)) {
			return false;
		}

		AbstractJavaInterface other = (AbstractJavaInterface) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaInterface.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
	}

}


