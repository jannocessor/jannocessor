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
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeData implements JavaElementType {

    private Name name;

    private JavaElement asElement;

    private JavaElementType capture;

    private JavaElementType erasure;

    private PowerList<JavaElementType> directSupertypes;


    public Name getName() {
        return this.name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public JavaElement getAsElement() {
        return this.asElement;
    }

    public void setAsElement(JavaElement value) {
        this.asElement = value;
    }

    public JavaElementType getCapture() {
        return this.capture;
    }

    public void setCapture(JavaElementType value) {
        this.capture = value;
    }

    public JavaElementType getErasure() {
        return this.erasure;
    }

    public void setErasure(JavaElementType value) {
        this.erasure = value;
    }

    public PowerList<JavaElementType> getDirectSupertypes() {
        return this.directSupertypes;
    }

    public void setDirectSupertypes(PowerList<JavaElementType> value) {
        this.directSupertypes = value;
    }


}


