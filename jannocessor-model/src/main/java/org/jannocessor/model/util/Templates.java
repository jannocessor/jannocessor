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

package org.jannocessor.model.util;

import org.jannocessor.model.JavaCodeModel;

public class Templates {

	public static String defaultName(Class<? extends JavaCodeModel> clazz) {
		String name = clazz.getSimpleName();

		if (!name.startsWith("Java")) {
			throw new IllegalArgumentException(
					"The class name must start with 'Java'!");
		}

		if (name.endsWith("Bean")) {
			name = name.substring(0, name.length() - 4);
		}

		name = name.substring(4);
		name = name.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();

		return name;
	}

}
