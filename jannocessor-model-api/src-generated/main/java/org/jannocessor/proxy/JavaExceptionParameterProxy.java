package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.data.JavaExceptionParameterData;



public class JavaExceptionParameterProxy extends JavaVariableProxy implements JavaExceptionParameter {

    private JavaExceptionParameter adapter;

    private JavaExceptionParameterData data;

    public JavaExceptionParameterProxy(JavaExceptionParameter adapter, JavaExceptionParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


