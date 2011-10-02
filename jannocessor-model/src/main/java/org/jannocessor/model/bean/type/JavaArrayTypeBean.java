package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaArrayTypeData;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;

public class JavaArrayTypeBean extends JavaArrayTypeData implements JavaArrayType {

    public JavaArrayTypeBean(JavaType type) {
        // TODO Auto-generated constructor stub
		this.setCode(Code.code(JavaArrayType.class));
    }

}
