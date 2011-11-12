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

package org.jannocessor.service.render;

import org.apache.velocity.VelocityContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TemplateHelperTest {

	private TemplateHelper helper;

	@Before
	public void init() {
		VelocityContext context = Mockito.mock(VelocityContext.class);
		helper = new TemplateHelper(context);
	}

	@Test
	public void shouldIndentAllTextLines() {
		Assert.assertEquals("  a\n  b\n  c", helper.indent("a\nb\nc", "  "));
		Assert.assertEquals("  a\r\n  b\r\n  c",
				helper.indent("a\r\nb\r\nc", "  "));
		Assert.assertEquals("    a\n    b\n    c",
				helper.indent(helper.indent("a\nb\nc", "  "), "  "));
		Assert.assertEquals("  a\r\n  b\r\n  c\r\n",
				helper.indent("a\r\nb\r\nc\r\n", "  "));
	}

	@Test
	public void shouldNotIndentWhitespaceLines() {
		Assert.assertEquals("  a\n\n  b\n\n\n  c",
				helper.indent("a\n\nb\n\n\nc", "  "));
	}

}
