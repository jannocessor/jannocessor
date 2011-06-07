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

import java.util.HashSet;
import java.util.Set;

import org.jannocessor.service.api.ImportOrganizer;

public class ImportOrganizerImpl implements ImportOrganizer {

	private static final String JAVA_LANG = "java.lang.";

	private Set<String> importedSimple = new HashSet<String>();

	private Set<String> importedFull = new HashSet<String>();

	@Override
	public String getTypeImport(String classname) {
		String simpleName = extractSimpleName(classname);

		if (!classname.startsWith(JAVA_LANG)) {
			if (!importedSimple.contains(simpleName)) {
				importedSimple.add(simpleName);
				importedFull.add(classname);
				return classname;
			}
		}

		return null;
	}

	@Override
	public String getTypeUsage(String classname) {
		String simpleName = extractSimpleName(classname);

		if (classname.startsWith(JAVA_LANG) || importedFull.contains(classname)) {
			return simpleName;
		} else {
			return classname;
		}
	}

	private String extractSimpleName(String classname) {
		int pos = classname.lastIndexOf('.');
		return classname.substring(pos + 1);
	}

}