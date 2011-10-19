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

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.Name;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.modifier.AbstractModifiers;
import org.jannocessor.model.type.JavaTypeKind;

public class ToStringUtil {

	private static final Class<?>[] API_TYPES = { JavaCodeModel.class,
			Name.class, SourceCode.class };

	public static String describe(Object value) {
		return describe(value, true);
	}

	public static String overview(Object value) {
		return describe(value, false);
	}

	private static String describe(Object value, boolean details) {
		if (value == null) {
			return "NULL";
		} else if (value instanceof Collection) {
			return details ? collectionToString(value, true) : "[...]";
		} else if (value.getClass().getCanonicalName().startsWith("java.")) {
			return String.valueOf(value);
		} else if (value instanceof JavaCodeModel) {
			return modelToString((JavaCodeModel) value);
		} else if (value instanceof SourceCode) {
			return details ? codeToString((SourceCode) value) : "?";
		} else if (value instanceof Name) {
			return value.toString();
		} else if (value instanceof JavaElementKind) {
			return value.toString();
		} else if (value instanceof JavaTypeKind) {
			return value.toString();
		} else if (value instanceof AbstractModifiers) {
			return modifiersToString((AbstractModifiers<?, ?>) value);
		} else {
			return details ? overview(value) : "...";
		}
	}

	private static String modifiersToString(AbstractModifiers<?, ?> modifiers) {
		return Arrays.toString(modifiers.getValues());
	}

	private static String codeToString(SourceCode value) {
		return value.toString();
	}

	private static String collectionToString(Object value, boolean details) {
		Collection<?> collection = (Collection<?>) value;

		if (details) {
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for (Iterator<?> it = collection.iterator(); it.hasNext();) {
				Object item = (Object) it.next();
				sb.append(overview(item));

				if (it.hasNext()) {
					sb.append(", ");
				}
			}
			sb.append("]");
			return sb.toString();
		} else {
			return "[" + collection.size() + " items]";
		}
	}

	private static String modelToString(JavaCodeModel model) {
		for (Class<?> interfacee : model.getClass().getInterfaces()) {
			for (Class<?> apiType : API_TYPES) {
				if (apiType.isAssignableFrom(interfacee)) {
					return String.format("%s{...}", interfacee.getSimpleName());
				}
			}
		}

		throw new IllegalStateException("Invalid code model!");
	}

}
