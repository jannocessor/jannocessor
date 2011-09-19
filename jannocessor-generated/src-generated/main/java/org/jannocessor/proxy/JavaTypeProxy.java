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
import org.jannocessor.model.JavaType;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeProxy implements JavaType {

    private JavaType adapter;

    private JavaTypeData data;

    public JavaTypeProxy(JavaType adapter, JavaTypeData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getSimpleNameInitialized = false;

	private boolean getCanonicalNameInitialized = false;

	private boolean isPrimitiveInitialized = false;

	private boolean isNullInitialized = false;

	private boolean isDeclaredInitialized = false;

	private boolean isTypeVariableInitialized = false;

	private boolean isArrayInitialized = false;

	private boolean isWildcardInitialized = false;

	private boolean isClassInitialized = false;

	private boolean isInterfaceInitialized = false;

	private boolean isEnumInitialized = false;

	private boolean hasErrorInitialized = false;

	private boolean getArrayTypeInitialized = false;

	private boolean asClassInitialized = false;

	private boolean asInterfaceInitialized = false;

	private boolean asEnumInitialized = false;

	private boolean getParametersInitialized = false;


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

    public boolean isPrimitive() {
        if (!isPrimitiveInitialized) {
            data.setPrimitive(adapter.isPrimitive());
			isPrimitiveInitialized = true;
        }

        return data.isPrimitive();
    }

    public boolean isNull() {
        if (!isNullInitialized) {
            data.setNull(adapter.isNull());
			isNullInitialized = true;
        }

        return data.isNull();
    }

    public boolean isDeclared() {
        if (!isDeclaredInitialized) {
            data.setDeclared(adapter.isDeclared());
			isDeclaredInitialized = true;
        }

        return data.isDeclared();
    }

    public boolean isTypeVariable() {
        if (!isTypeVariableInitialized) {
            data.setTypeVariable(adapter.isTypeVariable());
			isTypeVariableInitialized = true;
        }

        return data.isTypeVariable();
    }

    public boolean isArray() {
        if (!isArrayInitialized) {
            data.setArray(adapter.isArray());
			isArrayInitialized = true;
        }

        return data.isArray();
    }

    public boolean isWildcard() {
        if (!isWildcardInitialized) {
            data.setWildcard(adapter.isWildcard());
			isWildcardInitialized = true;
        }

        return data.isWildcard();
    }

    public boolean isClass() {
        if (!isClassInitialized) {
            data.setClass(adapter.isClass());
			isClassInitialized = true;
        }

        return data.isClass();
    }

    public boolean isInterface() {
        if (!isInterfaceInitialized) {
            data.setInterface(adapter.isInterface());
			isInterfaceInitialized = true;
        }

        return data.isInterface();
    }

    public boolean isEnum() {
        if (!isEnumInitialized) {
            data.setEnum(adapter.isEnum());
			isEnumInitialized = true;
        }

        return data.isEnum();
    }

    public boolean hasError() {
        if (!hasErrorInitialized) {
            data.setError(adapter.hasError());
			hasErrorInitialized = true;
        }

        return data.hasError();
    }

    public JavaType getArrayType() {
        if (!getArrayTypeInitialized) {
            data.setArrayType(adapter.getArrayType());
			getArrayTypeInitialized = true;
        }

        return data.getArrayType();
    }

    public JavaClass asClass() {
        if (!asClassInitialized) {
            data.setClass(adapter.asClass());
			asClassInitialized = true;
        }

        return data.asClass();
    }

    public JavaInterface asInterface() {
        if (!asInterfaceInitialized) {
            data.setInterface(adapter.asInterface());
			asInterfaceInitialized = true;
        }

        return data.asInterface();
    }

    public JavaEnum asEnum() {
        if (!asEnumInitialized) {
            data.setEnum(adapter.asEnum());
			asEnumInitialized = true;
        }

        return data.asEnum();
    }

    public PowerList<JavaType> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }


}


