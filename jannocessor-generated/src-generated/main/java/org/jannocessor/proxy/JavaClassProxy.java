package org.jannocessor.proxy;

import javax.annotation.Generated;
import org.jannocessor.proxy.JavaTypeProxy;
import org.jannocessor.model.type.JavaClass;
import org.jannocessor.data.JavaClassData;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.executable.JavaInstanceInit;


@Generated("JAnnocessor-bootstraped")
public class JavaClassProxy extends JavaTypeProxy implements JavaClass {

    private JavaClass adapter;

    private JavaClassData data;

    public JavaClassProxy(JavaClass adapter, JavaClassData data) {
        super(adapter, data);
        this.adapter = adapter;
        this.data = data;
    }

	private boolean getFieldsInitialized = false;

	private boolean getConstructorsInitialized = false;

	private boolean getMethodsInitialized = false;

	private boolean getStaticInitsInitialized = false;

	private boolean getInstanceInitsInitialized = false;


    public PowerList<JavaField> getFields() {
        if (!getFieldsInitialized) {
            data.setFields(adapter.getFields());
			getFieldsInitialized = true;
        }

        return data.getFields();
    }

    public PowerList<JavaConstructor> getConstructors() {
        if (!getConstructorsInitialized) {
            data.setConstructors(adapter.getConstructors());
			getConstructorsInitialized = true;
        }

        return data.getConstructors();
    }

    public PowerList<JavaMethod> getMethods() {
        if (!getMethodsInitialized) {
            data.setMethods(adapter.getMethods());
			getMethodsInitialized = true;
        }

        return data.getMethods();
    }

    public PowerList<JavaStaticInit> getStaticInits() {
        if (!getStaticInitsInitialized) {
            data.setStaticInits(adapter.getStaticInits());
			getStaticInitsInitialized = true;
        }

        return data.getStaticInits();
    }

    public PowerList<JavaInstanceInit> getInstanceInits() {
        if (!getInstanceInitsInitialized) {
            data.setInstanceInits(adapter.getInstanceInits());
			getInstanceInitsInitialized = true;
        }

        return data.getInstanceInits();
    }


}


