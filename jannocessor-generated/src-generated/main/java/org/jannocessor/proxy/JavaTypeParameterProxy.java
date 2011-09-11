package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.data.JavaTypeParameterData;


@Generated("JAnnocessor-bootstraped")
public class JavaTypeParameterProxy extends JavaElementProxy implements JavaTypeParameter {

    private JavaTypeParameter adapter;

    private JavaTypeParameterData data;

    public JavaTypeParameterProxy(JavaTypeParameter adapter, JavaTypeParameterData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


