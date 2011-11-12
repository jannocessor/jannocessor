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

package org.jannocessor.service.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.jannocessor.JannocessorException;
import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.util.Settings;

public class ConfigLoaderImpl implements ConfigLoader, Settings {

	@Override
	public Map<String, String> loadProperties(String filename)
			throws JannocessorException {
		try {
			Properties properties = new Properties();
			properties.load(loadResource(filename));

			Map<String, String> map = new HashMap<String, String>();
			for (Entry<Object, Object> entry : properties.entrySet()) {
				map.put(entry.getKey().toString(), entry.getValue().toString());
			}

			return map;
		} catch (Exception e) {
			throw new JannocessorException("Cannot load configuration file: "
					+ filename, e);
		}
	}

	private InputStream loadResource(String filename) throws IOException {
		try {
			return read(filename);
		} catch (Exception e) {
			return read("src/main/resources/" + filename);
		}
	}

	private InputStream read(String filename) throws IOException {
		return getClass().getClassLoader().getResourceAsStream(filename);
	}

}
