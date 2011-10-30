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
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.util.Check;

public class ValidationUtils {

	public static void validate(AbstractJavaStructure model) {
		for (JavaMethod member : model.getMethods()) {
			checkParent(model, member);
		}

		for (JavaMetadata member : model.getMetadata()) {
			checkParent(model, member);
		}
	}

	private static void checkParent(JavaCodeModel parent, JavaCodeModel child) {
		Check.notNull(parent, "Parent cannot be null!");
		Check.notNull(child, "Child cannot be null!");
		Check.state(child.getParent() == parent,
				"Invalid member parent! DIFF:=====\n" + parent + "\n=====\n"
						+ child + "\n=====");
	}

}
