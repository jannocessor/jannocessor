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

package org.jannocessor.service.api;

import java.util.Map;
import java.util.Set;

import org.jannocessor.processor.model.JannocessorException;

public interface Configurator {

	String[] getRulesFilenames() throws JannocessorException;

	Set<String> getSupportedAnnotations() throws JannocessorException;

	String getAnnotationLabel(String annotation) throws JannocessorException;

	String[] getProcessedRules() throws JannocessorException;

	Map<String, String> getRulesProcessors() throws JannocessorException;

	String getProfile() throws JannocessorException;

	String getResourcesPath() throws JannocessorException;

	String getRulesPath() throws JannocessorException;

	String getConfigPath() throws JannocessorException;

	String getTemplatesPath() throws JannocessorException;

	String getAnnotationConfigFilename() throws JannocessorException;

	String getGeneralConfigFilename() throws JannocessorException;

	String getKnowledgeBaseFilename() throws JannocessorException;

	String getProcessorsConfigFilename() throws JannocessorException;

}
