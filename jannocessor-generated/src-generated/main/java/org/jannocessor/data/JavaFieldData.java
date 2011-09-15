package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaVariableData;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.modifier.FieldModifiers;


@Generated("JAnnocessor-bootstraped")
public class JavaFieldData extends JavaVariableData implements JavaField {

    private FieldModifiers _getModifiers;


    public FieldModifiers getModifiers() {
        return this._getModifiers;
    }

    public void setModifiers(FieldModifiers value) {
        this._getModifiers = value;
    }


}


