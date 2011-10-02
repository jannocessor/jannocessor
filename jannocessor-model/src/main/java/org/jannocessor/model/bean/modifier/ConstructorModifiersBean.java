package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.modifier.ConstructorModifiers;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class ConstructorModifiersBean implements ConstructorModifiers {

	private ConstructorModifierValue[] values;

	public ConstructorModifiersBean(ConstructorModifierValue[] values) {
		this.values = values;
	}

	@Override
	public ConstructorModifierValue[] getValues() {
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
		if (!(obj instanceof ConstructorModifiers)) {
			return false;
		}

		ConstructorModifiers other = (ConstructorModifiers) obj;
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
