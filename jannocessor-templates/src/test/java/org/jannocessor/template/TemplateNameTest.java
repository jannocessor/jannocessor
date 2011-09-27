package org.jannocessor.template;

import java.net.URL;

import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.introspection.API;
import org.jannocessor.model.util.Templates;
import org.junit.Assert;
import org.junit.Test;

public class TemplateNameTest {

	@Test
	public void testTemplateNames() {
		for (Class<? extends JavaCodeModel> clazz : API.ALL) {
			String name = Templates.defaultName(clazz);
			String fullName = "templates/" + name + ".vm";
			URL url = getClass().getClassLoader().getResource(fullName);
			Assert.assertNotNull("Cannot find template: " + fullName, url);
		}
	}

}
