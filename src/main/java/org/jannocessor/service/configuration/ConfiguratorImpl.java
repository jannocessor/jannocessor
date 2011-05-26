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

import org.jannocessor.model.Config;
import org.jannocessor.service.api.Configuratîr;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.util.Settings;

public class ConfiguratorImpl implements Configuratîr, Settings {

	private final Config general;

	private final Config annotations;

	public ConfiguratorImpl(Config general, Config annotations) {
		this.general = general;
		this.annotations = annotations;
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
