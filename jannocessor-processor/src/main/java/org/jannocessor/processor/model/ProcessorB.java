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

package org.jannocessor.processor.model;

import java.util.Map;

/**
 * problems.warning(mark.element,
 * "My CUSTOM annotation %s doesn't support fields", mark.annotation);
 */
public class ProcessorB implements CodeProcessor {

	@Override
	public void process(ProcessingContext context, Map<String, Object> params) {
	}

}
