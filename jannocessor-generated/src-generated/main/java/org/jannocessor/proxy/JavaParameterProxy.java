package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.data.JavaParameterData;


@Generated("JAnnocessor-bootstraped")
public class JavaParameterProxy extends JavaVariableProxy implements JavaParameter {

    @SuppressWarnings("unused")
    private JavaParameter adapter;

    @SuppressWarnings("unused")
    private JavaParameterData data;

    public JavaParameterProxy(JavaParameter adapter, JavaParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


