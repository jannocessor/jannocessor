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

import javax.inject.Inject;

import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.util.Settings;

public class PathLocatorImpl implements PathLocator, Settings {

	private final Configurator Configurator;

	@Inject
	public PathLocatorImpl(Configurator Configurator) {
		this.Configurator = Configurator;
	}

	@Override
	public String getResourcesPath() throws JannocessorException {
		return "";
	}

	@Override
	public String getRulesPath() throws JannocessorException {
		return getResourcesPath() + "rules";
	}

	@Override
	public String getConfigPath() throws JannocessorException {
		return getResourcesPath() + "config";
	}

	@Override
	public String getTemplatesPath() throws JannocessorException {
		return getResourcesPath() + "templates";
	}

	@Override
	public String getAnnotationConfigFilename() throws JannocessorException {
		return getConfigPath() + "/" + modeName(ANNOTATIONS_PROPERTIES)
				+ ".properties";
	}

	@Override
	public String getGeneralConfigFilename() throws JannocessorException {
		return getConfigPath() + "/" + modeName(GENERAL_PROPERTIES)
				+ ".properties";
	}

	@Override
	public String getProcessorsConfigFilename() throws JannocessorException {
		return getConfigPath() + "/" + modeName(PROCESSORS_PROPERTIES)
				+ ".properties";
	}

	@Override
	public final String getKnowledgeBaseFilename() {
		return KNOWLEDGE_BASE;
	}

	private String modeName(String filename) {
		String mode = Configurator.getProfile();
		if (mode != null) {
			return filename + "-" + mode;
		} else {
			return filename;
		}
	}

}
