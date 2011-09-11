package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.data.JavaLocalVariableData;


@Generated("JAnnocessor-bootstraped")
public class JavaLocalVariableProxy extends JavaVariableProxy implements JavaLocalVariable {

    private JavaLocalVariable adapter;

    private JavaLocalVariableData data;

    public JavaLocalVariableProxy(JavaLocalVariable adapter, JavaLocalVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


