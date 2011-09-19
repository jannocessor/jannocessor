package org.jannocessor.adapter.type;

import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;

public class JavaTypeVariableAdapter extends JavaTypeAdapter implements JavaTypeVariable {

    public JavaTypeVariableAdapter(TypeVariable typeVariable, Elements elementUtils, Types typeUtils) {
        super(typeVariable, elementUtils, typeUtils);
        // TODO Auto-generated constructor stub
    }

    @Override
    public JavaType getUpperBound() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JavaType getLowerBound() {
        // TODO Auto-generated method stub
        return null;
    }

}
