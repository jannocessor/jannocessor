package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.data.JavaConstructorData;



public class JavaConstructorProxy extends JavaExecutableProxy implements JavaConstructor {

    private JavaConstructor adapter;

    private JavaConstructorData data;

    public JavaConstructorProxy(JavaConstructor adapter, JavaConstructorData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


