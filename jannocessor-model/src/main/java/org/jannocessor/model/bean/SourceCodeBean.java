/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.model.bean;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.util.TypeSpecificInlineStyle;

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
		SourceCode other = (SourceCode) obj;
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
		TypeSpecificInlineStyle style = new TypeSpecificInlineStyle(
				SourceCode.class);
		return new ReflectionToStringBuilder(this, style).toString();
	}

	@Override
	public void assign(SourceCode sourceCode) {
		setCode(sourceCode.getCode());
		setTemplate(sourceCode.getTemplate());
		setTemplateName(sourceCode.getTemplateName());
	}

}
