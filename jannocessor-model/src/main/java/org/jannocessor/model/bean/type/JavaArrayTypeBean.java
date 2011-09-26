package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaArrayTypeData;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Templates;

public class JavaArrayTypeBean extends JavaArrayTypeData implements JavaArrayType {

    public JavaArrayTypeBean(JavaType type) {
        // TODO Auto-generated constructor stub
		this.setCode(new SourceCodeBean(Templates.defaultName(getClass())));
    }

}
