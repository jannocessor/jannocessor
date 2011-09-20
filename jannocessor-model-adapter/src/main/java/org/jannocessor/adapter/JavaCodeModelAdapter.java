package org.jannocessor.adapter;

import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.bean.SourceCodeBean;
import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.code.SourceCode;

public abstract class JavaCodeModelAdapter extends AbstractAdapter implements
		JavaCodeModel {

	private final SourceCode code = new SourceCodeBean();

	public JavaCodeModelAdapter(Elements elementUtils, Types typeUtils) {
		super(elementUtils, typeUtils);
	}

	@Override
	public SourceCode getCode() {
		return code;
	}

}
