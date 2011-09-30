package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jannocessor.model.modifier.MethodModifierValue;
import org.jannocessor.model.modifier.MethodModifiers;

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
		return new ReflectionToStringBuilder(this).toString();
	}


}
