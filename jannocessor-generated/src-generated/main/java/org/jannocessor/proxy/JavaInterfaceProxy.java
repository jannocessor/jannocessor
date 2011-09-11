package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaInterface;
import org.jannocessor.data.JavaInterfaceData;
import java.util.List;
import org.jannocessor.model.executable.JavaMethod;



public class JavaInterfaceProxy extends JavaTypeProxy implements JavaInterface {

    private JavaInterface adapter;

    private JavaInterfaceData data;

    public JavaInterfaceProxy(JavaInterface adapter, JavaInterfaceData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getMethodsInitialized = false;


    public List<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
    }


}


