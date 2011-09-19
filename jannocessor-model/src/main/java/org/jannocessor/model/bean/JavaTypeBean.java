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

package org.jannocessor.model.bean;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.model.type.JavaInterface;

public class JavaTypeBean implements JavaType {

	private final Class<?> type;

	@SuppressWarnings("unused")
	private final Class<?>[] typeParams;

	public JavaTypeBean(Class<?> type, Class<?>[] typeParams) {
		this.type = type;
		this.typeParams = typeParams;
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
	public boolean isPrimitive() {
		return false;
	}

	@Override
	public boolean isArray() {
		return false;
	}

	@Override
	public boolean isClass() {
		return false;
	}

	@Override
	public JavaClass asClass() {
		return null;
	}

	@Override
	public boolean isInterface() {
		return false;
	}

	@Override
	public JavaInterface asInterface() {
		return null;
	}

	@Override
	public boolean isNull() {
		return false;
	}

	@Override
	public boolean isDeclared() {
		return false;
	}

	@Override
	public boolean isTypeVariable() {
		return false;
	}

	@Override
	public boolean hasError() {
		return false;
	}

	@Override
	public PowerList<JavaType> getParameters() {
		return null;
	}

    @Override
    public boolean isWildcard() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnum() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public JavaType getArrayType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JavaEnum asEnum() {
        // TODO Auto-generated method stub
        return null;
    }
}
