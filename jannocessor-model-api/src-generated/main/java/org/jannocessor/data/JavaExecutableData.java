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
import org.jannocessor.model.executable.JavaExecutable;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.Text;



public class JavaExecutableData extends JavaElementData implements JavaExecutable {

    //private List<JavaTypeParameter> _${m.name.getClone().deleteParts(0)};

    //private JavaElementType _${m.name.getClone().deleteParts(0)};

    //private List<JavaParameter> _${m.name.getClone().deleteParts(0)};

    //private Boolean _${m.name.getClone().deleteParts(0)};

    //private List<JavaElementType> _${m.name.getClone().deleteParts(0)};

    //private Text _${m.name.getClone().deleteParts(0)};


    public List<JavaTypeParameter> getTypeParameters() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setTypeParameters(List<JavaTypeParameter> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public JavaElementType getReturnType() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setReturnType(JavaElementType value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaParameter> getParameters() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setParameters(List<JavaParameter> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Boolean getVarArgs() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setVarArgs(Boolean value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaElementType> getThrownTypes() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setThrownTypes(List<JavaElementType> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Text getDefault() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setDefault(Text value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


