package org.jannocessor.model.util;

public class Templates {

	public static String defaultName(Class<?> clazz) {
		String name = clazz.getSimpleName();
		if (!name.startsWith("Java") || !name.endsWith("Bean")) {
			throw new IllegalArgumentException(
					"The class name must start with 'Java' and end with 'Bean'!");
		}

		name = name.substring(4, name.length() - 4);
		name = name.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
		name = "default/" + name;

		return name;
	}

}
