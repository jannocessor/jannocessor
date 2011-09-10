package org.jannocessor.data;

import org.jannocessor.model.JavaElement;
import java.util.List;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.JavaElementType;



public class JavaElementData implements JavaElement {

    private JavaElement _getParent;

    private List<JavaElement> _getChildren;

    private Name _getName;

    private Text _getKind;

    private JavaElementType _getType;


    public JavaElement getParent() {
        return this._getParent;
    }

    public void setParent(JavaElement value) {
        this._getParent = value;
    }

    public List<JavaElement> getChildren() {
        return this._getChildren;
    }

    public void setChildren(List<JavaElement> value) {
        this._getChildren = value;
    }

    public Name getName() {
        return this._getName;
    }

    public void setName(Name value) {
        this._getName = value;
    }

    public Text getKind() {
        return this._getKind;
    }

    public void setKind(Text value) {
        this._getKind = value;
    }

    public JavaElementType getType() {
        return this._getType;
    }

    public void setType(JavaElementType value) {
        this._getType = value;
    }


}


