package org.jannocessor.adapter.type;

import javax.lang.model.type.ArrayType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaType;

public class JavaArrayTypeAdapter extends JavaTypeAdapter implements JavaArrayType {

    private final ArrayType arrayType;

    public JavaArrayTypeAdapter(ArrayType arrayType, Elements elementUtils, Types typeUtils) {
        super(arrayType, elementUtils, typeUtils);
        this.arrayType = arrayType;
    }

    @Override
    public JavaType getComponentType() {
        return getTypeAdapter(arrayType.getComponentType());
    }

}
