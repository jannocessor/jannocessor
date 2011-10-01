package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.modifier.value.EnumModifierValue;

public class EnumModifiersBean implements EnumModifiers {

	private EnumModifierValue[] values;

	public EnumModifiersBean(EnumModifierValue[] values) {
		this.values = values;
	}

	@Override
	public EnumModifierValue[] getValues() {
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
		if (!(obj instanceof EnumModifiers)) {
			return false;
		}

		EnumModifiers other = (EnumModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("values", getValues())
				.toString();
	}

}
