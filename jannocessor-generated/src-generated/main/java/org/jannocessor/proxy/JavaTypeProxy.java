package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.Text;
import org.jannocessor.model.Name;
import org.jannocessor.model.JavaElementType;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;



public class JavaTypeProxy extends JavaElementProxy implements JavaType {

    private JavaType adapter;

    private JavaTypeData data;

    public JavaTypeProxy(JavaType adapter, JavaTypeData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getNestingInitialized = false;

	private boolean getPackageNameInitialized = false;

	private boolean getQualifiedNameInitialized = false;

	private boolean getSuperclassInitialized = false;

	private boolean getInterfacesInitialized = false;

	private boolean getParametersInitialized = false;


    public Text getNesting() {
        if (!getNestingInitialized) {
            data.setNesting(adapter.getNesting());
			getNestingInitialized = true;
        }

        return data.getNesting();
    }

    public Name getPackageName() {
        if (!getPackageNameInitialized) {
            data.setPackageName(adapter.getPackageName());
			getPackageNameInitialized = true;
        }

        return data.getPackageName();
    }

    public Name getQualifiedName() {
        if (!getQualifiedNameInitialized) {
            data.setQualifiedName(adapter.getQualifiedName());
			getQualifiedNameInitialized = true;
        }

        return data.getQualifiedName();
    }

    public JavaElementType getSuperclass() {
        if (!getSuperclassInitialized) {
            data.setSuperclass(adapter.getSuperclass());
			getSuperclassInitialized = true;
        }

        return data.getSuperclass();
    }

    public List<JavaElementType> getInterfaces() {
        if (!getInterfacesInitialized) {
            data.setInterfaces(adapter.getInterfaces());
			getInterfacesInitialized = true;
        }

        return data.getInterfaces();
    }

    public List<JavaTypeParameter> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }


}


