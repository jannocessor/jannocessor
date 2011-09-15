package org.jannocessor.data;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElement;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;


@Generated("JAnnocessor-bootstraped")
public class JavaElementData implements JavaElement {

    private JavaElement parent;

    private PowerList<JavaElement> children;

    private Name name;

    private JavaElementType type;


    public JavaElement getParent() {
        return this.parent;
    }

    public void setParent(JavaElement value) {
        this.parent = value;
    }

    public PowerList<JavaElement> getChildren() {
        return this.children;
    }

    public void setChildren(PowerList<JavaElement> value) {
        this.children = value;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name value) {
        this.name = value;
    }

    public JavaElementType getType() {
        return this.type;
    }

    public void setType(JavaElementType value) {
        this.type = value;
    }


}


