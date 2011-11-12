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

package org.jannocessor.service.imports;

import java.util.List;

import org.apache.commons.lang.StringUtils;

public class ParsedTypeName {

	private final String packageName;
	private final String className;
	private final List<ParsedTypeNameParam> params;
	private final int arrayDimensions;

	public ParsedTypeName(String packageName, String className,
			List<ParsedTypeNameParam> generics, int arrayDimensions) {
		this.packageName = packageName;
		this.className = className;
		this.params = generics;
		this.arrayDimensions = arrayDimensions;
	}

	public String getPackageName() {
		return packageName;
	}

	public int getArrayDimensions() {
		return arrayDimensions;
	}

	public String getClassName() {
		return className;
	}

	public List<ParsedTypeNameParam> getParams() {
		return params;
	}

	@Override
	public String toString() {
		return getGenericType() + getArrayPart() + "<" + params + ">";
	}

	public String getArrayPart() {
		return StringUtils.repeat("[]", arrayDimensions);
	}

	public String getGenericType() {
		return packageName + "." + className;
	}

	public boolean isSimple() {
		return packageName == null && params.isEmpty();
	}
}