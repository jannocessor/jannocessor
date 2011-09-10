package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.data.JavaInstanceInitData;



public class JavaInstanceInitProxy extends JavaExecutableProxy implements JavaInstanceInit {

    private JavaInstanceInit adapter;

    private JavaInstanceInitData data;

    public JavaInstanceInitProxy(JavaInstanceInit adapter, JavaInstanceInitData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


