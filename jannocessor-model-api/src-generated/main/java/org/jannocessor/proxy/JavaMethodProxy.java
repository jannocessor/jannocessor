package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.data.JavaMethodData;



public class JavaMethodProxy extends JavaExecutableProxy implements JavaMethod {

    private JavaMethod adapter;

    private JavaMethodData data;

    public JavaMethodProxy(JavaMethod adapter, JavaMethodData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


