package org.jannocessor.adapter.type;

import javax.lang.model.type.ExecutableType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;

public class JavaExecutableTypeAdapter extends JavaTypeAdapter implements JavaExecutableType {

    public JavaExecutableTypeAdapter(ExecutableType executableType, Elements elementUtils, Types typeUtils) {
        super(executableType, elementUtils, typeUtils);
    }

    @Override
    public PowerList<JavaType> getParameterTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaType> getReturnType() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaDeclaredType> getThrownTypes() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PowerList<JavaTypeVariable> getTypeVariables() {
        // TODO Auto-generated method stub
        return null;
    }

}
