package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.variable.JavaVariable;
import org.jannocessor.data.JavaVariableData;
import org.jannocessor.model.Text;


@Generated("JAnnocessor-bootstraped")
public class JavaVariableProxy extends JavaElementProxy implements JavaVariable {

    private JavaVariable adapter;

    private JavaVariableData data;

    public JavaVariableProxy(JavaVariable adapter, JavaVariableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getConstantInitialized = false;


    public Text getConstant() {
        if (!getConstantInitialized) {
            data.setConstant(adapter.getConstant());
			getConstantInitialized = true;
        }

        return data.getConstant();
    }


}


