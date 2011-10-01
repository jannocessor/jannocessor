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
import org.jannocessor.proxy.AbstractJavaStructureProxy;
import org.jannocessor.model.structure.AbstractJavaInterface;
import org.jannocessor.data.AbstractJavaInterfaceData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.executable.JavaMethod;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaInterfaceProxy extends AbstractJavaStructureProxy implements AbstractJavaInterface {

    private AbstractJavaInterface adapter;

    private AbstractJavaInterfaceData data;

    public AbstractJavaInterfaceProxy(AbstractJavaInterface adapter, AbstractJavaInterfaceData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParametersInitialized = false;

	private boolean getMethodsInitialized = false;


    public PowerList<JavaTypeParameter> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }

    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
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
				.append(this.getParameters(), other.getParameters())
				.append(this.getMethods(), other.getMethods())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getParameters())
				.append(this.getMethods())
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
        builder.append("parameters", this.getParameters());
        builder.append("methods", this.getMethods());
	}

}


