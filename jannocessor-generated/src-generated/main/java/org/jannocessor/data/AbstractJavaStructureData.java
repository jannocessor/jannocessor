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
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.util.TypeSpecificStyle;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.util.ToStringUtil;


@Generated("JAnnocessor-bootstraped")
public class AbstractJavaStructureData extends JavaElementData implements AbstractJavaStructure {

    private String nesting;

    private Name packageName;

    private Name qualifiedName;

    private JavaType superclass;

    private PowerList<JavaMetadata> metadata;

    private PowerList<JavaMetadata> allMetadata;

    private PowerList<JavaType> interfaces;

    private PowerList<JavaMethod> methods;

    private PowerList<JavaNestedClass> nestedClasses;

    private PowerList<JavaNestedEnum> nestedEnums;

    private PowerList<JavaNestedInterface> nestedInterfaces;

    private PowerList<JavaNestedAnnotation> nestedAnnotations;


    public String getNesting() {
        return this.nesting;
    }

    public void setNesting(String value) {
        this.nesting = value;
    }

    public Name getPackageName() {
        return this.packageName;
    }

    public void setPackageName(Name value) {
        this.packageName = value;
    }

    public Name getQualifiedName() {
        return this.qualifiedName;
    }

    public void setQualifiedName(Name value) {
        this.qualifiedName = value;
    }

    public JavaType getSuperclass() {
        return this.superclass;
    }

    public void setSuperclass(JavaType value) {
        this.superclass = value;
    }

    public PowerList<JavaMetadata> getMetadata() {
        return this.metadata;
    }

    public void setMetadata(PowerList<JavaMetadata> value) {
        this.metadata = value;
    }

    public PowerList<JavaMetadata> getAllMetadata() {
        return this.allMetadata;
    }

    public void setAllMetadata(PowerList<JavaMetadata> value) {
        this.allMetadata = value;
    }

    public PowerList<JavaType> getInterfaces() {
        return this.interfaces;
    }

    public void setInterfaces(PowerList<JavaType> value) {
        this.interfaces = value;
    }

    public PowerList<JavaMethod> getMethods() {
        return this.methods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this.methods = value;
    }

    public PowerList<JavaNestedClass> getNestedClasses() {
        return this.nestedClasses;
    }

    public void setNestedClasses(PowerList<JavaNestedClass> value) {
        this.nestedClasses = value;
    }

    public PowerList<JavaNestedEnum> getNestedEnums() {
        return this.nestedEnums;
    }

    public void setNestedEnums(PowerList<JavaNestedEnum> value) {
        this.nestedEnums = value;
    }

    public PowerList<JavaNestedInterface> getNestedInterfaces() {
        return this.nestedInterfaces;
    }

    public void setNestedInterfaces(PowerList<JavaNestedInterface> value) {
        this.nestedInterfaces = value;
    }

    public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
        return this.nestedAnnotations;
    }

    public void setNestedAnnotations(PowerList<JavaNestedAnnotation> value) {
        this.nestedAnnotations = value;
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof AbstractJavaStructure)) {
			return false;
		}

		AbstractJavaStructure other = (AbstractJavaStructure) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getNesting(), other.getNesting())
				.append(this.getPackageName(), other.getPackageName())
				.append(this.getQualifiedName(), other.getQualifiedName())
				.append(this.getSuperclass(), other.getSuperclass())
				.append(this.getMetadata(), other.getMetadata())
				.append(this.getAllMetadata(), other.getAllMetadata())
				.append(this.getInterfaces(), other.getInterfaces())
				.append(this.getMethods(), other.getMethods())
				.append(this.getNestedClasses(), other.getNestedClasses())
				.append(this.getNestedEnums(), other.getNestedEnums())
				.append(this.getNestedInterfaces(), other.getNestedInterfaces())
				.append(this.getNestedAnnotations(), other.getNestedAnnotations())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getNesting())
				.append(this.getPackageName())
				.append(this.getQualifiedName())
				.append(this.getSuperclass())
				.append(this.getMetadata())
				.append(this.getAllMetadata())
				.append(this.getInterfaces())
				.append(this.getMethods())
				.append(this.getNestedClasses())
				.append(this.getNestedEnums())
				.append(this.getNestedInterfaces())
				.append(this.getNestedAnnotations())
				.toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(AbstractJavaStructure.class);
		ToStringBuilder builder = new ToStringBuilder(this, style);
		appendDescription(builder);
		return builder.toString();
	}

	@Override
	protected void appendDescription(ToStringBuilder builder) {
        super.appendDescription(builder);
        builder.append("nesting", ToStringUtil.describe(this.getNesting()));
        builder.append("packageName", ToStringUtil.describe(this.getPackageName()));
        builder.append("qualifiedName", ToStringUtil.describe(this.getQualifiedName()));
        builder.append("superclass", ToStringUtil.describe(this.getSuperclass()));
        builder.append("metadata", ToStringUtil.describe(this.getMetadata()));
        builder.append("allMetadata", ToStringUtil.describe(this.getAllMetadata()));
        builder.append("interfaces", ToStringUtil.describe(this.getInterfaces()));
        builder.append("methods", ToStringUtil.describe(this.getMethods()));
        builder.append("nestedClasses", ToStringUtil.describe(this.getNestedClasses()));
        builder.append("nestedEnums", ToStringUtil.describe(this.getNestedEnums()));
        builder.append("nestedInterfaces", ToStringUtil.describe(this.getNestedInterfaces()));
        builder.append("nestedAnnotations", ToStringUtil.describe(this.getNestedAnnotations()));
	}

}


