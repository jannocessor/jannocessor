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
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaType;


@Generated("JAnnocessor-bootstraped")
public class JavaArrayTypeData extends JavaTypeData implements JavaArrayType {

    private JavaType componentType;


    public JavaType getComponentType() {
        return this.componentType;
    }

    public void setComponentType(JavaType value) {
        this.componentType = value;
    }


}


