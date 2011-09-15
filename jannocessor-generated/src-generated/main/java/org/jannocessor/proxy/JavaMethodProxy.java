package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.data.JavaMethodData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.JavaElementType;
import org.jannocessor.model.variable.JavaParameter;


@Generated("JAnnocessor-bootstraped")
public class JavaMethodProxy extends JavaExecutableProxy implements JavaMethod {

    private JavaMethod adapter;

    private JavaMethodData data;

    public JavaMethodProxy(JavaMethod adapter, JavaMethodData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

	private boolean getReturnTypeInitialized = false;

	private boolean getParametersInitialized = false;

	private boolean getVarArgsInitialized = false;

	private boolean getThrownTypesInitialized = false;


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


}


