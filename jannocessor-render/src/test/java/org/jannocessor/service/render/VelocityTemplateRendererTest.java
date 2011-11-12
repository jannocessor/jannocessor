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

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.jannocessor.service.api.TemplateRenderer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class VelocityTemplateRendererTest {

	private TemplateRenderer renderer;

	@Before
	public void initialize() throws JannocessorException {
		Configurator configurator = Mockito.mock(Configurator.class);
		Mockito.when(configurator.getTemplatesPath()).thenReturn("templates");

		JavaRepresenter representer = Mockito.mock(JavaRepresenter.class);

		renderer = new VelocityTemplateRenderer(configurator, representer);
		renderer.configure(null, false);
	}

	@Test
	public void testRender() throws JannocessorException {
		String template = "x=$x, foo=$foo, $other";

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("x", 1);
		attributes.put("foo", "bar");

		String text = renderer.render(template, attributes);

		assertEquals("x=1, foo=bar, $other", text);
	}

	@Test
	public void testInlineMacroScope() throws JannocessorException {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("x", 1);
		attributes.put("y", "2");

		String template1 = "#macro(m $a)[$a]#end #m($x)-#m($y)";
		String text1 = renderer.render(template1, attributes).trim();
		assertEquals("[1]-[2]", text1);

		String template2 = "#m($x)-#m($y)";
		String text2 = renderer.render(template2, attributes).trim();
		//assertEquals("#m($x)-#m($y)", text2);
		assertEquals("[1]-[2]", text2);

		String template3 = "#macro(m $a){$a}#end #m($x)-#m($y)";
		String text3 = renderer.render(template3, attributes).trim();
		assertEquals("{1}-{2}", text3);
	}

	@Test
	public void testGlobalMacro() throws JannocessorException {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("x", 1);
		attributes.put("y", "2");

		String template1 = "#global_macro($x)-#global_macro($y)";
		String text1 = renderer.render(template1, attributes).trim();
		assertEquals("global:1-global:2", text1);

		String template2 = "#macro(global_macro $a)local:$a#end #global_macro($x)-#global_macro($y)";
		String text2 = renderer.render(template2, attributes).trim();
		assertEquals("local:1-local:2", text2);

		String template3 = "#global_macro($x)-#global_macro($y)";
		String text3 = renderer.render(template3, attributes).trim();
//		assertEquals("global:1-global:2", text3);
		assertEquals("local:1-local:2", text3);
	}

	@Test
	public void shouldRenderMacro() throws JannocessorException {
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("x", 1);
		attributes.put("y", "2");

		String text = renderer.renderMacro("test_macro1", attributes,
				new String[0]);
		assertEquals("1-2", text);

		String text2 = renderer.renderMacro("test_macro2", attributes,
				new String[] { "x" });
		assertEquals("1-1-2", text2);
	}

}
