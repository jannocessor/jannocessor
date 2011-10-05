package org.jannocessor.model.bean.modifier;

import java.util.Arrays;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.NestedInterfaceModifiers;
import org.jannocessor.model.modifier.value.NestedInterfaceModifierValue;
import org.jannocessor.util.TypeSpecificStyle;

public class NestedInterfaceModifiersBean implements NestedInterfaceModifiers {

	private NestedInterfaceModifierValue[] values;

	public NestedInterfaceModifiersBean(NestedInterfaceModifierValue[] values) {
		this.values = values;
	}

	@Override
	public NestedInterfaceModifierValue[] getValues() {
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
		if (!(obj instanceof NestedInterfaceModifiers)) {
			return false;
		}

		NestedInterfaceModifiers other = (NestedInterfaceModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(NestedInterfaceModifiers.class);
		return new ToStringBuilder(this, style).append("values",
				Arrays.toString(getValues())).toString();
	}

}
