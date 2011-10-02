package org.jannocessor.util;

import org.apache.commons.lang.SystemUtils;
import org.apache.commons.lang.builder.ToStringStyle;

@SuppressWarnings("serial")
public class DescriptiveStyle extends ToStringStyle {

	public DescriptiveStyle(Class<?> type) {
		this.setUseClassName(false);
		this.setUseIdentityHashCode(false);

		this.setContentStart(type.getSimpleName() + "{\n");
        this.setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
        this.setFieldSeparatorAtStart(true);
        this.setContentEnd(SystemUtils.LINE_SEPARATOR + "}");
	}


}
