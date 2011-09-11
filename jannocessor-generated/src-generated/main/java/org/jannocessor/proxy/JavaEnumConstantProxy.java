package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaVariableProxy;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.data.JavaEnumConstantData;


@Generated("JAnnocessor-bootstraped")
public class JavaEnumConstantProxy extends JavaVariableProxy implements JavaEnumConstant {

    private JavaEnumConstant adapter;

    private JavaEnumConstantData data;

    public JavaEnumConstantProxy(JavaEnumConstant adapter, JavaEnumConstantData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


