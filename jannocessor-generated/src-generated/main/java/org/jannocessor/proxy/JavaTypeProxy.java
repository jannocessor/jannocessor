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
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeProxy extends JavaElementProxy implements JavaType {

    private JavaType adapter;

    private JavaTypeData data;

    public JavaTypeProxy(JavaType adapter, JavaTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNestingInitialized = false;

	private boolean getPackageNameInitialized = false;

	private boolean getQualifiedNameInitialized = false;

	private boolean getSuperclassInitialized = false;

	private boolean getInterfacesInitialized = false;

	private boolean getParametersInitialized = false;


    public String getNesting() {
        if (!getNestingInitialized) {
            data.setNesting(adapter.getNesting());
			getNestingInitialized = true;
        }

        return data.getNesting();
    }

    public Name getPackageName() {
        if (!getPackageNameInitialized) {
            data.setPackageName(adapter.getPackageName());
			getPackageNameInitialized = true;
        }

        return data.getPackageName();
    }

    public Name getQualifiedName() {
        if (!getQualifiedNameInitialized) {
            data.setQualifiedName(adapter.getQualifiedName());
			getQualifiedNameInitialized = true;
        }

        return data.getQualifiedName();
    }

    public JavaElementType getSuperclass() {
        if (!getSuperclassInitialized) {
            data.setSuperclass(adapter.getSuperclass());
			getSuperclassInitialized = true;
        }

        return data.getSuperclass();
    }

    public PowerList<JavaElementType> getInterfaces() {
        if (!getInterfacesInitialized) {
            data.setInterfaces(adapter.getInterfaces());
			getInterfacesInitialized = true;
        }

        return data.getInterfaces();
    }

    public PowerList<JavaTypeParameter> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }


}


