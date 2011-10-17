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
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.ToStringUtil;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class JavaDeclaredTypeData extends JavaTypeData implements JavaDeclaredType {

    private PowerList<JavaType> parameters;


    public PowerList<JavaType> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaType> value) {
        this.parameters = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaDeclaredType)) {
			return false;
		}

		JavaDeclaredType other = (JavaDeclaredType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getParameters(), other.getParameters())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getParameters())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaDeclaredType.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("parameters", ToStringUtil.describe(this.getParameters()));
	}

}


