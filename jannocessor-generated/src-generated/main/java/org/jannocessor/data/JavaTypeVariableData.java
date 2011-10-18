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
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeVariableData extends JavaTypeData implements JavaTypeVariable {

    private JavaType upperBound;

    private JavaType lowerBound;


    public JavaType getUpperBound() {
        return this.upperBound;
    }

    public void setUpperBound(JavaType value) {
        this.upperBound = value;
    }

    public JavaType getLowerBound() {
        return this.lowerBound;
    }

    public void setLowerBound(JavaType value) {
        this.lowerBound = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaTypeVariable)) {
			return false;
		}

		JavaTypeVariable other = (JavaTypeVariable) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getUpperBound(), other.getUpperBound())
				.append(this.getLowerBound(), other.getLowerBound())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getUpperBound())
				.append(this.getLowerBound())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaTypeVariable.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("upperBound", ToStringUtil.describe(this.getUpperBound()));
        builder.append("lowerBound", ToStringUtil.describe(this.getLowerBound()));
	}

}


