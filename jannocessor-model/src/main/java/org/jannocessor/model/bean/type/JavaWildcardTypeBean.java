package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaWildcardTypeData;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.util.Code;

public class JavaWildcardTypeBean extends JavaWildcardTypeData implements JavaWildcardType {

    public JavaWildcardTypeBean(Class<?> wildcardSuper, Class<?> wildcardExtends) {
        // TODO Auto-generated constructor stub
		this.setCode(Code.code(JavaWildcardType.class));
    }

}
