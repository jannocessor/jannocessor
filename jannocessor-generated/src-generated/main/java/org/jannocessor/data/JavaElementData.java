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
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;


@Generated("JAnnocessor-bootstraped")
public class JavaElementData implements JavaElement {

    private JavaElement parent;

    private PowerList<JavaElement> children;

    private Name name;

    private JavaElementType type;


    public JavaElement getParent() {
        return this.parent;
    }

    public void setParent(JavaElement value) {
        this.parent = value;
    }

    public PowerList<JavaElement> getChildren() {
        return this.children;
    }

    public void setChildren(PowerList<JavaElement> value) {
        this.children = value;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public JavaElementType getType() {
        return this.type;
    }

    public void setType(JavaElementType value) {
        this.type = value;
    }


}


