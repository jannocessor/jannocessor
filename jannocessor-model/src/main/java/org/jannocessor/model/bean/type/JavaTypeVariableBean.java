package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaTypeVariableData;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.Templates;

public class JavaTypeVariableBean extends JavaTypeVariableData implements JavaTypeVariable {

    public JavaTypeVariableBean(Class<?> lowerBound, Class<?> upperBound) {
        // TODO Auto-generated constructor stub
		this.setCode(new SourceCodeBean(Templates.defaultName(getClass())));
    }

}
