package org.jannocessor.model.bean.modifier;

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.modifier.value.MethodModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class MethodModifiersBean implements MethodModifiers {

	private MethodModifierValue[] values;

	public MethodModifiersBean(MethodModifierValue[] values) {
		this.values = values;
	}

	@Override
	public MethodModifierValue[] getValues() {
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
		if (!(obj instanceof MethodModifiers)) {
			return false;
		}

		MethodModifiers other = (MethodModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(MethodModifiers.class);
		return new ToStringBuilder(this, style).append("values",
				Arrays.toString(getValues())).toString();
	}

}
