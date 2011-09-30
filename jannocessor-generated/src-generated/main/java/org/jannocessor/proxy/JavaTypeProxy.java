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
import org.jannocessor.proxy.JavaCodeModelProxy;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaExecutableType;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeProxy extends JavaCodeModelProxy implements JavaType {

    private JavaType adapter;

    private JavaTypeData data;

    public JavaTypeProxy(JavaType adapter, JavaTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeClassInitialized = false;

	private boolean getSimpleNameInitialized = false;

	private boolean getCanonicalNameInitialized = false;

	private boolean hasErrorInitialized = false;

	private boolean isVoidInitialized = false;

	private boolean isNullInitialized = false;

	private boolean isPrimitiveInitialized = false;

	private boolean isDeclaredInitialized = false;

	private boolean asDeclaredInitialized = false;

	private boolean isClassInitialized = false;

	private boolean asClassInitialized = false;

	private boolean isInterfaceInitialized = false;

	private boolean asInterfaceInitialized = false;

	private boolean isEnumInitialized = false;

	private boolean asEnumInitialized = false;

	private boolean isArrayInitialized = false;

	private boolean asArrayInitialized = false;

	private boolean isWildcardInitialized = false;

	private boolean asWildcardInitialized = false;

	private boolean isTypeVariableInitialized = false;

	private boolean asTypeVariableInitialized = false;

	private boolean isExecutableInitialized = false;

	private boolean asExecutableInitialized = false;


    public Class<?> getTypeClass() {
        if (!getTypeClassInitialized) {
            data.setTypeClass(adapter.getTypeClass());
			getTypeClassInitialized = true;
        }

        return data.getTypeClass();
    }

    public Name getSimpleName() {
        if (!getSimpleNameInitialized) {
            data.setSimpleName(adapter.getSimpleName());
			getSimpleNameInitialized = true;
        }

        return data.getSimpleName();
    }

    public Name getCanonicalName() {
        if (!getCanonicalNameInitialized) {
            data.setCanonicalName(adapter.getCanonicalName());
			getCanonicalNameInitialized = true;
        }

        return data.getCanonicalName();
    }

    public boolean hasError() {
        if (!hasErrorInitialized) {
            data.setError(adapter.hasError());
			hasErrorInitialized = true;
        }

        return data.hasError();
    }

    public boolean isVoid() {
        if (!isVoidInitialized) {
            data.setVoid(adapter.isVoid());
			isVoidInitialized = true;
        }

        return data.isVoid();
    }

    public boolean isNull() {
        if (!isNullInitialized) {
            data.setNull(adapter.isNull());
			isNullInitialized = true;
        }

        return data.isNull();
    }

    public boolean isPrimitive() {
        if (!isPrimitiveInitialized) {
            data.setPrimitive(adapter.isPrimitive());
			isPrimitiveInitialized = true;
        }

        return data.isPrimitive();
    }

    public boolean isDeclared() {
        if (!isDeclaredInitialized) {
            data.setDeclared(adapter.isDeclared());
			isDeclaredInitialized = true;
        }

        return data.isDeclared();
    }

    public JavaDeclaredType asDeclared() {
        if (!asDeclaredInitialized) {
            data.setDeclared(adapter.asDeclared());
			asDeclaredInitialized = true;
        }

        return data.asDeclared();
    }

    public boolean isClass() {
        if (!isClassInitialized) {
            data.setClass(adapter.isClass());
			isClassInitialized = true;
        }

        return data.isClass();
    }

    public JavaClass asClass() {
        if (!asClassInitialized) {
            data.setClass(adapter.asClass());
			asClassInitialized = true;
        }

        return data.asClass();
    }

    public boolean isInterface() {
        if (!isInterfaceInitialized) {
            data.setInterface(adapter.isInterface());
			isInterfaceInitialized = true;
        }

        return data.isInterface();
    }

    public JavaInterface asInterface() {
        if (!asInterfaceInitialized) {
            data.setInterface(adapter.asInterface());
			asInterfaceInitialized = true;
        }

        return data.asInterface();
    }

    public boolean isEnum() {
        if (!isEnumInitialized) {
            data.setEnum(adapter.isEnum());
			isEnumInitialized = true;
        }

        return data.isEnum();
    }

    public JavaEnum asEnum() {
        if (!asEnumInitialized) {
            data.setEnum(adapter.asEnum());
			asEnumInitialized = true;
        }

        return data.asEnum();
    }

    public boolean isArray() {
        if (!isArrayInitialized) {
            data.setArray(adapter.isArray());
			isArrayInitialized = true;
        }

        return data.isArray();
    }

    public JavaArrayType asArray() {
        if (!asArrayInitialized) {
            data.setArray(adapter.asArray());
			asArrayInitialized = true;
        }

        return data.asArray();
    }

    public boolean isWildcard() {
        if (!isWildcardInitialized) {
            data.setWildcard(adapter.isWildcard());
			isWildcardInitialized = true;
        }

        return data.isWildcard();
    }

    public JavaWildcardType asWildcard() {
        if (!asWildcardInitialized) {
            data.setWildcard(adapter.asWildcard());
			asWildcardInitialized = true;
        }

        return data.asWildcard();
    }

    public boolean isTypeVariable() {
        if (!isTypeVariableInitialized) {
            data.setTypeVariable(adapter.isTypeVariable());
			isTypeVariableInitialized = true;
        }

        return data.isTypeVariable();
    }

    public JavaTypeVariable asTypeVariable() {
        if (!asTypeVariableInitialized) {
            data.setTypeVariable(adapter.asTypeVariable());
			asTypeVariableInitialized = true;
        }

        return data.asTypeVariable();
    }

    public boolean isExecutable() {
        if (!isExecutableInitialized) {
            data.setExecutable(adapter.isExecutable());
			isExecutableInitialized = true;
        }

        return data.isExecutable();
    }

    public JavaExecutableType asExecutable() {
        if (!asExecutableInitialized) {
            data.setExecutable(adapter.asExecutable());
			asExecutableInitialized = true;
        }

        return data.asExecutable();
    }

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof JavaType)) {
			return false;
		}

		JavaType other = (JavaType) obj;
		return new EqualsBuilder()
				.appendSuper(super.equals(other))
				.append(this.getTypeClass(), other.getTypeClass())
				.append(this.getSimpleName(), other.getSimpleName())
				.append(this.getCanonicalName(), other.getCanonicalName())
				.append(this.hasError(), other.hasError())
				.append(this.isVoid(), other.isVoid())
				.append(this.isNull(), other.isNull())
				.append(this.isPrimitive(), other.isPrimitive())
				.append(this.isDeclared(), other.isDeclared())
				.append(this.asDeclared(), other.asDeclared())
				.append(this.isClass(), other.isClass())
				.append(this.asClass(), other.asClass())
				.append(this.isInterface(), other.isInterface())
				.append(this.asInterface(), other.asInterface())
				.append(this.isEnum(), other.isEnum())
				.append(this.asEnum(), other.asEnum())
				.append(this.isArray(), other.isArray())
				.append(this.asArray(), other.asArray())
				.append(this.isWildcard(), other.isWildcard())
				.append(this.asWildcard(), other.asWildcard())
				.append(this.isTypeVariable(), other.isTypeVariable())
				.append(this.asTypeVariable(), other.asTypeVariable())
				.append(this.isExecutable(), other.isExecutable())
				.append(this.asExecutable(), other.asExecutable())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(this.getTypeClass())
				.append(this.getSimpleName())
				.append(this.getCanonicalName())
				.append(this.hasError())
				.append(this.isVoid())
				.append(this.isNull())
				.append(this.isPrimitive())
				.append(this.isDeclared())
				.append(this.asDeclared())
				.append(this.isClass())
				.append(this.asClass())
				.append(this.isInterface())
				.append(this.asInterface())
				.append(this.isEnum())
				.append(this.asEnum())
				.append(this.isArray())
				.append(this.asArray())
				.append(this.isWildcard())
				.append(this.asWildcard())
				.append(this.isTypeVariable())
				.append(this.asTypeVariable())
				.append(this.isExecutable())
				.append(this.asExecutable())
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
        builder.append("typeClass", this.getTypeClass());
        builder.append("simpleName", this.getSimpleName());
        builder.append("canonicalName", this.getCanonicalName());
        builder.append("_hasError", this.hasError());
        builder.append("_isVoid", this.isVoid());
        builder.append("_isNull", this.isNull());
        builder.append("_isPrimitive", this.isPrimitive());
        builder.append("_isDeclared", this.isDeclared());
        builder.append("_asDeclared", this.asDeclared());
        builder.append("_isClass", this.isClass());
        builder.append("_asClass", this.asClass());
        builder.append("_isInterface", this.isInterface());
        builder.append("_asInterface", this.asInterface());
        builder.append("_isEnum", this.isEnum());
        builder.append("_asEnum", this.asEnum());
        builder.append("_isArray", this.isArray());
        builder.append("_asArray", this.asArray());
        builder.append("_isWildcard", this.isWildcard());
        builder.append("_asWildcard", this.asWildcard());
        builder.append("_isTypeVariable", this.isTypeVariable());
        builder.append("_asTypeVariable", this.asTypeVariable());
        builder.append("_isExecutable", this.isExecutable());
        builder.append("_asExecutable", this.asExecutable());
	}

}


