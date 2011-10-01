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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.AbstractJavaVariableProxy;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.data.JavaParameterData;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaParameterProxy extends AbstractJavaVariableProxy implements JavaParameter {

    private JavaParameter adapter;

    private JavaParameterData data;

    public JavaParameterProxy(JavaParameter adapter, JavaParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean isFinalInitialized = false;


    public boolean isFinal() {
        if (!isFinalInitialized) {
            data.setFinal(adapter.isFinal());
			isFinalInitialized = true;
        }

        return data.isFinal();
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
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.isFinal())
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
        builder.append("_isFinal", this.isFinal());
	}

}


