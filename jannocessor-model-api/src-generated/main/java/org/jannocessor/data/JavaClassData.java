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

package org.jannocessor.data;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaClass;
import java.util.List;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;



public class JavaClassData extends JavaTypeData implements JavaClass {

    //private List<JavaField> _${m.name.getClone().deleteParts(0)};

    //private List<JavaConstructor> _${m.name.getClone().deleteParts(0)};

    //private List<JavaMethod> _${m.name.getClone().deleteParts(0)};

    //private List<JavaStaticInit> _${m.name.getClone().deleteParts(0)};

    //private List<JavaInstanceInit> _${m.name.getClone().deleteParts(0)};


    public List<JavaField> getFields() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setFields(List<JavaField> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaConstructor> getConstructors() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setConstructors(List<JavaConstructor> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaMethod> getMethods() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setMethods(List<JavaMethod> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaStaticInit> getStaticInits() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setStaticInits(List<JavaStaticInit> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaInstanceInit> getInstanceInits() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setInstanceInits(List<JavaInstanceInit> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


