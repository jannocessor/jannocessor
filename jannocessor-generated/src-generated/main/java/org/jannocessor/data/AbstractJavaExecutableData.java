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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.executable.ExecutableBody;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaExecutableData extends JavaElementData implements AbstractJavaExecutable {

    private ExecutableBody body;


    public ExecutableBody getBody() {
        return this.body;
    }

    public void setBody(ExecutableBody value) {
        this.body = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaExecutable)) {
			return false;
		}

		AbstractJavaExecutable other = (AbstractJavaExecutable) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getBody(), other.getBody())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getBody())
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
        builder.append("body", this.getBody());
	}

}


