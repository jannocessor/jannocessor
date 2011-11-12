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

package org.jannocessor.service.api;

import java.util.Map;

import org.jannocessor.JannocessorException;

public interface Configurator {

	String[] getRulesFilenames() throws JannocessorException;

	Class<?> getProcessorsConfiguration() throws JannocessorException;

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
