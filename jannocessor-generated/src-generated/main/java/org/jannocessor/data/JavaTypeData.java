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
import org.jannocessor.model.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeData implements JavaType {

    private Name simpleName;

    private Name canonicalName;

    private boolean _isPrimitive;

    private boolean _isNull;

    private boolean _isDeclared;

    private boolean _isTypeVariable;

    private boolean _isArray;

    private boolean _isWildcard;

    private boolean _isClass;

    private boolean _isInterface;

    private boolean _isEnum;

    private boolean _hasError;

    private JavaType arrayType;

    private JavaClass _asClass;

    private JavaInterface _asInterface;

    private JavaEnum _asEnum;

    private PowerList<JavaType> parameters;


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

    public boolean isPrimitive() {
        return this._isPrimitive;
    }

    public void setPrimitive(boolean value) {
        this._isPrimitive = value;
    }

    public boolean isNull() {
        return this._isNull;
    }

    public void setNull(boolean value) {
        this._isNull = value;
    }

    public boolean isDeclared() {
        return this._isDeclared;
    }

    public void setDeclared(boolean value) {
        this._isDeclared = value;
    }

    public boolean isTypeVariable() {
        return this._isTypeVariable;
    }

    public void setTypeVariable(boolean value) {
        this._isTypeVariable = value;
    }

    public boolean isArray() {
        return this._isArray;
    }

    public void setArray(boolean value) {
        this._isArray = value;
    }

    public boolean isWildcard() {
        return this._isWildcard;
    }

    public void setWildcard(boolean value) {
        this._isWildcard = value;
    }

    public boolean isClass() {
        return this._isClass;
    }

    public void setClass(boolean value) {
        this._isClass = value;
    }

    public boolean isInterface() {
        return this._isInterface;
    }

    public void setInterface(boolean value) {
        this._isInterface = value;
    }

    public boolean isEnum() {
        return this._isEnum;
    }

    public void setEnum(boolean value) {
        this._isEnum = value;
    }

    public boolean hasError() {
        return this._hasError;
    }

    public void setError(boolean value) {
        this._hasError = value;
    }

    public JavaType getArrayType() {
        return this.arrayType;
    }

    public void setArrayType(JavaType value) {
        this.arrayType = value;
    }

    public JavaClass asClass() {
        return this._asClass;
    }

    public void setClass(JavaClass value) {
        this._asClass = value;
    }

    public JavaInterface asInterface() {
        return this._asInterface;
    }

    public void setInterface(JavaInterface value) {
        this._asInterface = value;
    }

    public JavaEnum asEnum() {
        return this._asEnum;
    }

    public void setEnum(JavaEnum value) {
        this._asEnum = value;
    }

    public PowerList<JavaType> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaType> value) {
        this.parameters = value;
    }


}


