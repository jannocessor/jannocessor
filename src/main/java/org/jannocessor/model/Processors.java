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

public class Processors {

	@SuppressWarnings("unchecked")
	private static final Class<? extends AnnotationProcessor>[] PROCESSORS = new Class[] { ProcessorA.class, };

	private Map<String, AnnotationProcessor> processors = new HashMap<String, AnnotationProcessor>();

	public Processors() {
		for (Class<? extends AnnotationProcessor> clazz : PROCESSORS) {
			try {
				AnnotationProcessor processor = clazz.newInstance();
				processors.put(processor.getName(), processor);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	public void process(String ruleName, ProcessingContext context, Object[] args) {
		processors.get(ruleName).process(context, args);
	}
}