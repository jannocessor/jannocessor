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

	private boolean getDirectSupertypesInitialized = false;


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

    public PowerList<JavaType> getDirectSupertypes() {
        if (!getDirectSupertypesInitialized) {
            data.setDirectSupertypes(adapter.getDirectSupertypes());
			getDirectSupertypesInitialized = true;
        }

        return data.getDirectSupertypes();
    }


}


