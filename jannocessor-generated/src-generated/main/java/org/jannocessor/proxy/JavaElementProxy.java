package org.jannocessor.proxy;

import org.jannocessor.model.JavaElement;
import org.jannocessor.data.JavaElementData;
import java.util.List;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.JavaElementType;



public class JavaElementProxy implements JavaElement {

    private JavaElement adapter;

    private JavaElementData data;

    public JavaElementProxy(JavaElement adapter, JavaElementData data) {
        this.adapter = adapter;
        this.data = data;
    }


    public JavaElement getParent() {
        if (data.getParent() == null) {
            data.setParent(adapter.getParent());
        }

        return data.getParent();
    }

    public List<JavaElement> getChildren() {
        if (data.getChildren() == null) {
            data.setChildren(adapter.getChildren());
        }

        return data.getChildren();
    }

    public Name getName() {
        if (data.getName() == null) {
            data.setName(adapter.getName());
        }

        return data.getName();
    }

    public Text getKind() {
        if (data.getKind() == null) {
            data.setKind(adapter.getKind());
        }

        return data.getKind();
    }

    public JavaElementType getType() {
        if (data.getType() == null) {
            data.setType(adapter.getType());
        }

        return data.getType();
    }


}


