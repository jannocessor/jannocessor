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

import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.data.JavaParameterData;



public class JavaParameterProxy extends JavaVariableProxy implements JavaParameter {

    private JavaParameter adapter;

    private JavaParameterData data;

    public JavaParameterProxy(JavaParameter adapter, JavaParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


