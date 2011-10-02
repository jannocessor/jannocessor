package org.jannocessor.util;

import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class TypeSpecificStyle extends ToStringStyle {

	public TypeSpecificStyle(Class<?> type) {
		this.setUseClassName(false);
		this.setUseIdentityHashCode(false);

		this.setContentStart(type.getSimpleName());
		this.setFieldSeparator(", ");
		this.setFieldSeparatorAtStart(false);
		this.setContentEnd("}");
	}

}
