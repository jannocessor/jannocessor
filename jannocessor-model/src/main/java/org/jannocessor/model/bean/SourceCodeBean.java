package org.jannocessor.model.bean;

import org.jannocessor.model.code.SourceCode;

public class SourceCodeBean implements SourceCode {

	private String code;
	private String template;
	private String templateName;

	public SourceCodeBean() {
	}

	public SourceCodeBean(String code, String template, String templateName) {
		this.code = code;
		this.template = template;
		this.templateName = templateName;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String getTemplate() {
		return template;
	}

	@Override
	public void setTemplate(String template) {
		this.template = template;
	}

	@Override
	public String getTemplateName() {
		return templateName;
	}

	@Override
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

}
