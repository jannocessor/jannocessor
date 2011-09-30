package org.jannocessor.model.bean.util;

import junit.framework.Assert;
import net.sf.twip.TwiP;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.bean.structure.JavaClassBean;
import org.jannocessor.model.bean.type.JavaArrayTypeBean;
import org.jannocessor.model.bean.variable.JavaExceptionParameterBean;
import org.jannocessor.model.util.Templates;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class TemplatesTest extends AbstractModelTest {

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
