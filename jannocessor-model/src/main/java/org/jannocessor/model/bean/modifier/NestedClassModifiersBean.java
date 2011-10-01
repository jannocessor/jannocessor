package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.NestedClassModifiers;
import org.jannocessor.model.modifier.value.NestedClassModifierValue;

public class NestedClassModifiersBean implements NestedClassModifiers {

	private NestedClassModifierValue[] values;

	public NestedClassModifiersBean(NestedClassModifierValue[] values) {
		this.values = values;
	}

	@Override
	public NestedClassModifierValue[] getValues() {
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
		if (!(obj instanceof NestedClassModifiers)) {
			return false;
		}

		NestedClassModifiers other = (NestedClassModifiers) obj;
		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("values", getValues()).toString();
	}

}
