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

import javax.annotation.Generated;

import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.util.New;
import org.jannocessor.model.util.Methods;
import org.jannocessor.processor.model.CodeProcessor;
import org.jannocessor.processor.model.ProcessingContext;

public class ExperimentProcessor implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
		AbstractJavaStructure model = (AbstractJavaStructure) params
				.get("model");

		context.getLogger().debug("Processing: {} ", model.getName());

		model.getName().appendPart("Gen");

		JavaMetadata meta1 = New.metadata(Generated.class, "Jannocessor Test");
		model.getMetadata().add(meta1);

		JavaMethod method1 = New.method(Methods.PUBLIC, String.class, "cool");
		method1.getBody().setCode("return \"COOL!\";");
		model.getMethods().add(method1);

		context.generateCode(model, true);
	}

}
