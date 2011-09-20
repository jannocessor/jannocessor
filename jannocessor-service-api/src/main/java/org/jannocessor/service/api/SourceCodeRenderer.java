package org.jannocessor.service.api;

import org.jannocessor.model.code.JavaCodeModel;

public interface SourceCodeRenderer {

	public String render(JavaCodeModel codeModel);

}
