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

package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaCodeModelData;
import org.jannocessor.model.type.JavaType;
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
public class JavaTypeData extends JavaCodeModelData implements JavaType {

    private Class<?> typeClass;

    private Name simpleName;

    private Name canonicalName;

    private boolean _hasError;

    private boolean _isVoid;

    private boolean _isNull;

    private boolean _isPrimitive;

    private boolean _isDeclared;

    private JavaDeclaredType _asDeclared;

    private boolean _isClass;

    private JavaClass _asClass;

    private boolean _isInterface;

    private JavaInterface _asInterface;

    private boolean _isEnum;

    private JavaEnum _asEnum;

    private boolean _isArray;

    private JavaArrayType _asArray;

    private boolean _isWildcard;

    private JavaWildcardType _asWildcard;

    private boolean _isTypeVariable;

    private JavaTypeVariable _asTypeVariable;

    private boolean _isExecutable;

    private JavaExecutableType _asExecutable;


    public Class<?> getTypeClass() {
        return this.typeClass;
    }

    public void setTypeClass(Class<?> value) {
        this.typeClass = value;
    }

    public Name getSimpleName() {
        return this.simpleName;
    }

    public void setSimpleName(Name value) {
        this.simpleName = value;
    }

    public Name getCanonicalName() {
        return this.canonicalName;
    }

    public void setCanonicalName(Name value) {
        this.canonicalName = value;
    }

    public boolean hasError() {
        return this._hasError;
    }

    public void setError(boolean value) {
        this._hasError = value;
    }

    public boolean isVoid() {
        return this._isVoid;
    }

    public void setVoid(boolean value) {
        this._isVoid = value;
    }

    public boolean isNull() {
        return this._isNull;
    }

    public void setNull(boolean value) {
        this._isNull = value;
    }

    public boolean isPrimitive() {
        return this._isPrimitive;
    }

    public void setPrimitive(boolean value) {
        this._isPrimitive = value;
    }

    public boolean isDeclared() {
        return this._isDeclared;
    }

    public void setDeclared(boolean value) {
        this._isDeclared = value;
    }

    public JavaDeclaredType asDeclared() {
        return this._asDeclared;
    }

    public void setDeclared(JavaDeclaredType value) {
        this._asDeclared = value;
    }

    public boolean isClass() {
        return this._isClass;
    }

    public void setClass(boolean value) {
        this._isClass = value;
    }

    public JavaClass asClass() {
        return this._asClass;
    }

    public void setClass(JavaClass value) {
        this._asClass = value;
    }

    public boolean isInterface() {
        return this._isInterface;
    }

    public void setInterface(boolean value) {
        this._isInterface = value;
    }

    public JavaInterface asInterface() {
        return this._asInterface;
    }

    public void setInterface(JavaInterface value) {
        this._asInterface = value;
    }

    public boolean isEnum() {
        return this._isEnum;
    }

    public void setEnum(boolean value) {
        this._isEnum = value;
    }

    public JavaEnum asEnum() {
        return this._asEnum;
    }

    public void setEnum(JavaEnum value) {
        this._asEnum = value;
    }

    public boolean isArray() {
        return this._isArray;
    }

    public void setArray(boolean value) {
        this._isArray = value;
    }

    public JavaArrayType asArray() {
        return this._asArray;
    }

    public void setArray(JavaArrayType value) {
        this._asArray = value;
    }

    public boolean isWildcard() {
        return this._isWildcard;
    }

    public void setWildcard(boolean value) {
        this._isWildcard = value;
    }

    public JavaWildcardType asWildcard() {
        return this._asWildcard;
    }

    public void setWildcard(JavaWildcardType value) {
        this._asWildcard = value;
    }

    public boolean isTypeVariable() {
        return this._isTypeVariable;
    }

    public void setTypeVariable(boolean value) {
        this._isTypeVariable = value;
    }

    public JavaTypeVariable asTypeVariable() {
        return this._asTypeVariable;
    }

    public void setTypeVariable(JavaTypeVariable value) {
        this._asTypeVariable = value;
    }

    public boolean isExecutable() {
        return this._isExecutable;
    }

    public void setExecutable(boolean value) {
        this._isExecutable = value;
    }

    public JavaExecutableType asExecutable() {
        return this._asExecutable;
    }

    public void setExecutable(JavaExecutableType value) {
        this._asExecutable = value;
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


