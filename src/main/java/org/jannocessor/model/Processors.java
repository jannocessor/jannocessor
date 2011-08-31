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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Processors {

	private final Map<String, String> rulesProcessors;

	private final Map<String, CodeProcessor> processors = new HashMap<String, CodeProcessor>();

	public Processors(Map<String, String> rulesProcessors) {
		this.rulesProcessors = rulesProcessors;
	}

	public void process(String ruleName, ProcessingContext context,
			Map<String, Object> params) {
		params = Collections.unmodifiableMap(params);
		getProcessor(ruleName).process(context, params);
	}

	private CodeProcessor getProcessor(String ruleName) {
		CodeProcessor processor = processors.get(ruleName);
		if (processor == null) {
			String className = rulesProcessors.get(ruleName);
			try {
				processor = (CodeProcessor) Class.forName(className)
						.newInstance();
				processors.put(ruleName, processor);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return processor;
	}
}