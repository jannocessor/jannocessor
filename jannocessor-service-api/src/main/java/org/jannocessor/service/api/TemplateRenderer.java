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

public interface TemplateRenderer {

	void configure(String templatesPath, boolean debugMode)
			throws JannocessorException;

	String renderMacro(String macro, Map<String, Object> attributes,
			String[] params) throws JannocessorException;

	String render(String template, Map<String, Object> attributes)
			throws JannocessorException;

	String renderFromFile(String templateFilename,
			Map<String, Object> attributes) throws JannocessorException;

}
