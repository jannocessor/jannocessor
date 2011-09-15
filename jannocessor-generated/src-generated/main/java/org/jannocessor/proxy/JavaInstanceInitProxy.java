package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.data.JavaInstanceInitData;


@Generated("JAnnocessor-bootstraped")
public class JavaInstanceInitProxy extends JavaExecutableProxy implements JavaInstanceInit {

    @SuppressWarnings("unused")
    private JavaInstanceInit adapter;

    @SuppressWarnings("unused")
    private JavaInstanceInitData data;

    public JavaInstanceInitProxy(JavaInstanceInit adapter, JavaInstanceInitData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


