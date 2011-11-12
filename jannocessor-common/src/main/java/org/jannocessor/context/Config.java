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

package org.jannocessor.context;

import java.util.Collections;
import java.util.Map;

import org.jannocessor.JannocessorException;

public class Config implements Configuration {

	private static final String SEPARATOR = "\\,";

	private final Map<String, String> values;

	public Config(Map<String, String> values) {
		this.values = values;
	}

	@Override
	public String[] getMandatoryValues(String key) throws JannocessorException {
		return splitValues(getMandatoryValue(key));
	}

	@Override
	public String getMandatoryValue(String key) throws JannocessorException {
		String value = getProperty(key, null);

		if (value == null) {
			throw new JannocessorException(String.format(
					"Property %s is mandatory!", key));
		}

		return value;
	}

	@Override
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

	@Override
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

	@Override
	public Map<String, String> getAllProperties() throws JannocessorException {
		return Collections.unmodifiableMap(values);
	}

}
