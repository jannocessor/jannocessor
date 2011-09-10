package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.variable.JavaVariable;
import org.jannocessor.data.JavaVariableData;
import org.jannocessor.model.Text;



public class JavaVariableProxy extends JavaElementProxy implements JavaVariable {

    private JavaVariable adapter;

    private JavaVariableData data;

    public JavaVariableProxy(JavaVariable adapter, JavaVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


    public Text getConstant() {
        if (data.getConstant() == null) {
            data.setConstant(adapter.getConstant());
        }

        return data.getConstant();
    }


}


