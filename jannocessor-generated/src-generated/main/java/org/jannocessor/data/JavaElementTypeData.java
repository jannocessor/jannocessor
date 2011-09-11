package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeData implements JavaElementType {

    private Name _getName;

    private JavaElement _getAsElement;

    private JavaElementType _getCapture;

    private JavaElementType _getErasure;

    private PowerList<JavaElementType> _getDirectSupertypes;


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

    public JavaElementType getCapture() {
        return this._getCapture;
    }

    public void setCapture(JavaElementType value) {
        this._getCapture = value;
    }

    public JavaElementType getErasure() {
        return this._getErasure;
    }

    public void setErasure(JavaElementType value) {
        this._getErasure = value;
    }

    public PowerList<JavaElementType> getDirectSupertypes() {
        return this._getDirectSupertypes;
    }

    public void setDirectSupertypes(PowerList<JavaElementType> value) {
        this._getDirectSupertypes = value;
    }


}


