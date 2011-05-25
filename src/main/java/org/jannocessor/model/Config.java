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

package org.jannocessor.model;

import java.util.Collections;
import java.util.Map;

import org.jannocessor.facade.JannocessorException;

public class Config {

	private static final String SEPARATOR = "\\,";

	private final Map<String, String> values;

	public Config(Map<String, String> values) {
		this.values = values;
	}

	public String[] getMandatoryValues(String key) throws JannocessorException {
		return splitValues(getMandatoryValue(key));
	}

	public String getMandatoryValue(String key) throws JannocessorException {
		String value = getProperty(key, null);

		if (value == null) {
			throw new JannocessorException(String.format(
					"Property %s is mandatory!", key));
		}

		return value;
	}

	public String[] getOptionalValues(String key, String defaultValue) {
		return splitValues(getOptionalValue(key, defaultValue));
	}

	private String[] splitValues(String value) {
		if (value != null) {
			return value.split(SEPARATOR);
		} else {
			return null;
		}
	}

	public String getOptionalValue(String key, String defaultValue) {
		return getProperty(key, defaultValue);
	}

	private String getProperty(String key, String defaultValue) {
		String value = values.get(key);

		if (value == null) {
			value = defaultValue;
		}

		return value;
	}

	public Map<String, String> getAllProperties() throws JannocessorException {
		return Collections.unmodifiableMap(values);
	}

}
