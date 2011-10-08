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
import org.jannocessor.model.variable.JavaVariable;
import org.jannocessor.model.Text;



public class JavaVariableData extends JavaElementData implements JavaVariable {

    //private Text _${m.name.getClone().deleteParts(0)};


    public Text getConstant() {
        //return this._${m.name.getClone().deleteParts(0)};
		return null;
    }

    public void setConstant(Text value) {
        //this._${m.name.getClone().deleteParts(0)} = value;
    }


}


