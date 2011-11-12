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

package org.jannocessor.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jannocessor.JannocessorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Jannocessor {

	private static final Logger CLASS_LOADER_LOGGER = LoggerFactory.getLogger("CLASS");

	public static JannocessorException error(String message) {
		return new JannocessorException(message);
	}

	public static JannocessorException error(String message, Exception cause) {
		return new JannocessorException(message, cause);
	}

	public static ClassLoader createClassLoader(List<String> classNames) {
		ClassLoader parentClassLoader = JannocessorClassLoader.class.getClassLoader();
		return new JannocessorClassLoader(parentClassLoader, classNames, CLASS_LOADER_LOGGER);
	}

	public static Class<?> reloadClass(String classname, Collection<String> additionalClassnames) {
		List<String> classnames = new ArrayList<String>();
		classnames.add(classname);
		classnames.addAll(additionalClassnames);

		ClassLoader classLoader = Jannocessor.createClassLoader(classnames);
		try {
			return classLoader.loadClass(classname);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Hot swap failed!", e);
		}
	}

}
