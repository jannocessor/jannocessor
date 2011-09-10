package org.jannocessor.data;

import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;



public class JavaElementTypeData implements JavaElementType {

    private Name _getName;


    public Name getName() {
        return this._getName;
    }

    public void setName(Name value) {
        this._getName = value;
    }


}


