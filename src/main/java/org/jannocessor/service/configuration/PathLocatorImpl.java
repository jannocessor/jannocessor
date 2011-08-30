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

import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.util.Settings;

public class PathLocatorImpl implements PathLocator, Settings {

	@Override
	public String getResourcesPath() throws JannocessorException {
		return "src/test/resources/";
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
		return getConfigPath() + "/" + ANNOTATIONS_PROPERTIES;
	}

	@Override
	public String getGeneralConfigFilename() throws JannocessorException {
		return getConfigPath() + "/" + GENERAL_PROPERTIES;
	}

	@Override
	public final String getKnowledgeBaseFilename() {
		return KNOWLEDGE_BASE;
	}

}
