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
