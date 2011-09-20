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


}


