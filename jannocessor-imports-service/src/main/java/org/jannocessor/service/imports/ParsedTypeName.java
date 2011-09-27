/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.service.imports;

import java.util.List;

public class ParsedTypeName {

	private final String packageName;
	private final String className;
	private final List<String> params;

	public ParsedTypeName(String packageName, String className,
			List<String> generics) {
		this.packageName = packageName;
		this.className = className;
		this.params = generics;
	}

	public String getPackageName() {
		return packageName;
	}

	public String getClassName() {
		return className;
	}

	public List<String> getParams() {
		return params;
	}

	@Override
	public String toString() {
		return getGenericType() + "<" + params + ">";
	}

	public String getGenericType() {
		return packageName + "." + className;
	}

	public boolean isSimple() {
		return packageName == null && params.isEmpty();
	}
}