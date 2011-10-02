package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.modifier.ClassModifiers;
import org.jannocessor.model.modifier.value.ClassModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class ClassModifiersBean implements ClassModifiers {

	private ClassModifierValue[] values;

	public ClassModifiersBean(ClassModifierValue[] values) {
		this.values = values;
	}

	@Override
	public ClassModifierValue[] getValues() {
		return values;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof ClassModifiers)) {
			return false;
		}

		ClassModifiers other = (ClassModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(SourceCode.class);
		return new ToStringBuilder(this, style).append("values", getValues())
				.toString();
	}

}
