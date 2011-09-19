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
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaTypeVariable;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableTypeData extends JavaTypeData implements JavaExecutableType {

    private PowerList<JavaType> parameterTypes;

    private PowerList<JavaType> returnType;

    private PowerList<JavaDeclaredType> thrownTypes;

    private PowerList<JavaTypeVariable> typeVariables;


    public PowerList<JavaType> getParameterTypes() {
        return this.parameterTypes;
    }

    public void setParameterTypes(PowerList<JavaType> value) {
        this.parameterTypes = value;
    }

    public PowerList<JavaType> getReturnType() {
        return this.returnType;
    }

    public void setReturnType(PowerList<JavaType> value) {
        this.returnType = value;
    }

    public PowerList<JavaDeclaredType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaDeclaredType> value) {
        this.thrownTypes = value;
    }

    public PowerList<JavaTypeVariable> getTypeVariables() {
        return this.typeVariables;
    }

    public void setTypeVariables(PowerList<JavaTypeVariable> value) {
        this.typeVariables = value;
    }


}


