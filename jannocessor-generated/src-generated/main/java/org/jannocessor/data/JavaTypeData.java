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
import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeData extends JavaElementData implements JavaType {

    private String nesting;

    private Name packageName;

    private Name qualifiedName;

    private JavaElementType superclass;

    private PowerList<JavaElementType> interfaces;

    private PowerList<JavaTypeParameter> parameters;


    public String getNesting() {
        return this.nesting;
    }

    public void setNesting(String value) {
        this.nesting = value;
    }

    public Name getPackageName() {
        return this.packageName;
    }

    public void setPackageName(Name value) {
        this.packageName = value;
    }

    public Name getQualifiedName() {
        return this.qualifiedName;
    }

    public void setQualifiedName(Name value) {
        this.qualifiedName = value;
    }

    public JavaElementType getSuperclass() {
        return this.superclass;
    }

    public void setSuperclass(JavaElementType value) {
        this.superclass = value;
    }

    public PowerList<JavaElementType> getInterfaces() {
        return this.interfaces;
    }

    public void setInterfaces(PowerList<JavaElementType> value) {
        this.interfaces = value;
    }

    public PowerList<JavaTypeParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaTypeParameter> value) {
        this.parameters = value;
    }


}


