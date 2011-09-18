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
import org.jannocessor.model.JavaType;
import org.jannocessor.model.Name;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeData implements JavaType {

    private Name simpleName;

    private Name canonicalName;

    private PowerList<JavaType> directSupertypes;


    public Name getSimpleName() {
        return this.simpleName;
    }

    public void setSimpleName(Name value) {
        this.simpleName = value;
    }

    public Name getCanonicalName() {
        return this.canonicalName;
    }

    public void setCanonicalName(Name value) {
        this.canonicalName = value;
    }

    public PowerList<JavaType> getDirectSupertypes() {
        return this.directSupertypes;
    }

    public void setDirectSupertypes(PowerList<JavaType> value) {
        this.directSupertypes = value;
    }


}


