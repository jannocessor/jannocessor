package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.data.JavaVariableData;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.modifier.FieldModifiers;


@Generated("JAnnocessor-bootstraped")
public class JavaFieldData extends JavaVariableData implements JavaField {

    private FieldModifiers modifiers;


    public FieldModifiers getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(FieldModifiers value) {
        this.modifiers = value;
    }


}


