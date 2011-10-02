package org.jannocessor.adapter.type;

import javax.lang.model.type.TypeVariable;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.Code;

public class JavaTypeVariableAdapter extends JavaTypeAdapter implements JavaTypeVariable {

    public JavaTypeVariableAdapter(TypeVariable typeVariable, Elements elementUtils, Types typeUtils) {
        super(typeVariable, elementUtils, typeUtils);
		this.setCode(Code.code(JavaTypeVariable.class));
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
