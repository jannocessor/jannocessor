package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeData implements JavaElementType {

    private Name _getName;

    private JavaElement _getAsElement;


    public Name getName() {
        return this._getName;
    }

    public void setName(Name value) {
        this._getName = value;
    }

    public JavaElement getAsElement() {
        return this._getAsElement;
    }

    public void setAsElement(JavaElement value) {
        this._getAsElement = value;
    }


}


