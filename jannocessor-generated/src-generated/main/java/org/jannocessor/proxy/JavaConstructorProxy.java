package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.data.JavaConstructorData;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorProxy extends JavaExecutableProxy implements JavaConstructor {

    private JavaConstructor adapter;

    private JavaConstructorData data;

    public JavaConstructorProxy(JavaConstructor adapter, JavaConstructorData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


