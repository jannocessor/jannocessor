/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
