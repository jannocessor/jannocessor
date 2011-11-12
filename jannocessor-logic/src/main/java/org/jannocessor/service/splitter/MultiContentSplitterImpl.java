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

package org.jannocessor.service.splitter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jannocessor.service.api.MultiContentSplitter;

public class MultiContentSplitterImpl implements MultiContentSplitter {

	@Override
	public Map<String, String> split(String contents) {
		Map<String, String> parts = new LinkedHashMap<String, String>();

		String prefix = Pattern.quote(PREFIX);
		String suffix = Pattern.quote(SUFFIX);
		String space = "\\s+";
		String caption = "([^\\s]*?)";
		String regex = "(?m)^" + prefix + space + caption + space + suffix
				+ "\\r?\\n";

		Matcher matcher = Pattern.compile(regex).matcher(contents);

		String prevKey = null;
		int pos = 0;
		while (matcher.find(pos)) {
			String key = matcher.group(1).trim();
			if (key.isEmpty()) {
				throw new RuntimeException(String.format(
						"Expected value inside %s and %s", PREFIX, SUFFIX));
			}

			if (pos > 0) {
				String content = removeNewLine(contents.substring(pos,
						matcher.start()));
				parts.put(prevKey, content);
			}
			pos = matcher.end();
			prevKey = key;
		}

		if (prevKey != null) {
			String content = removeNewLine(contents.substring(pos));
			parts.put(prevKey, content);
		}

		return parts;
	}

	private String removeNewLine(String s) {
		return s.replaceFirst("\\r?\\n$", "");
	}

}
