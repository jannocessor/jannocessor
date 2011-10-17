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

import java.util.Collection;

import org.jannocessor.model.Name;
import org.jannocessor.model.code.JavaCodeModel;
import org.jannocessor.model.code.SourceCode;

public class ToStringUtil {

	private static final Class<?>[] API_TYPES = { JavaCodeModel.class,
			Name.class, SourceCode.class };

	public static String describe(Object value) {
		if (value == null) {
			return "NULL";
		} else if (value instanceof Collection) {
			return collectionToString(value);
		} else if (value.getClass().getCanonicalName().startsWith("java.")) {
			return String.valueOf(value);
		} else if (value instanceof JavaCodeModel) {
			return modelToString((JavaCodeModel) value);
		} else {
			return String.format("(%s...)", value.getClass());
		}

	}

	private static String collectionToString(Object value) {
		Collection<?> collection = (Collection<?>) value;
		if (!collection.isEmpty()) {
			return String.format("[%s items]", collection.size());
		} else {
			return "[]";
		}
	}

	private static String modelToString(JavaCodeModel model) {
		for (Class<?> interfacee : model.getClass().getInterfaces()) {
			for (Class<?> apiType : API_TYPES) {
				if (apiType.isAssignableFrom(interfacee)) {
					return String.format("(%s...)", interfacee.getSimpleName());
				}
			}
		}

		throw new IllegalStateException("Invalid code model!");
	}

}
