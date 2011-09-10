package org.jannocessor.proxy;

import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.executable.JavaExecutable;
import org.jannocessor.data.JavaExecutableData;
import java.util.List;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.Text;



public class JavaExecutableProxy extends JavaElementProxy implements JavaExecutable {

    private JavaExecutable adapter;

    private JavaExecutableData data;

    public JavaExecutableProxy(JavaExecutable adapter, JavaExecutableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }


    public List<JavaTypeParameter> getTypeParameters() {
        if (data.getTypeParameters() == null) {
            data.setTypeParameters(adapter.getTypeParameters());
        }

        return data.getTypeParameters();
    }

    public JavaElementType getReturnType() {
        if (data.getReturnType() == null) {
            data.setReturnType(adapter.getReturnType());
        }

        return data.getReturnType();
    }

    public List<JavaParameter> getParameters() {
        if (data.getParameters() == null) {
            data.setParameters(adapter.getParameters());
        }

        return data.getParameters();
    }

    public Boolean getVarArgs() {
        if (data.getVarArgs() == null) {
            data.setVarArgs(adapter.getVarArgs());
        }

        return data.getVarArgs();
    }

    public List<JavaElementType> getThrownTypes() {
        if (data.getThrownTypes() == null) {
            data.setThrownTypes(adapter.getThrownTypes());
        }

        return data.getThrownTypes();
    }

    public Text getDefault() {
        if (data.getDefault() == null) {
            data.setDefault(adapter.getDefault());
        }

        return data.getDefault();
    }


}


