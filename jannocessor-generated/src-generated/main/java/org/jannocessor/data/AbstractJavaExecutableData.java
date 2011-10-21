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
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.code.JavaBody;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaExecutableData extends JavaElementData implements AbstractJavaExecutable {

	private static final long serialVersionUID = 1L;

    private JavaBody body;


    public JavaBody getBody() {
        return this.body;
    }

    public void setBody(JavaBody value) {
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
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaExecutable.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("body", ToStringUtil.describe(this.getBody()));
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException,
			ClassNotFoundException {
		in.defaultReadObject();
	}

}


