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
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.type.JavaType;


@Generated("JAnnocessor-bootstraped")
public class JavaWildcardTypeData extends JavaTypeData implements JavaWildcardType {

    private JavaType extendsBound;

    private JavaType superBound;


    public JavaType getExtendsBound() {
        return this.extendsBound;
    }

    public void setExtendsBound(JavaType value) {
        this.extendsBound = value;
    }

    public JavaType getSuperBound() {
        return this.superBound;
    }

    public void setSuperBound(JavaType value) {
        this.superBound = value;
    }


}


