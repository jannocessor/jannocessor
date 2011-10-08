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

package org.jannocessor.adapter.type;

import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.Code;

public class JavaExecutableTypeAdapter extends JavaTypeAdapter implements JavaExecutableType {

    public JavaExecutableTypeAdapter(ExecutableType executableType, Elements elementUtils, Types typeUtils) {
        super(executableType, elementUtils, typeUtils);
		this.setCode(Code.code(JavaExecutableType.class));
    }

    @Override
    public PowerList<JavaType> getParameterTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaType> getReturnType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaDeclaredType> getThrownTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaTypeVariable> getTypeVariables() {
        // TODO Auto-generated method stub
        return null;
    }

}
