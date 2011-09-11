package org.jannocessor.proxy;

import org.jannocessor.model.JavaElementType;
import org.jannocessor.data.JavaElementTypeData;
import org.jannocessor.model.Name;



public class JavaElementTypeProxy implements JavaElementType {

    private JavaElementType adapter;

    private JavaElementTypeData data;

    public JavaElementTypeProxy(JavaElementType adapter, JavaElementTypeData data) {
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNameInitialized = false;


    public Name getName() {
        if (!getNameInitialized) {
            data.setName(adapter.getName());
			getNameInitialized = true;
        }

        return data.getName();
    }


}


