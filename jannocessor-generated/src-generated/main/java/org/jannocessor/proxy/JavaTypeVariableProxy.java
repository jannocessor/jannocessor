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

package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.data.JavaTypeVariableData;
import org.jannocessor.model.type.JavaType;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeVariableProxy extends JavaTypeProxy implements JavaTypeVariable {

    private JavaTypeVariable adapter;

    private JavaTypeVariableData data;

    public JavaTypeVariableProxy(JavaTypeVariable adapter, JavaTypeVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getUpperBoundInitialized = false;

	private boolean getLowerBoundInitialized = false;


    public JavaType getUpperBound() {
        if (!getUpperBoundInitialized) {
            data.setUpperBound(adapter.getUpperBound());
			getUpperBoundInitialized = true;
        }

        return data.getUpperBound();
    }

    public JavaType getLowerBound() {
        if (!getLowerBoundInitialized) {
            data.setLowerBound(adapter.getLowerBound());
			getLowerBoundInitialized = true;
        }

        return data.getLowerBound();
    }


}


