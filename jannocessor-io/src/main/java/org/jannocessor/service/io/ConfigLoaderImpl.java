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
