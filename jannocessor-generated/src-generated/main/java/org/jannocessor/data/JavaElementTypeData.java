package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeData implements JavaElementType {

    private Name name;

    private JavaElement asElement;

    private JavaElementType capture;

    private JavaElementType erasure;

    private PowerList<JavaElementType> directSupertypes;


    public Name getName() {
        return this.name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public JavaElement getAsElement() {
        return this.asElement;
    }

    public void setAsElement(JavaElement value) {
        this.asElement = value;
    }

    public JavaElementType getCapture() {
        return this.capture;
    }

    public void setCapture(JavaElementType value) {
        this.capture = value;
    }

    public JavaElementType getErasure() {
        return this.erasure;
    }

    public void setErasure(JavaElementType value) {
        this.erasure = value;
    }

    public PowerList<JavaElementType> getDirectSupertypes() {
        return this.directSupertypes;
    }

    public void setDirectSupertypes(PowerList<JavaElementType> value) {
        this.directSupertypes = value;
    }


}


