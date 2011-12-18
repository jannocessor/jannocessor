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

package org.jannocessor.extra.merge;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jannocessor.processor.api.FileInformation;
import org.jannocessor.processor.api.CodeMerger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MarkedCodeSegmentMerger implements CodeMerger {

	public static final String START = "// Custom hand-written code starts here";
	public static final String END = "// Custom hand-written code ends here";

	private final Logger logger = LoggerFactory.getLogger(getClass());

	private final Pattern pattern;
	private final String from;
	private final String to;

	public MarkedCodeSegmentMerger() {
		this(START, END);
	}

	public MarkedCodeSegmentMerger(String from, String to) {
		this.from = from;
		this.to = to;
		pattern = Pattern.compile(constructRegex(from, to));
	}

	private String constructRegex(String from, String to) {
		return "(?smi)" + Pattern.quote(from) + "(.*?)" + Pattern.quote(to);
	}

	public String mergeCode(FileInformation oldCode, FileInformation newCode) {
		String old = oldCode.getContent();
		String recent = newCode.getContent();

		Matcher matcherOld = pattern.matcher(old);
		Matcher matcherRecent = pattern.matcher(recent);

		String mergedCode = "";

		int beginIndex = 0;
		while (matcherOld.find()) {
			String manualCode = matcherOld.group(1);

			if (matcherRecent.find()) {
				// merge the code
				mergedCode += recent.substring(beginIndex, matcherRecent.start(1));
				mergedCode += manualCode;
				beginIndex = matcherRecent.end(1);
			} else {
				throw new IllegalArgumentException(
						String.format(
								"Didn't find manually written code within block starting with '%s' and ending with '%s'",
								from, to));
			}
		}

		if (beginIndex == 0) {
			logger.warn("Didn't merge the file: {}", oldCode.getFilename());
		}

		mergedCode += recent.substring(beginIndex);

		return mergedCode;
	}
}
