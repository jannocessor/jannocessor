package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElement;
import org.jannocessor.data.JavaElementData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;
import org.jannocessor.model.JavaElementType;


@Generated("JAnnocessor-bootstraped")
public class JavaElementProxy implements JavaElement {

    private JavaElement adapter;

    private JavaElementData data;

    public JavaElementProxy(JavaElement adapter, JavaElementData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getParentInitialized = false;

	private boolean getChildrenInitialized = false;

	private boolean getNameInitialized = false;

	private boolean getKindInitialized = false;

	private boolean getTypeInitialized = false;


    public JavaElement getParent() {
        if (!getParentInitialized) {
            data.setParent(adapter.getParent());
			getParentInitialized = true;
        }

        return data.getParent();
    }

    public PowerList<JavaElement> getChildren() {
        if (!getChildrenInitialized) {
            data.setChildren(adapter.getChildren());
			getChildrenInitialized = true;
        }

        return data.getChildren();
    }

    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

    public Text getKind() {
        if (!getKindInitialized) {
            data.setKind(adapter.getKind());
			getKindInitialized = true;
        }

        return data.getKind();
    }

    public JavaElementType getType() {
        if (!getTypeInitialized) {
            data.setType(adapter.getType());
			getTypeInitialized = true;
        }

        return data.getType();
    }


}


