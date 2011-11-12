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

package org.jannocessor.syntax;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import jsyntaxpane.DefaultSyntaxKit;
import jsyntaxpane.Lexer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JavaTemplateKit extends DefaultSyntaxKit {

	private static final long serialVersionUID = 1L;

	private final Logger logger = LoggerFactory.getLogger("UI");

	public JavaTemplateKit() {
		super(new JavaTemplateLexer());
		setConfiguration();
	}

	private void setConfiguration() {
		try {
			Properties config = new Properties();
			InputStream stream = getClass().getClassLoader()
					.getResourceAsStream("syntax.properties");
			config.load(new InputStreamReader(stream));
			stream.close();
			setConfig(config);
		} catch (Exception e) {
			logger.warn("Cannot initialize syntax editor", e);
		}
	}

	public JavaTemplateKit(Lexer lexer) {
		super(lexer);
	}

}
