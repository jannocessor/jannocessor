package org.jannocessor.adapter.type;

import javax.lang.model.type.WildcardType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.type.JavaWildcardType;

public class JavaWildcardTypeAdapter extends JavaTypeAdapter implements JavaWildcardType {

    public JavaWildcardTypeAdapter(WildcardType wildcardType, Elements elementUtils, Types typeUtils) {
        super(wildcardType, elementUtils, typeUtils);
        // TODO Auto-generated constructor stub
    }

    @Override
    public JavaType getExtendsBound() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public JavaType getSuperBound() {
        // TODO Auto-generated method stub
        return null;
    }

}
