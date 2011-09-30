package org.jannocessor.model.bean.executable;

import org.jannocessor.model.executable.ExecutableBody;

public class ExecutableBodyBean implements ExecutableBody {

	private String code;
	private String template;
	private String templateName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
