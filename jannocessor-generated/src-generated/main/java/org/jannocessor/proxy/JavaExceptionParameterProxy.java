package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.jannocessor.data.JavaExceptionParameterData;


@Generated("JAnnocessor-bootstraped")
public class JavaExceptionParameterProxy extends JavaVariableProxy implements JavaExceptionParameter {

    private JavaExceptionParameter adapter;

    private JavaExceptionParameterData data;

    public JavaExceptionParameterProxy(JavaExceptionParameter adapter, JavaExceptionParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


