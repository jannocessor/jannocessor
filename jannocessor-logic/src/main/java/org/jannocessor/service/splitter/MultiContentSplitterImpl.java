/**
 * Copyright 2011 Nikolche Mihajlovski
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
