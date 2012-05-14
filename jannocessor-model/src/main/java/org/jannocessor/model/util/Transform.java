package org.jannocessor.model.util;

import org.jannocessor.collection.transform.api.Transformation;

public class Transform {

	public static final Transformation<Object, String> TO_STRING;

	static {
		TO_STRING = new Transformation<Object, String>() {
			@Override
			public String transform(Object codeNode) {
				return codeNode.toString();
			}

		};
	}

	public static Transformation<String, String> append(final String suffix) {
		return new Transformation<String, String>() {
			@Override
			public String transform(String s) {
				return s + suffix;
			}

		};
	}

	public static Transformation<String, String> surround(final String prefix, final String suffix) {
		return new Transformation<String, String>() {
			@Override
			public String transform(String s) {
				return prefix + s + suffix;
			}

		};
	}

	public static Transformation<String, String> prepend(final String prefix) {
		return new Transformation<String, String>() {
			@Override
			public String transform(String s) {
				return prefix + s;
			}

		};
	}

}
