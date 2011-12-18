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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jannocessor.JannocessorException;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.util.Classes;
import org.jannocessor.model.util.Fields;
import org.jannocessor.model.util.New;
import org.jannocessor.processor.api.RenderData;
import org.jannocessor.processor.api.RenderRegister;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.JavaRepresenter;
import org.mockito.Mockito;

public class RenderPreviewUtil {

	public static void main(String[] args) throws JannocessorException {
		Map<String, Object> attr = new HashMap<String, Object>();
		JavaClass classs = New.classs(Classes.PUBLIC_FINAL, "MyClass");
		attr.put("self", classs);

		classs.getFields().add(New.field(Fields.PRIVATE, String.class, "prvo"));
		classs.getFields().add(New.field(Fields.PRIVATE, int.class, "vtoro"));

		RenderRegister renderRegister = Mockito.mock(RenderRegister.class);

		List<RenderData> renderings = new ArrayList<RenderData>();
		renderings.add(new SimpleRenderData(attr, null));
		Mockito.when(renderRegister.getRenderings()).thenReturn(renderings);

		Configurator configurator = Mockito.mock(Configurator.class);
		Mockito.when(configurator.getTemplatesPath()).thenReturn(null);

		JavaRepresenter representer = Mockito.mock(JavaRepresenter.class);

		RenderPreview.showDialog(null, renderRegister, configurator, representer);
	}

}
