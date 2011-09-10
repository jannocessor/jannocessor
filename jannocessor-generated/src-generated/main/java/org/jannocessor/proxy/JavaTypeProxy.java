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


    public Text getNesting() {
        if (data.getNesting() == null) {
            data.setNesting(adapter.getNesting());
        }

        return data.getNesting();
    }

    public Name getPackageName() {
        if (data.getPackageName() == null) {
            data.setPackageName(adapter.getPackageName());
        }

        return data.getPackageName();
    }

    public Name getQualifiedName() {
        if (data.getQualifiedName() == null) {
            data.setQualifiedName(adapter.getQualifiedName());
        }

        return data.getQualifiedName();
    }

    public JavaElementType getSuperclass() {
        if (data.getSuperclass() == null) {
            data.setSuperclass(adapter.getSuperclass());
        }

        return data.getSuperclass();
    }

    public List<JavaElementType> getInterfaces() {
        if (data.getInterfaces() == null) {
            data.setInterfaces(adapter.getInterfaces());
        }

        return data.getInterfaces();
    }

    public List<JavaTypeParameter> getParameters() {
        if (data.getParameters() == null) {
            data.setParameters(adapter.getParameters());
        }

        return data.getParameters();
    }


}


