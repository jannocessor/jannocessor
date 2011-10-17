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
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.data.AbstractJavaClassData;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.util.ToStringUtil;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.util.TypeSpecificStyle;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaClassProxy extends AbstractJavaStructureProxy implements AbstractJavaClass {

    private AbstractJavaClass adapter;

    private AbstractJavaClassData data;

    public AbstractJavaClassProxy(AbstractJavaClass adapter, AbstractJavaClassData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

	private boolean getFieldsInitialized = false;

	private boolean getConstructorsInitialized = false;

	private boolean getStaticInitsInitialized = false;

	private boolean getInstanceInitsInitialized = false;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        if (!getTypeParametersInitialized) {
            data.setTypeParameters(adapter.getTypeParameters());
			getTypeParametersInitialized = true;
        }

        return data.getTypeParameters();
    }

    public PowerList<JavaField> getFields() {
        if (!getFieldsInitialized) {
            data.setFields(adapter.getFields());
			getFieldsInitialized = true;
        }

        return data.getFields();
    }

    public PowerList<JavaConstructor> getConstructors() {
        if (!getConstructorsInitialized) {
            data.setConstructors(adapter.getConstructors());
			getConstructorsInitialized = true;
        }

        return data.getConstructors();
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        if (!getStaticInitsInitialized) {
            data.setStaticInits(adapter.getStaticInits());
			getStaticInitsInitialized = true;
        }

        return data.getStaticInits();
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        if (!getInstanceInitsInitialized) {
            data.setInstanceInits(adapter.getInstanceInits());
			getInstanceInitsInitialized = true;
        }

        return data.getInstanceInits();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaClass)) {
			return false;
		}

		AbstractJavaClass other = (AbstractJavaClass) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeParameters(), other.getTypeParameters())
				.append(this.getFields(), other.getFields())
				.append(this.getConstructors(), other.getConstructors())
				.append(this.getStaticInits(), other.getStaticInits())
				.append(this.getInstanceInits(), other.getInstanceInits())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeParameters())
				.append(this.getFields())
				.append(this.getConstructors())
				.append(this.getStaticInits())
				.append(this.getInstanceInits())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaClass.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("typeParameters", ToStringUtil.describe(this.getTypeParameters()));
        builder.append("fields", ToStringUtil.describe(this.getFields()));
        builder.append("constructors", ToStringUtil.describe(this.getConstructors()));
        builder.append("staticInits", ToStringUtil.describe(this.getStaticInits()));
        builder.append("instanceInits", ToStringUtil.describe(this.getInstanceInits()));
	}

}


