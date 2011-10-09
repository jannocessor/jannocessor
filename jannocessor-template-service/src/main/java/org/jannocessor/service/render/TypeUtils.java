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

package org.jannocessor.service.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.jannocessor.model.Name;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.service.api.ImportOrganizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TypeUtils {

	private Logger logger = LoggerFactory.getLogger("TYPES");

	private final ImportOrganizer importOrganizer;
	private List<String> typeImports = new ArrayList<String>();

	public TypeUtils(ImportOrganizer importOrganizer) {
		this.importOrganizer = importOrganizer;
	}

	public String useType(Object type) {
		if (type instanceof JavaType) {
			return getTypeUsage(((JavaType) type).getCanonicalName().getText());
		} else if (type instanceof Name) {
			return getTypeUsage(((Name) type).getText());
		} else {
			return getTypeUsage(String.valueOf(type));
		}
	}

	private String getTypeUsage(String type) {
		logger.debug("Using type: {}", type);

		String[] imports = importOrganizer.getTypeImports(type);
		String typeUsage = importOrganizer.getTypeUsage(type);

		List<String> newImports = Arrays.asList(imports);
		if (!newImports.isEmpty()) {
			logger.debug("Adding {} new imports: {}", newImports.size(), newImports);
		}
		typeImports.addAll(newImports);

		return typeUsage;
	}

	public List<String> getTypeImports() {
		return typeImports;
	}

	@Override
	public String toString() {
		return "methods=[useType($type)]";
	}
}
