package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaElementProxy;
import org.jannocessor.model.executable.JavaExecutable;
import org.jannocessor.data.JavaExecutableData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaExecutableProxy extends JavaElementProxy implements JavaExecutable {

    private JavaExecutable adapter;

    private JavaExecutableData data;

    public JavaExecutableProxy(JavaExecutable adapter, JavaExecutableData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

	private boolean getReturnTypeInitialized = false;

	private boolean getParametersInitialized = false;

	private boolean getVarArgsInitialized = false;

	private boolean getThrownTypesInitialized = false;

	private boolean getDefaultInitialized = false;


    public PowerList<JavaTypeParameter> getTypeParameters() {
        if (!getTypeParametersInitialized) {
            data.setTypeParameters(adapter.getTypeParameters());
			getTypeParametersInitialized = true;
        }

        return data.getTypeParameters();
    }

    public JavaElementType getReturnType() {
        if (!getReturnTypeInitialized) {
            data.setReturnType(adapter.getReturnType());
			getReturnTypeInitialized = true;
        }

        return data.getReturnType();
    }

    public PowerList<JavaParameter> getParameters() {
        if (!getParametersInitialized) {
            data.setParameters(adapter.getParameters());
			getParametersInitialized = true;
        }

        return data.getParameters();
    }

    public Boolean getVarArgs() {
        if (!getVarArgsInitialized) {
            data.setVarArgs(adapter.getVarArgs());
			getVarArgsInitialized = true;
        }

        return data.getVarArgs();
    }

    public PowerList<JavaElementType> getThrownTypes() {
        if (!getThrownTypesInitialized) {
            data.setThrownTypes(adapter.getThrownTypes());
			getThrownTypesInitialized = true;
        }

        return data.getThrownTypes();
    }

    public String getDefault() {
        if (!getDefaultInitialized) {
            data.setDefault(adapter.getDefault());
			getDefaultInitialized = true;
        }

        return data.getDefault();
    }


}


