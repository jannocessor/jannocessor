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


    public Name getName() {
        if (data.getName() == null) {
            data.setName(adapter.getName());
        }

        return data.getName();
    }


}


