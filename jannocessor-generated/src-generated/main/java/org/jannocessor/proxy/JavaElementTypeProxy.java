package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.data.JavaElementTypeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElement;


@Generated("JAnnocessor-bootstraped")
public class JavaElementTypeProxy implements JavaElementType {

    private JavaElementType adapter;

    private JavaElementTypeData data;

    public JavaElementTypeProxy(JavaElementType adapter, JavaElementTypeData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNameInitialized = false;

	private boolean getAsElementInitialized = false;


    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }

    public JavaElement getAsElement() {
        if (!getAsElementInitialized) {
            data.setAsElement(adapter.getAsElement());
			getAsElementInitialized = true;
        }

        return data.getAsElement();
    }


}


