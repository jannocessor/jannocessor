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

import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.util.Code;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.SourceCodeRenderer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class DefaultSourceCodeRendererTest {

	private SourceCodeRenderer renderer;

	@Before
	public void initialize() throws JannocessorException {
		Configurator configurator = Mockito.mock(Configurator.class);
		Mockito.when(configurator.getTemplatesPath()).thenReturn("templates");

		TypeUtils typeUtils = Mockito.mock(TypeUtils.class);

		renderer = new DefaultSourceCodeRenderer(new VelocityTemplateRenderer(
				configurator), configurator, typeUtils);
	}

	@Test
	public void testDefaultRender() throws JannocessorException {
		JavaField field = Code.field(Fields.PRIVATE, String.class, "f1");

		checkRendering(field, "default:f1");
	}

	@Test
	public void testRenderCode() throws JannocessorException {
		JavaField field = Code.field(Fields.PRIVATE, String.class, "foo");
		field.getCode().setCode("code");

		checkRendering(field, "code");
	}

	@Test
	public void testRenderTemplate() throws JannocessorException {
		JavaField field = Code.field(Fields.PRIVATE, String.class, "bar");
		field.getCode().setTemplate("($self.name)");

		checkRendering(field, "(bar)");
	}

	@Test
	public void testRenderTemplateByName() throws JannocessorException {
		JavaField field = Code.field(Fields.PRIVATE, String.class, "foo");
		field.getCode().setTemplateName("field");

		checkRendering(field, "(foo)");
	}

	private void checkRendering(JavaCodeModel codeModel, String expected) {
		Assert.assertEquals(expected, renderer.render(codeModel));
	}

}
