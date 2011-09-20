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

package org.jannocessor.service.rules;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.PatternService;
import org.junit.Before;
import org.junit.Test;

public class PatternServiceImplTest {

	private PatternService patternService;

	@Before
	public void initialize() {
		patternService = new PatternServiceImpl();
	}

	@Test
	public void testExtractPatternVariables() throws JannocessorException {
		checkExtractedVariables("JavaClass()");
		checkExtractedVariables("a:JavaClass()", "a");
		checkExtractedVariables("a:JavaClass()\nb : JavaField()", "a", "b");
		checkExtractedVariables(" a : JavaClass () \n b : JavaField() ", "a",
				"b");
	}

	private void checkExtractedVariables(String pattern, String... expectedVars) {
		List<String> vars = patternService.extractPatternVariables(pattern);

		assertArrayEquals(expectedVars, vars.toArray(new String[vars.size()]));
	}

}
