package org.jannocessor.data;

import org.jannocessor.data.JavaElementData;
import org.jannocessor.model.variable.JavaVariable;
import org.jannocessor.model.Text;



public class JavaVariableData extends JavaElementData implements JavaVariable {

    private Text _getConstant;


    public Text getConstant() {
        return this._getConstant;
    }

    public void setConstant(Text value) {
        this._getConstant = value;
    }


}


