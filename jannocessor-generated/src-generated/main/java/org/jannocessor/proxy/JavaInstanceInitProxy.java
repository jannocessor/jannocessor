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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.data.JavaInstanceInitData;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class JavaInstanceInitProxy extends AbstractJavaExecutableProxy implements JavaInstanceInit {

    @SuppressWarnings("unused")
    private JavaInstanceInit adapter;

    @SuppressWarnings("unused")
    private JavaInstanceInitData data;

    public JavaInstanceInitProxy(JavaInstanceInit adapter, JavaInstanceInitData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaInstanceInit)) {
			return false;
		}

		JavaInstanceInit other = (JavaInstanceInit) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaInstanceInit.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
	}

}


