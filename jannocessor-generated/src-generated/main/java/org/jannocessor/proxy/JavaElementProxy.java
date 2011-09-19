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
import org.jannocessor.model.JavaElement;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;


@Generated("JAnnocessor-bootstraped")
public class JavaElementProxy implements JavaElement {

    private JavaElement adapter;

    private JavaElementData data;

    public JavaElementProxy(JavaElement adapter, JavaElementData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParentInitialized = false;

	private boolean getChildrenInitialized = false;

	private boolean getNameInitialized = false;

	private boolean getTypeInitialized = false;


    public JavaElement getParent() {
        if (!getParentInitialized) {
            data.setParent(adapter.getParent());
			getParentInitialized = true;
        }

        return data.getParent();
    }

    public PowerList<JavaElement> getChildren() {
        if (!getChildrenInitialized) {
            data.setChildren(adapter.getChildren());
			getChildrenInitialized = true;
        }

        return data.getChildren();
    }

    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

    public JavaType getType() {
        if (!getTypeInitialized) {
            data.setType(adapter.getType());
			getTypeInitialized = true;
        }

        return data.getType();
    }


}


