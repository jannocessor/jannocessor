package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.data.JavaEnumData;



public class JavaEnumProxy extends JavaTypeProxy implements JavaEnum {

    private JavaEnum adapter;

    private JavaEnumData data;

    public JavaEnumProxy(JavaEnum adapter, JavaEnumData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


