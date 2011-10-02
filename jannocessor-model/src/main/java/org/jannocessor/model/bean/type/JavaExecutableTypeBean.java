package org.jannocessor.model.bean.type;

import java.util.List;

import org.jannocessor.data.JavaExecutableTypeData;
import org.jannocessor.model.type.JavaExecutableType;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;

public class JavaExecutableTypeBean extends JavaExecutableTypeData implements
		JavaExecutableType {

	public JavaExecutableTypeBean(JavaType returnType,
			List<JavaType> parameterTypes,
			List<JavaType> thrownTypes, List<JavaType> typeVariables) {
		// TODO Auto-generated constructor stub
		this.setCode(Code.code(JavaExecutableType.class));
	}

}
