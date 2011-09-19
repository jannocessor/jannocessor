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
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.data.JavaExecutableTypeData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaTypeVariable;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableTypeProxy extends JavaTypeProxy implements JavaExecutableType {

    private JavaExecutableType adapter;

    private JavaExecutableTypeData data;

    public JavaExecutableTypeProxy(JavaExecutableType adapter, JavaExecutableTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParameterTypesInitialized = false;

	private boolean getReturnTypeInitialized = false;

	private boolean getThrownTypesInitialized = false;

	private boolean getTypeVariablesInitialized = false;


    public PowerList<JavaType> getParameterTypes() {
        if (!getParameterTypesInitialized) {
            data.setParameterTypes(adapter.getParameterTypes());
			getParameterTypesInitialized = true;
        }

        return data.getParameterTypes();
    }

    public PowerList<JavaType> getReturnType() {
        if (!getReturnTypeInitialized) {
            data.setReturnType(adapter.getReturnType());
			getReturnTypeInitialized = true;
        }

        return data.getReturnType();
    }

    public PowerList<JavaDeclaredType> getThrownTypes() {
        if (!getThrownTypesInitialized) {
            data.setThrownTypes(adapter.getThrownTypes());
			getThrownTypesInitialized = true;
        }

        return data.getThrownTypes();
    }

    public PowerList<JavaTypeVariable> getTypeVariables() {
        if (!getTypeVariablesInitialized) {
            data.setTypeVariables(adapter.getTypeVariables());
			getTypeVariablesInitialized = true;
        }

        return data.getTypeVariables();
    }


}


