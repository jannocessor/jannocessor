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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jannocessor.service.api.PatternService;

public class PatternServiceImpl implements PatternService {

	@Override
	public List<String> extractPatternVariables(String pattern) {
		List<String> vars = new ArrayList<String>();

		Matcher matcher = Pattern.compile("(?sm)^\\s*?([a-z]\\w*?)\\s*?:")
				.matcher(pattern);

		while (matcher.find()) {
			String var = matcher.group(1);
			vars.add(var);
		}

		return vars;
	}

}
