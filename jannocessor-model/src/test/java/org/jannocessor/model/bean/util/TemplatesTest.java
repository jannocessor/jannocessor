package org.jannocessor.model.bean.util;

import junit.framework.Assert;

import org.jannocessor.model.bean.structure.JavaClassBean;
import org.jannocessor.model.bean.type.JavaArrayTypeBean;
import org.jannocessor.model.bean.variable.JavaExceptionParameterBean;
import org.jannocessor.model.util.Templates;
import org.junit.Test;

public class TemplatesTest {

	@Test
	public void testDefaultTemplateName() {
		Assert.assertEquals("default/exception_parameter",
				Templates.defaultName(JavaExceptionParameterBean.class));

		Assert.assertEquals("default/class",
				Templates.defaultName(JavaClassBean.class));

		Assert.assertEquals("default/array_type",
				Templates.defaultName(JavaArrayTypeBean.class));
	}

}
