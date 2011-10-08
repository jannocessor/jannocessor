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

import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.executable.JavaExecutable;
import org.jannocessor.data.JavaExecutableData;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.Text;



public class JavaExecutableProxy extends JavaElementProxy implements JavaExecutable {

    private JavaExecutable adapter;

    private JavaExecutableData data;

    public JavaExecutableProxy(JavaExecutable adapter, JavaExecutableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


    public List<JavaTypeParameter> getTypeParameters() {
        if (data.getTypeParameters() == null) {
            data.setTypeParameters(adapter.getTypeParameters());
        }

        return data.getTypeParameters();
    }

    public JavaElementType getReturnType() {
        if (data.getReturnType() == null) {
            data.setReturnType(adapter.getReturnType());
        }

        return data.getReturnType();
    }

    public List<JavaParameter> getParameters() {
        if (data.getParameters() == null) {
            data.setParameters(adapter.getParameters());
        }

        return data.getParameters();
    }

    public Boolean getVarArgs() {
        if (data.getVarArgs() == null) {
            data.setVarArgs(adapter.getVarArgs());
        }

        return data.getVarArgs();
    }

    public List<JavaElementType> getThrownTypes() {
        if (data.getThrownTypes() == null) {
            data.setThrownTypes(adapter.getThrownTypes());
        }

        return data.getThrownTypes();
    }

    public Text getDefault() {
        if (data.getDefault() == null) {
            data.setDefault(adapter.getDefault());
        }

        return data.getDefault();
    }


}


