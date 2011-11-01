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
