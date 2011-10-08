/**
 * Copyright 2011 Nikolche Mihajlovski
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

import org.jannocessor.model.JavaElement;
import org.jannocessor.data.JavaElementData;
import java.util.List;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.JavaElementType;



public class JavaElementProxy implements JavaElement {

    private JavaElement adapter;

    private JavaElementData data;

    public JavaElementProxy(JavaElement adapter, JavaElementData data) {
        this.adapter = adapter;
        this.data = data;
    }


    public JavaElement getParent() {
        if (data.getParent() == null) {
            data.setParent(adapter.getParent());
        }

        return data.getParent();
    }

    public List<JavaElement> getChildren() {
        if (data.getChildren() == null) {
            data.setChildren(adapter.getChildren());
        }

        return data.getChildren();
    }

    public Name getName() {
        if (data.getName() == null) {
            data.setName(adapter.getName());
        }

        return data.getName();
    }

    public Text getKind() {
        if (data.getKind() == null) {
            data.setKind(adapter.getKind());
        }

        return data.getKind();
    }

    public JavaElementType getType() {
        if (data.getType() == null) {
            data.setType(adapter.getType());
        }

        return data.getType();
    }


}


