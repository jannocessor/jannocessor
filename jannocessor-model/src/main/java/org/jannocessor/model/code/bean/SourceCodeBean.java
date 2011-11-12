/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.model.code.bean;

import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.ParentedElement;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.util.TypeSpecificInlineStyle;

public class SourceCodeBean implements SourceCode, ParentedElement {

	private static final long serialVersionUID = -387902157887092393L;

	private String hardcoded;
	private String template;
	private String templateName;
	private String macroName;
	private Map<String, ? extends Object> attributes;

	private CodeNode parent;

	public SourceCodeBean(String code, String template, String templateName,
			String macroName) {
		this.hardcoded = code;
		this.template = template;
		this.templateName = templateName;
		this.macroName = macroName;
	}

	private void clean() {
		this.hardcoded = null;
		this.template = null;
		this.templateName = null;
		this.macroName = null;
	}

	@Override
	public String getHardcoded() {
		return hardcoded;
	}

	@Override
	public void setHardcoded(String hardcoded, Object... formatArgs) {
		clean();
		if (formatArgs.length > 0) {
			this.hardcoded = String.format(hardcoded, (Object[]) formatArgs);
		} else {
			this.hardcoded = hardcoded;
		}
	}

	@Override
	public String getTemplate() {
		return template;
	}

	@Override
	public void setTemplate(String template) {
		clean();
		this.template = template;
	}

	@Override
	public String getTemplateName() {
		return templateName;
	}

	@Override
	public void setTemplateName(String templateName) {
		clean();
		this.templateName = templateName;
	}

	@Override
	public String getMacroName() {
		return macroName;
	}

	@Override
	public void setMacroName(String macroName) {
		clean();
		this.macroName = macroName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof SourceCode)) {
			return false;
		}
		SourceCode other = (SourceCode) obj;
		return new EqualsBuilder().append(hardcoded, other.getHardcoded())
				.append(template, other.getTemplate())
				.append(templateName, other.getTemplateName())
				.append(macroName, other.getMacroName()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(hardcoded).append(template)
				.append(templateName).append(macroName).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificInlineStyle style = new TypeSpecificInlineStyle(
				SourceCode.class);

		return new ToStringBuilder(this, style)
				.append("hardcoded", getHardcoded())
				.append("template", getTemplate())
				.append("templateName", getTemplateName())
				.append("macroName", getMacroName())
				.append("attributes", getAttributes())
				.append("empty", isEmpty()).toString();
	}

	@Override
	public void assign(SourceCode sourceCode) {
		setHardcoded(sourceCode.getHardcoded());
		setTemplate(sourceCode.getTemplate());
		setTemplateName(sourceCode.getTemplateName());
		setMacroName(sourceCode.getMacroName());
	}

	@Override
	public boolean isEmpty() {
		return (getHardcoded() == null) && (getTemplate() == null)
				&& (getTemplateName() == null) && (getMacroName() == null);
	}

	@Override
	public CodeNode getParent() {
		return this.parent;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public void setParent(CodeNode parent) {
		this.parent = parent;
	}

	@Override
	public void setAttributes(Map<String, ? extends Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public Map<String, ? extends Object> getAttributes() {
		return this.attributes;
	}

	@Override
	public SourceCode copy() {
		return ModelUtils.copy(this);
	}

}
