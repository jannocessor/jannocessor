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

package org.jannocessor.model.util;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.introspection.API;
import org.jannocessor.util.Check;

public class Templates {

	public static String defaultName(Class<? extends JavaCodeModel> interfacee) {
		String name = interfacee.getSimpleName();

		Check.argument(interfacee.isInterface(),
				"Expected code model API interface!");

		Check.argument(name.startsWith("Java"),
				"The interface name must start with 'Java'!");

		if (API.TYPE.contains(interfacee)) {
			name = "type";
		} else {
			name = name.substring(4); // without the "Java" prefix
			name = name.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
		}

		return "render_" + name;
	}

}
