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

import org.jannocessor.model.JavaElement;
import java.util.List;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.JavaElementType;



public class JavaElementData implements JavaElement {

    //private JavaElement _${m.name.getClone().deleteParts(0)};

    //private List<JavaElement> _${m.name.getClone().deleteParts(0)};

    //private Name _${m.name.getClone().deleteParts(0)};

    //private Text _${m.name.getClone().deleteParts(0)};

    //private JavaElementType _${m.name.getClone().deleteParts(0)};


    public JavaElement getParent() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setParent(JavaElement value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public List<JavaElement> getChildren() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setChildren(List<JavaElement> value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Name getName() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setName(Name value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public Text getKind() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setKind(Text value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }

    public JavaElementType getType() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setType(JavaElementType value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


