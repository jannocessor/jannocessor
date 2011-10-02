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

package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.util.Code;

public class JavaTypeBean extends JavaTypeData implements JavaType {

    private final Class<?> type;

    @SuppressWarnings("unused")
    private final Class<?>[] typeParams;

    public JavaTypeBean(Class<?> type, Class<?>[] typeParams) {
        this.type = type;
        this.typeParams = typeParams;
		this.setCode(Code.code(JavaType.class));
    }

    @Override
    public Name getSimpleName() {
        return new NameBean(type.getSimpleName());
    }

    @Override
    public Name getCanonicalName() {
        return new NameBean(type.getCanonicalName());
    }

    @Override
    public String toString() {
        return getCanonicalName().toString();
    }

    @Override
    public Class<?> getTypeClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean hasError() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isVoid() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isNull() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isPrimitive() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isDeclared() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaDeclaredType asDeclared() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isClass() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaClass asClass() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isInterface() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaInterface asInterface() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isEnum() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaEnum asEnum() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isArray() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaArrayType asArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isWildcard() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaWildcardType asWildcard() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isTypeVariable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaTypeVariable asTypeVariable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isExecutable() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaExecutableType asExecutable() {
        // TODO Auto-generated method stub
        return null;
    }
}
