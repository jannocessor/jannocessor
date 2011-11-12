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

package org.jannocessor.service.rules;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;

import org.jannocessor.JannocessorException;
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
