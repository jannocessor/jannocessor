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

import java.util.HashMap;
import java.util.Map;

import org.jannocessor.JannocessorException;
import org.jannocessor.context.RenderRegister;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.New;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.mockito.Mockito;

public class RenderPreviewUtil {

	public static void main(String[] args) throws JannocessorException {
		// FIXME: hard-coded
		String path = "C:/java/ludvig/jannocessor/jannocessor-templates/src/main/resources/templates";

		Map<String, Object> attr = new HashMap<String, Object>();
		JavaClass classs = New.classs(Classes.PUBLIC_FINAL, "MyClass");
		attr.put("self", classs);

		classs.getFields().add(New.field(Fields.PRIVATE, String.class, "prvo"));
		classs.getFields().add(New.field(Fields.PRIVATE, int.class, "vtoro"));

		RenderRegister renderRegister = new RenderRegister();
		renderRegister.register(attr);

		Configurator configurator = Mockito.mock(Configurator.class);
		Mockito.when(configurator.getTemplatesPath()).thenReturn(path);

		JavaRepresenter representer = Mockito.mock(JavaRepresenter.class);

		RenderPreview.showDialog(path, renderRegister, configurator,
				representer);
	}

}
