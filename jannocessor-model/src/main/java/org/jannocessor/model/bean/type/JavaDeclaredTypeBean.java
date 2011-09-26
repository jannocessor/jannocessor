package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaDeclaredTypeData;
import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.util.Templates;

public class JavaDeclaredTypeBean extends JavaDeclaredTypeData implements
		JavaDeclaredType {

	public JavaDeclaredTypeBean() {
		// TODO Auto-generated constructor stub
		this.setCode(new SourceCodeBean(Templates.defaultName(getClass())));
	}
}
