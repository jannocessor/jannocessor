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

package org.jannocessor.service.configuration;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.jannocessor.JannocessorException;
import org.jannocessor.context.Config;
import org.jannocessor.context.Configuration;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JannocessorInput;
import org.jannocessor.util.Jannocessor;
import org.jannocessor.util.Settings;

public class ConfiguratorImpl implements Configurator, Settings {

	private Configuration general;

	private Configuration annotations;

	private Configuration processors;

	private final JannocessorInput input;

	@Inject
	public ConfiguratorImpl(JannocessorInput input) throws JannocessorException {
		this.input = input;
		initialize();
	}

	private void initialize() throws JannocessorException {
		general = new Config(new HashMap<String, String>());

		annotations = new Config(new HashMap<String, String>());

		processors = new Config(new HashMap<String, String>());
	}

	@Override
	public final String[] getRulesFilenames() throws JannocessorException {
		return general.getMandatoryValues("rules");
	}

	@Override
	public Class<?> getProcessorsConfiguration() throws JannocessorException {
		try {
			return Class.forName(PROCESSORS_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw Jannocessor.error("Couldn't find settings class: "
					+ PROCESSORS_CLASSNAME, e);
		}
	}

	@Override
	public String getAnnotationLabel(String annotation)
			throws JannocessorException {
		Set<Entry<String, String>> properties = annotations.getAllProperties()
				.entrySet();

		for (Entry<String, String> entry : properties) {
			if (entry.getValue().equals(annotation)) {
				return entry.getKey();
			}
		}

		throw new JannocessorException("Cannot find name of annotation: "
				+ annotation);
	}

	@Override
	public String[] getProcessedRules() throws JannocessorException {
		Collection<String> rules = processors.getAllProperties().keySet();
		return rules.toArray(new String[rules.size()]);
	}

	@Override
	public Map<String, String> getRulesProcessors() throws JannocessorException {
		return Collections.unmodifiableMap(processors.getAllProperties());
	}

	@Override
	public String getProfile() {
		return input.getOptions().getOptionalValue(OPTION_PROFILE, null);
	}

	@Override
	public String getTemplatesPath() throws JannocessorException {
		return input.getOptions().getOptionalValue(OPTION_TEMPLATES_PATH, null);
	}

	@Override
	public String getResourcesPath() throws JannocessorException {
		return "";
	}

	@Override
	public String getRulesPath() throws JannocessorException {
		return mergePath(getResourcesPath(), "rules");
	}

	@Override
	public String getConfigPath() throws JannocessorException {
		return mergePath(getResourcesPath(), "config");
	}

	@Override
	public String getAnnotationConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(ANNOTATIONS_PROPERTIES)
				+ ".properties");
	}

	@Override
	public String getGeneralConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(GENERAL_PROPERTIES)
				+ ".properties");
	}

	@Override
	public String getProcessorsConfigFilename() throws JannocessorException {
		return mergePath(getConfigPath(), modeName(PROCESSORS_PROPERTIES)
				+ ".properties");
	}

	@Override
	public final String getKnowledgeBaseFilename() {
		return KNOWLEDGE_BASE;
	}

	private String modeName(String filename) {
		String mode = getProfile();
		if (mode != null) {
			return filename + "-" + mode;
		} else {
			return filename;
		}
	}

	private String mergePath(String part1, String part2) {
		if (part1.isEmpty() || part1.endsWith("/")) {
			return part1 + part2;
		} else {
			return part1 + "/" + part2;
		}
	}

}
