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

package org.jannocessor.template;

import java.net.URL;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.introspection.API;
import org.jannocessor.model.util.Templates;
import org.junit.Assert;
import org.junit.Test;

public class TemplateNameTest {

	@Test
	public void testTemplateNames() {
		for (Class<? extends JavaCodeModel> clazz : API.ALL) {
			String name = Templates.defaultName(clazz);
			Assert.assertTrue(name.startsWith("render_"));
			String fullName = name.substring(7) + ".vm";
			URL url = getClass().getClassLoader().getResource(fullName);
			Assert.assertNotNull("Cannot find template: " + fullName, url);
		}
	}

}
