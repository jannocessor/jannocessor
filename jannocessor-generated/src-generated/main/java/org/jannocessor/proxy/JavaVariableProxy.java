package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.variable.JavaVariable;
import org.jannocessor.data.JavaVariableData;


@Generated("JAnnocessor-bootstraped")
public class JavaVariableProxy extends JavaElementProxy implements JavaVariable {

    @SuppressWarnings("unused")
    private JavaVariable adapter;

    @SuppressWarnings("unused")
    private JavaVariableData data;

    public JavaVariableProxy(JavaVariable adapter, JavaVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


