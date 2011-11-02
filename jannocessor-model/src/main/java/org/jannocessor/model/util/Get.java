package org.jannocessor.model.util;

import org.jannocessor.collection.transform.api.Transformation;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.Name;

public class Get {

	public static final Transformation<JavaElement, Name> NAME;

	static {
		NAME = new Transformation<JavaElement, Name>() {
			@Override
			public Name transform(JavaElement input) {
				return input.getName();
			}

		};
	}

}
