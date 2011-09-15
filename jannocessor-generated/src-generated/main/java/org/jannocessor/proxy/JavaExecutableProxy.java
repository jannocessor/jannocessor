package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.executable.JavaExecutable;
import org.jannocessor.data.JavaExecutableData;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableProxy extends JavaElementProxy implements JavaExecutable {

    @SuppressWarnings("unused")
    private JavaExecutable adapter;

    @SuppressWarnings("unused")
    private JavaExecutableData data;

    public JavaExecutableProxy(JavaExecutable adapter, JavaExecutableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


