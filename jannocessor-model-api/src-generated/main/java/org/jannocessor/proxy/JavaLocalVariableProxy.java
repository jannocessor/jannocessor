package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaLocalVariable;
import org.jannocessor.data.JavaLocalVariableData;



public class JavaLocalVariableProxy extends JavaVariableProxy implements JavaLocalVariable {

    private JavaLocalVariable adapter;

    private JavaLocalVariableData data;

    public JavaLocalVariableProxy(JavaLocalVariable adapter, JavaLocalVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


