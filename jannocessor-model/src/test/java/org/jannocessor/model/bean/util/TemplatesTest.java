/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.model.bean.util;

import junit.framework.Assert;
import net.sf.twip.TwiP;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaArrayType;
import org.jannocessor.model.util.Templates;
import org.jannocessor.model.variable.JavaExceptionParameter;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class TemplatesTest extends AbstractModelTest {

	@Test
	public void testDefaultTemplateName() {
		Assert.assertEquals("render_exception_parameter",
				Templates.defaultName(JavaExceptionParameter.class));

		Assert.assertEquals("render_class", Templates.defaultName(JavaClass.class));

		Assert.assertEquals("render_type", Templates.defaultName(JavaArrayType.class));
	}

}
