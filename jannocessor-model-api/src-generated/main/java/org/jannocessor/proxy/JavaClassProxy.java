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

import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.data.JavaClassData;
import java.util.List;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;



public class JavaClassProxy extends JavaTypeProxy implements JavaClass {

    private JavaClass adapter;

    private JavaClassData data;

    public JavaClassProxy(JavaClass adapter, JavaClassData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


    public List<JavaField> getFields() {
        if (data.getFields() == null) {
            data.setFields(adapter.getFields());
        }

        return data.getFields();
    }

    public List<JavaConstructor> getConstructors() {
        if (data.getConstructors() == null) {
            data.setConstructors(adapter.getConstructors());
        }

        return data.getConstructors();
    }

    public List<JavaMethod> getMethods() {
        if (data.getMethods() == null) {
            data.setMethods(adapter.getMethods());
        }

        return data.getMethods();
    }

    public List<JavaStaticInit> getStaticInits() {
        if (data.getStaticInits() == null) {
            data.setStaticInits(adapter.getStaticInits());
        }

        return data.getStaticInits();
    }

    public List<JavaInstanceInit> getInstanceInits() {
        if (data.getInstanceInits() == null) {
            data.setInstanceInits(adapter.getInstanceInits());
        }

        return data.getInstanceInits();
    }


}


