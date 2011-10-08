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

import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.Text;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;



public class JavaTypeData extends JavaElementData implements JavaType {

    //private Text _${m.name.getClone().deleteParts(0)};

    //private Name _${m.name.getClone().deleteParts(0)};

    //private Name _${m.name.getClone().deleteParts(0)};

    //private JavaElementType _${m.name.getClone().deleteParts(0)};

    //private List<JavaElementType> _${m.name.getClone().deleteParts(0)};

    //private List<JavaTypeParameter> _${m.name.getClone().deleteParts(0)};


    public Text getNesting() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setNesting(Text value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Name getPackageName() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setPackageName(Name value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Name getQualifiedName() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setQualifiedName(Name value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public JavaElementType getSuperclass() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setSuperclass(JavaElementType value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaElementType> getInterfaces() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setInterfaces(List<JavaElementType> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaTypeParameter> getParameters() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setParameters(List<JavaTypeParameter> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


