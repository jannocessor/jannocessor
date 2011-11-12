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

package org.jannocessor.service.representation;

import org.apache.commons.lang.StringEscapeUtils;
import org.jannocessor.service.api.JavaRepresenter;

class JavaRepresenterImpl implements JavaRepresenter {

	@Override
	public String getJavaRepresentation(Object value) {
		if (value instanceof String) {
			return getStringRepresentation((String) value);
		} else if (value instanceof Class<?>) {
			return getClassRepresentation((Class<?>) value);
		} else {
			return String.valueOf(value);
		}
	}

	private String getClassRepresentation(Class<?> clazz) {
		return clazz.getSimpleName() + ".class";
	}

	private String getStringRepresentation(String value) {
		return '"' + StringEscapeUtils.escapeJava(value) + '"';
	}

}
