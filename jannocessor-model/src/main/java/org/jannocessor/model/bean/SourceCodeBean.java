package org.jannocessor.model.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.util.TypeSpecificStyle;

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

	public SourceCodeBean(String templateName) {
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

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		SourceCodeBean other = (SourceCodeBean) obj;
		return new EqualsBuilder().append(code, other.getCode())
				.append(template, other.getTemplate())
				.append(templateName, other.getTemplateName()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(code).append(template)
				.append(templateName).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(SourceCode.class);
		return new ReflectionToStringBuilder(this, style).setExcludeFieldNames(
				new String[] {}).toString();
	}

}
