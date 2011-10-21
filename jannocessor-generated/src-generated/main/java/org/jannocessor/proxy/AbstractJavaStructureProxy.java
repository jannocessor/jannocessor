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
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.data.AbstractJavaStructureData;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.ModelUtils;
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
public class AbstractJavaStructureProxy extends JavaElementProxy implements AbstractJavaStructure {

    private transient AbstractJavaStructure adapter;

    private AbstractJavaStructureData data;

    public AbstractJavaStructureProxy(AbstractJavaStructure adapter, AbstractJavaStructureData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNestingInitialized = false;

	private boolean getPackageNameInitialized = false;

	private boolean getQualifiedNameInitialized = false;

	private boolean getSuperclassInitialized = false;

	private boolean getMetadataInitialized = false;

	private boolean getAllMetadataInitialized = false;

	private boolean getInterfacesInitialized = false;

	private boolean getMethodsInitialized = false;

	private boolean getNestedClassesInitialized = false;

	private boolean getNestedEnumsInitialized = false;

	private boolean getNestedInterfacesInitialized = false;

	private boolean getNestedAnnotationsInitialized = false;


    public String getNesting() {
        if (!getNestingInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setNesting(adapter.getNesting());
			getNestingInitialized = true;
        }

        return data.getNesting();
    }

    public Name getPackageName() {
        if (!getPackageNameInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setPackageName(adapter.getPackageName());
			getPackageNameInitialized = true;
        }

        return data.getPackageName();
    }

    public Name getQualifiedName() {
        if (!getQualifiedNameInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setQualifiedName(adapter.getQualifiedName());
			getQualifiedNameInitialized = true;
        }

        return data.getQualifiedName();
    }

    public JavaType getSuperclass() {
        if (!getSuperclassInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setSuperclass(adapter.getSuperclass());
			getSuperclassInitialized = true;
        }

        return data.getSuperclass();
    }

    public PowerList<JavaMetadata> getMetadata() {
        if (!getMetadataInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setMetadata(ModelUtils.parentedList(adapter.getMetadata(), this));
			getMetadataInitialized = true;
        }

        return data.getMetadata();
    }

    public PowerList<JavaMetadata> getAllMetadata() {
        if (!getAllMetadataInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setAllMetadata(ModelUtils.parentedList(adapter.getAllMetadata(), this));
			getAllMetadataInitialized = true;
        }

        return data.getAllMetadata();
    }

    public PowerList<JavaType> getInterfaces() {
        if (!getInterfacesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setInterfaces(ModelUtils.parentedList(adapter.getInterfaces(), this));
			getInterfacesInitialized = true;
        }

        return data.getInterfaces();
    }

    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setMethods(ModelUtils.parentedList(adapter.getMethods(), this));
			getMethodsInitialized = true;
        }

        return data.getMethods();
    }

    public PowerList<JavaNestedClass> getNestedClasses() {
        if (!getNestedClassesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setNestedClasses(ModelUtils.parentedList(adapter.getNestedClasses(), this));
			getNestedClassesInitialized = true;
        }

        return data.getNestedClasses();
    }

    public PowerList<JavaNestedEnum> getNestedEnums() {
        if (!getNestedEnumsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setNestedEnums(ModelUtils.parentedList(adapter.getNestedEnums(), this));
			getNestedEnumsInitialized = true;
        }

        return data.getNestedEnums();
    }

    public PowerList<JavaNestedInterface> getNestedInterfaces() {
        if (!getNestedInterfacesInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setNestedInterfaces(ModelUtils.parentedList(adapter.getNestedInterfaces(), this));
			getNestedInterfacesInitialized = true;
        }

        return data.getNestedInterfaces();
    }

    public PowerList<JavaNestedAnnotation> getNestedAnnotations() {
        if (!getNestedAnnotationsInitialized) {
			if (adapter == null) {
				throw new IllegalStateException("Invalid model copy!");
			}
            data.setNestedAnnotations(ModelUtils.parentedList(adapter.getNestedAnnotations(), this));
			getNestedAnnotationsInitialized = true;
        }

        return data.getNestedAnnotations();
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


