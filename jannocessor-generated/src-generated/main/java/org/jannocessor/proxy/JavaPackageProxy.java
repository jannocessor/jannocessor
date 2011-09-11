package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.type.JavaPackage;
import org.jannocessor.data.JavaPackageData;


@Generated("JAnnocessor-bootstraped")
public class JavaPackageProxy extends JavaElementProxy implements JavaPackage {

    private JavaPackage adapter;

    private JavaPackageData data;

    public JavaPackageProxy(JavaPackage adapter, JavaPackageData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


