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

package org.jannocessor.service.io;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.drools.io.Resource;
import org.drools.io.ResourceFactory;
import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.util.Settings;

public class ConfigLoaderServiceImpl implements ConfigLoader, Settings {

	@Override
	public Map<String, String> loadProperties(String filename)
			throws JannocessorException {
		try {
			Resource resource = ResourceFactory.newClassPathResource(filename);
			Properties properties = new Properties();
			properties.load(resource.getInputStream());

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

}
