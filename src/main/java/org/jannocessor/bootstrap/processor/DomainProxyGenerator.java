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

package org.jannocessor.bootstrap.processor;

import java.util.Map;

import org.jannocessor.data.JavaClassData;
import org.jannocessor.domain.type.JavaClass;
import org.jannocessor.domain.type.JavaInterface;
import org.jannocessor.model.CodeProcessor;
import org.jannocessor.model.ProcessingContext;

public class DomainProxyGenerator implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
		JavaInterface model = (JavaInterface) params.get("model");
		context.getLogger().debug("Processing annotated domain model: {}",
				model);

		JavaClass proxy = new JavaClassData();

		context.generateClass(proxy);
	}

}
