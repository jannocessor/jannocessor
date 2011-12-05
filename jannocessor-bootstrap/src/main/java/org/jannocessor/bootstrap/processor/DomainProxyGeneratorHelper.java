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

package org.jannocessor.bootstrap.processor;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.jannocessor.domain.executable.JavaMethod;

public class DomainProxyGeneratorHelper {

	private static String[] calculated = { "getCanonicalName", "isDefault", "copy", "getChildren" };

	public String fieldName(JavaMethod method) {
		String name = method.getName().getText();
		if (name.startsWith("get")) {
			return StringUtils.uncapitalize(name.substring(3));
		} else {
			return "_" + name;
		}
	}

	public boolean isGetter(JavaMethod method) {
		String name = method.getName().getText();
		return name.startsWith("get") || name.startsWith("is");
	}

	public boolean isIdentityProperty(JavaMethod method) {
		String name = method.getName().getText();
		return !name.equals("getParent") && !name.equals("getChildren") && isGetter(method)
				&& !isCalculated(method);
	}

	public boolean isCalculated(JavaMethod method) {
		// FIXME: use metadata to check if it is calculated
		String name = method.getName().getText();
		return ArrayUtils.contains(calculated, name);
	}

	public boolean isToStringMember(JavaMethod method) {
		String name = method.getName().getText();
		return isIdentityProperty(method)
				|| (isCalculated(method) && isGetter(method) && !"getChildren".equals(name));
	}

}
