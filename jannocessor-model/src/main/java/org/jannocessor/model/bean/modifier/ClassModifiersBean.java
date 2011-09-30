package org.jannocessor.model.bean.modifier;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.jannocessor.model.modifier.ClassModifierValue;
import org.jannocessor.model.modifier.ClassModifiers;

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
		return new ReflectionToStringBuilder(this).toString();
	}

}
