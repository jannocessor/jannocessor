package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.data.JavaParameterData;



public class JavaParameterProxy extends JavaVariableProxy implements JavaParameter {

    private JavaParameter adapter;

    private JavaParameterData data;

    public JavaParameterProxy(JavaParameter adapter, JavaParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


