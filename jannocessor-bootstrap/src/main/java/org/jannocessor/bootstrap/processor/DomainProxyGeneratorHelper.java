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

package org.jannocessor.bootstrap.processor;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.domain.executable.JavaMethod;

public class DomainProxyGeneratorHelper {

	public String fieldName(JavaMethod method) {
		String name = method.getName().getText();
		if (name.startsWith("get")) {
			return StringUtils.uncapitalize(name.substring(3));
		} else {
			return "_" + name;
		}
	}

	public boolean isIdentityProperty(JavaMethod method) {
		String name = method.getName().getText();
		return !name.equals("getParent")
				&& (name.startsWith("get") || name.startsWith("is"));
	}
}
