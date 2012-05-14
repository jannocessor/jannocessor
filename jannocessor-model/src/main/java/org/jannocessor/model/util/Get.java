package org.jannocessor.model.util;

import org.jannocessor.collection.transform.api.Transformation;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;

public class Get {

	public static final Transformation<JavaElement, Name> NAME;
	public static final Transformation<JavaElement, JavaType> TYPE;
	public static final Transformation<JavaType, String> FULL_NAME;

	static {
		NAME = new Transformation<JavaElement, Name>() {
			@Override
			public Name transform(JavaElement input) {
				return input.getName();
			}

		};
	}

	static {
		TYPE = new Transformation<JavaElement, JavaType>() {
			@Override
			public JavaType transform(JavaElement input) {
				return input.getType();
			}

		};
	}

	static {
		FULL_NAME = new Transformation<JavaType, String>() {
			@Override
			public String transform(JavaType type) {
				return type.getCanonicalName();
			}

		};
	}
	
}
