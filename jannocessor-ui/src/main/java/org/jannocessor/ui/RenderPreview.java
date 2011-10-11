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

package org.jannocessor.ui;

import org.jannocessor.processor.model.RenderRegister;
import org.jannocessor.service.api.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreview {

	protected static Logger logger = LoggerFactory.getLogger("UI");

	public static void showDialog(String projectPath,
			RenderRegister renderRegister, Configurator configurator) {
		logger.info("Starting UI...");
		RenderPreviewDialog dlg = new RenderPreviewDialog(projectPath,
				renderRegister, configurator);
		dlg.setVisible(true);
	}

}
