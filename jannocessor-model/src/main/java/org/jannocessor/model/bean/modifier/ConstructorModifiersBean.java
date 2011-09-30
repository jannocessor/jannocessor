package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jannocessor.model.modifier.ConstructorModifierValue;
import org.jannocessor.model.modifier.ConstructorModifiers;

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
		return new ReflectionToStringBuilder(this).toString();
	}

}
