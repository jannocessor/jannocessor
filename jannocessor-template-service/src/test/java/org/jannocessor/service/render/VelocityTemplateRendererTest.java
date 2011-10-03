/**
 * Copyright 2011 jannocessor.org
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

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
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

		renderer = new VelocityTemplateRenderer(configurator);
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

}
