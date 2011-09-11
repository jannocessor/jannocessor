package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.data.JavaStaticInitData;


@Generated("JAnnocessor-bootstraped")
public class JavaStaticInitProxy extends JavaExecutableProxy implements JavaStaticInit {

    private JavaStaticInit adapter;

    private JavaStaticInitData data;

    public JavaStaticInitProxy(JavaStaticInit adapter, JavaStaticInitData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


