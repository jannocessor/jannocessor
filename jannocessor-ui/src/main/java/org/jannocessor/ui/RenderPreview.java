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

package org.jannocessor.ui;

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Code;
import org.jannocessor.processor.model.RenderRegister;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RenderPreview {

	protected static Logger logger = LoggerFactory.getLogger("UI");

	public static void showDialog(String projectPath,
			RenderRegister renderRegister) {
		logger.info("Starting UI...");
		RenderPreviewDialog dlg = new RenderPreviewDialog(projectPath,
				renderRegister);
		dlg.setVisible(true);
	}

	public static void main(String[] args) {
		// FIXME: hard-coded
		String path = "C:/java/ludvig/jannocessor/jannocessor-templates/src/main/resources/templates";

		Map<String, Object> attr = new HashMap<String, Object>();
		JavaClass classs = Code.classs(Classes.PUBLIC_FINAL, "MyClass");
		attr.put("self", classs);

		RenderRegister renderRegister = new RenderRegister();
		renderRegister.register("default/class", attr);

		showDialog(path, renderRegister);
	}
}
