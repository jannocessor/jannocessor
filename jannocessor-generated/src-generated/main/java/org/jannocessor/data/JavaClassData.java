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
import org.jannocessor.data.AbstractJavaTypeData;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.modifier.ClassModifiers;


@Generated("JAnnocessor-bootstraped")
public class JavaClassData extends AbstractJavaTypeData implements JavaClass {

    private PowerList<JavaField> fields;

    private PowerList<JavaConstructor> constructors;

    private PowerList<JavaMethod> methods;

    private PowerList<JavaStaticInit> staticInits;

    private PowerList<JavaInstanceInit> instanceInits;

    private ClassModifiers modifiers;


    public PowerList<JavaField> getFields() {
        return this.fields;
    }

    public void setFields(PowerList<JavaField> value) {
        this.fields = value;
    }

    public PowerList<JavaConstructor> getConstructors() {
        return this.constructors;
    }

    public void setConstructors(PowerList<JavaConstructor> value) {
        this.constructors = value;
    }

    public PowerList<JavaMethod> getMethods() {
        return this.methods;
    }

    public void setMethods(PowerList<JavaMethod> value) {
        this.methods = value;
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        return this.staticInits;
    }

    public void setStaticInits(PowerList<JavaStaticInit> value) {
        this.staticInits = value;
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        return this.instanceInits;
    }

    public void setInstanceInits(PowerList<JavaInstanceInit> value) {
        this.instanceInits = value;
    }

    public ClassModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(ClassModifiers value) {
        this.modifiers = value;
    }


}


