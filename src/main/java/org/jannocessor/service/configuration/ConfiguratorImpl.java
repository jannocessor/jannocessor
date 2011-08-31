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

package org.jannocessor.service.configuration;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import javax.inject.Inject;

import org.jannocessor.model.Config;
import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.service.api.Configuratîr;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.util.Settings;

public class ConfiguratorImpl implements Configuratîr, Settings {

	private Config general;

	private Config annotations;

	@Inject
	public ConfiguratorImpl(ConfigLoader loader, PathLocator locator)
			throws JannocessorException {
		String generalFilename = locator.getGeneralConfigFilename();
		general = new Config(loader.loadProperties(generalFilename));

		String annotationsFilename = locator.getAnnotationConfigFilename();
		annotations = new Config(loader.loadProperties(annotationsFilename));
	}

	@Override
	public final String[] getRulesFilenames() throws JannocessorException {
		return general.getMandatoryValues("rules");
	}

	@Override
	public Set<String> getSupportedAnnotations() throws JannocessorException {
		return new HashSet<String>(annotations.getAllProperties().values());
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

}
