package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.data.JavaInterfaceData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.executable.JavaMethod;


@Generated("JAnnocessor-bootstraped")
public class JavaInterfaceProxy extends JavaTypeProxy implements JavaInterface {

    private JavaInterface adapter;

    private JavaInterfaceData data;

    public JavaInterfaceProxy(JavaInterface adapter, JavaInterfaceData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getMethodsInitialized = false;


    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
    }


}


