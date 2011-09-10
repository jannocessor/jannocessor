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


