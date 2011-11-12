/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * This file is part of JAnnocessor.
 *
 * JAnnocessor is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JAnnocessor is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JAnnocessor.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jannocessor.service.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
			return getTypeUsage(((JavaType) type).getCanonicalName());
		} else if (type instanceof Name) {
			return getTypeUsage(((Name) type).getText());
		} else {
			return getTypeUsage(String.valueOf(type));
		}
	}

	private String getTypeUsage(String type) {
		String[] imports = importOrganizer.getTypeImports(type);
		String typeUsage = importOrganizer.getTypeUsage(type);

		logger.debug("Using type: {} => {}", type, typeUsage);

		List<String> newImports = Arrays.asList(imports);
		if (!newImports.isEmpty()) {
			logger.debug("Adding {} new imports: {}", newImports.size(),
					newImports);
		}
		typeImports.addAll(newImports);

		return typeUsage;
	}

	public List<String> getTypeImports() {
		Collections.sort(typeImports);
		return typeImports;
	}

	@Override
	public String toString() {
		return "methods=[useType($type)]";
	}
}
