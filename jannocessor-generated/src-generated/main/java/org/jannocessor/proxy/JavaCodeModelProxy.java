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
import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.data.JavaCodeModelData;
import org.jannocessor.model.code.SourceCode;


@Generated("JAnnocessor-bootstraped")
public class JavaCodeModelProxy implements JavaCodeModel {

    private JavaCodeModel adapter;

    private JavaCodeModelData data;

    public JavaCodeModelProxy(JavaCodeModel adapter, JavaCodeModelData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getCodeInitialized = false;


    public SourceCode getCode() {
        if (!getCodeInitialized) {
            data.setCode(adapter.getCode());
			getCodeInitialized = true;
        }

        return data.getCode();
    }


}


