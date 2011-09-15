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
import org.jannocessor.model.JavaElementType;
import org.jannocessor.data.JavaElementTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeProxy implements JavaElementType {

    private JavaElementType adapter;

    private JavaElementTypeData data;

    public JavaElementTypeProxy(JavaElementType adapter, JavaElementTypeData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNameInitialized = false;

	private boolean getAsElementInitialized = false;

	private boolean getCaptureInitialized = false;

	private boolean getErasureInitialized = false;

	private boolean getDirectSupertypesInitialized = false;


    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

    public JavaElement getAsElement() {
        if (!getAsElementInitialized) {
            data.setAsElement(adapter.getAsElement());
			getAsElementInitialized = true;
        }

        return data.getAsElement();
    }

    public JavaElementType getCapture() {
        if (!getCaptureInitialized) {
            data.setCapture(adapter.getCapture());
			getCaptureInitialized = true;
        }

        return data.getCapture();
    }

    public JavaElementType getErasure() {
        if (!getErasureInitialized) {
            data.setErasure(adapter.getErasure());
			getErasureInitialized = true;
        }

        return data.getErasure();
    }

    public PowerList<JavaElementType> getDirectSupertypes() {
        if (!getDirectSupertypesInitialized) {
            data.setDirectSupertypes(adapter.getDirectSupertypes());
			getDirectSupertypesInitialized = true;
        }

        return data.getDirectSupertypes();
    }


}


