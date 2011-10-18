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
import org.jannocessor.proxy.AbstractJavaVariableProxy;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.data.JavaLocalVariableData;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaLocalVariableProxy extends AbstractJavaVariableProxy implements JavaLocalVariable {

    private JavaLocalVariable adapter;

    private JavaLocalVariableData data;

    public JavaLocalVariableProxy(JavaLocalVariable adapter, JavaLocalVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean isFinalInitialized = false;


    public Boolean isFinal() {
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
		if (!(obj instanceof JavaLocalVariable)) {
			return false;
		}

		JavaLocalVariable other = (JavaLocalVariable) obj;
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
		TypeSpecificStyle style = new TypeSpecificStyle(JavaLocalVariable.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("_isFinal", ToStringUtil.describe(this.isFinal()));
	}

}


