package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaExecutableProxy;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.data.JavaConstructorData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaTypeParameter;
import org.jannocessor.model.variable.JavaParameter;
import org.jannocessor.model.JavaElementType;


@Generated("JAnnocessor-bootstraped")
public class JavaConstructorProxy extends JavaExecutableProxy implements JavaConstructor {

    private JavaConstructor adapter;

    private JavaConstructorData data;

    public JavaConstructorProxy(JavaConstructor adapter, JavaConstructorData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getTypeParametersInitialized = false;

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


