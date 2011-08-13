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

package org.jannocessor.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.preview.RenderPreview;

/*
 * model = mark.element # fields = mark.element.fields
 * name = mark.element.name + "Generated";
 *  
 * file = files.file("domain", name, "java", "javabean"); 
 * file.data.set("element", mark.element).set("name", name).set("fields", fields);
 */
public class ProcessorA implements AnnotationProcessor {

	@Override
	public void process(ProcessingContext context, Object[] args) {
		JavaClass clazz = (JavaClass) args[0];

		Properties p = new Properties();
		p.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("clazz", clazz);

		// TODO: render!
	}

	@Override
	public String getName() {
		return "Annotations";
	}

}
