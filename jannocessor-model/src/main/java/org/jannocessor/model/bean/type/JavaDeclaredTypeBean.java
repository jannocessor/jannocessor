package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaDeclaredTypeData;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.util.Code;

public class JavaDeclaredTypeBean extends JavaDeclaredTypeData implements
		JavaDeclaredType {

	public JavaDeclaredTypeBean() {
		// TODO Auto-generated constructor stub
		this.setCode(Code.code(JavaDeclaredType.class));
	}
}
