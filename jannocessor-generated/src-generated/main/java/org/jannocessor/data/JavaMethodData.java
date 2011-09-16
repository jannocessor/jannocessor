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
import org.jannocessor.data.JavaExecutableData;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.modifier.MethodModifiers;


@Generated("JAnnocessor-bootstraped")
public class JavaMethodData extends JavaExecutableData implements JavaMethod {

    private PowerList<JavaTypeParameter> typeParameters;

    private JavaElementType returnType;

    private PowerList<JavaParameter> parameters;

    private Boolean varArgs;

    private PowerList<JavaElementType> thrownTypes;

    private MethodModifiers modifiers;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        return this.typeParameters;
    }

    public void setTypeParameters(PowerList<JavaTypeParameter> value) {
        this.typeParameters = value;
    }

    public JavaElementType getReturnType() {
        return this.returnType;
    }

    public void setReturnType(JavaElementType value) {
        this.returnType = value;
    }

    public PowerList<JavaParameter> getParameters() {
        return this.parameters;
    }

    public void setParameters(PowerList<JavaParameter> value) {
        this.parameters = value;
    }

    public Boolean getVarArgs() {
        return this.varArgs;
    }

    public void setVarArgs(Boolean value) {
        this.varArgs = value;
    }

    public PowerList<JavaElementType> getThrownTypes() {
        return this.thrownTypes;
    }

    public void setThrownTypes(PowerList<JavaElementType> value) {
        this.thrownTypes = value;
    }

    public MethodModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(MethodModifiers value) {
        this.modifiers = value;
    }


}


