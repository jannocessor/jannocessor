package org.jannocessor.service.render;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.test.AbstractTest;
import org.junit.Before;
import org.junit.Test;

public class VelocityTemplateRendererTest extends AbstractTest {

	private TemplateRenderer renderer;

	@Before
	public void initialize() {
		renderer = new VelocityTemplateRenderer();
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
