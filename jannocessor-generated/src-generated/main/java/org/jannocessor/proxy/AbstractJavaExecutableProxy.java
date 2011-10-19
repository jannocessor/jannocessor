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
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.data.AbstractJavaExecutableData;
import org.jannocessor.model.code.JavaBody;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaExecutableProxy extends JavaElementProxy implements AbstractJavaExecutable {

    private AbstractJavaExecutable adapter;

    private AbstractJavaExecutableData data;

    public AbstractJavaExecutableProxy(AbstractJavaExecutable adapter, AbstractJavaExecutableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getBodyInitialized = false;


    public JavaBody getBody() {
        if (!getBodyInitialized) {
            data.setBody(adapter.getBody());
			getBodyInitialized = true;
        }

        return data.getBody();
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

}


