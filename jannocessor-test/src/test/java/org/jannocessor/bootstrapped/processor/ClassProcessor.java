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

package org.jannocessor.bootstrapped.processor;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.processor.model.CodeProcessor;
import org.jannocessor.processor.model.ProcessingContext;

public class ClassProcessor implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
		JavaClass clazz = (JavaClass) params.get("clazz");

		clazz.getName().deleteParts(1, 2);

		showDebugInfo("CLASS " + clazz.getName(), clazz.getType());

		for (JavaField field : clazz.getFields()) {
			Name name = field.getType().getCanonicalName();
			name.assign(StringUtils.removeEnd(name.getText(), "BeanModel"));

			showDebugInfo("FIELD: " + field.getName(), field.getType());
		}

		context.generateCode(clazz);
	}

	private void showDebugInfo(String msg, JavaType type) {
		System.out
				.println("*********** " + msg + " " + type.getCanonicalName());
	}
}
