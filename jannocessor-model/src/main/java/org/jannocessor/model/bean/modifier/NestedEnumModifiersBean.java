package org.jannocessor.model.bean.modifier;

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.NestedEnumModifiers;
import org.jannocessor.model.modifier.value.NestedEnumModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class NestedEnumModifiersBean implements NestedEnumModifiers {

	private NestedEnumModifierValue[] values;

	public NestedEnumModifiersBean(NestedEnumModifierValue[] values) {
		this.values = values;
	}

	@Override
	public NestedEnumModifierValue[] getValues() {
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
		if (!(obj instanceof NestedEnumModifiers)) {
			return false;
		}

		NestedEnumModifiers other = (NestedEnumModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(NestedEnumModifiers.class);
		return new ToStringBuilder(this, style).append("values",
				Arrays.toString(getValues())).toString();
	}

}
