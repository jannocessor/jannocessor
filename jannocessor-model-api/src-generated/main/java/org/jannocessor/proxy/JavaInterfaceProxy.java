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
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.data.JavaInterfaceData;
import java.util.List;
import org.jannocessor.model.executable.JavaMethod;



public class JavaInterfaceProxy extends JavaTypeProxy implements JavaInterface {

    private JavaInterface adapter;

    private JavaInterfaceData data;

    public JavaInterfaceProxy(JavaInterface adapter, JavaInterfaceData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


    public List<JavaMethod> getMethods() {
        if (data.getMethods() == null) {
            data.setMethods(adapter.getMethods());
        }

        return data.getMethods();
    }


}


