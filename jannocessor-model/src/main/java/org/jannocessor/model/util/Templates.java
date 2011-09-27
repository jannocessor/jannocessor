package org.jannocessor.model.util;

import org.jannocessor.model.code.JavaCodeModel;

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
		name = "default/" + name;

		return name;
	}

}
