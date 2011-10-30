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
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.data.JavaPackageData;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaAnnotation;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class JavaPackageProxy extends JavaElementProxy implements JavaPackage {

	private static final long serialVersionUID = 1L;

    private transient JavaPackage adapter;

    private JavaPackageData data;

    public JavaPackageProxy(JavaPackage adapter, JavaPackageData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getInterfacesInitialized = false;

	private boolean getClassesInitialized = false;

	private boolean getEnumsInitialized = false;

	private boolean getAnnotationsInitialized = false;


	@Override
    public JavaPackage copy() {
        return ModelUtils.copy(this);
    }

	@Override
    public PowerList<JavaInterface> getInterfaces() {
        if (!getInterfacesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setInterfaces(ModelUtils.parentedList(adapter.getInterfaces(), this));
			getInterfacesInitialized = true;
        }

        return data.getInterfaces();
    }

	@Override
    public PowerList<JavaClass> getClasses() {
        if (!getClassesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setClasses(ModelUtils.parentedList(adapter.getClasses(), this));
			getClassesInitialized = true;
        }

        return data.getClasses();
    }

	@Override
    public PowerList<JavaEnum> getEnums() {
        if (!getEnumsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setEnums(ModelUtils.parentedList(adapter.getEnums(), this));
			getEnumsInitialized = true;
        }

        return data.getEnums();
    }

	@Override
    public PowerList<JavaAnnotation> getAnnotations() {
        if (!getAnnotationsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setAnnotations(ModelUtils.parentedList(adapter.getAnnotations(), this));
			getAnnotationsInitialized = true;
        }

        return data.getAnnotations();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaPackage)) {
			return false;
		}

		JavaPackage other = (JavaPackage) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getInterfaces(), other.getInterfaces())
				.append(this.getClasses(), other.getClasses())
				.append(this.getEnums(), other.getEnums())
				.append(this.getAnnotations(), other.getAnnotations())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getInterfaces())
				.append(this.getClasses())
				.append(this.getEnums())
				.append(this.getAnnotations())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(JavaPackage.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("interfaces", ToStringUtil.describe(this.getInterfaces()));
        builder.append("classes", ToStringUtil.describe(this.getClasses()));
        builder.append("enums", ToStringUtil.describe(this.getEnums()));
        builder.append("annotations", ToStringUtil.describe(this.getAnnotations()));
	}

	@Override
	protected void loadAllData() {
		super.loadAllData();

		// load all values from the adapter to the data bean
		this.getInterfaces();
		this.getClasses();
		this.getEnums();
		this.getAnnotations();
	}

}


