package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaEnum;
import org.jannocessor.data.JavaEnumData;


@Generated("JAnnocessor-bootstraped")
public class JavaEnumProxy extends JavaTypeProxy implements JavaEnum {

    @SuppressWarnings("unused")
    private JavaEnum adapter;

    @SuppressWarnings("unused")
    private JavaEnumData data;

    public JavaEnumProxy(JavaEnum adapter, JavaEnumData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }



}


