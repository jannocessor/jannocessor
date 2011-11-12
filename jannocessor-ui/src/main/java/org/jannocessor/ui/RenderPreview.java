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

package org.jannocessor.ui;

import org.jannocessor.JannocessorException;
import org.jannocessor.context.RenderRegister;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreview {

	protected static Logger logger = LoggerFactory.getLogger("UI");

	public static void showDialog(String projectPath,
			RenderRegister renderRegister, Configurator configurator,
			JavaRepresenter representer) throws JannocessorException {
		if (!renderRegister.getRenderings().isEmpty()) {
			logger.info("Starting UI...");
			RenderPreviewDialog dlg = new RenderPreviewDialog(projectPath,
					renderRegister, configurator, representer);
			dlg.setVisible(true);
		}
	}

}
