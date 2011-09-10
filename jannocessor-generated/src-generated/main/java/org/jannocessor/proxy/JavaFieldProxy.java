package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.data.JavaFieldData;



public class JavaFieldProxy extends JavaVariableProxy implements JavaField {

    private JavaField adapter;

    private JavaFieldData data;

    public JavaFieldProxy(JavaField adapter, JavaFieldData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


