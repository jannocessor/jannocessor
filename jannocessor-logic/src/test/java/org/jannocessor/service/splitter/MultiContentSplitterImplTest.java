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

import java.util.Map;

import junit.framework.Assert;

import org.jannocessor.service.api.MultiContentSplitter;
import org.junit.Test;

public class MultiContentSplitterImplTest {

	private static final String FILE1 = "a/b/c/foo.txt";
	private static final String FILE2 = "xx/yy/zz/bar";

	private static final String CONTENT1 = "content1";
	private static final String CONTENT2 = "content2\ncontent22";

	private MultiContentSplitter splitter = new MultiContentSplitterImpl();

	@Test
	public void shouldSplitByMultipleFileMarkers() {
		String part1 = fileContentN(marker(FILE1), CONTENT1);
		String part2 = fileContentRN(marker(FILE2), CONTENT2);

		Map<String, String> files = splitter.split(part1 + part2);

		Assert.assertEquals(2, files.size());
		Assert.assertEquals(CONTENT1, files.get(FILE1));
		Assert.assertEquals(CONTENT2, files.get(FILE2));
	}

	@Test
	public void shouldWorkWithOneFileMarker() {
		String contents = fileContentRN(marker(FILE1), CONTENT1);

		Map<String, String> files = splitter.split(contents);

		Assert.assertEquals(1, files.size());
		Assert.assertEquals(CONTENT1, files.get(FILE1));
	}

	@Test
	public void shouldWorkWithoutFileMarkers() {
		Map<String, String> files = splitter.split(CONTENT1);

		Assert.assertEquals(0, files.size());
	}

	@Test(expected = RuntimeException.class)
	public void shouldThrowExceptionOnInvalidFileMarker() {
		String part1 = fileContentN(marker(FILE1), CONTENT1);
		String part2 = fileContentRN(marker("   "), CONTENT2);

		splitter.split(part1 + part2); // should throw exception
	}

	private String marker(String filename) {
		return String.format("%s %s %s", MultiContentSplitter.PREFIX, filename,
				MultiContentSplitter.SUFFIX);
	}

	private String fileContentN(String marker, String content) {
		return String.format("%s\n%s\n", marker, content);
	}

	private String fileContentRN(String marker, String content) {
		return String.format("%s\r\n%s\r\n", marker, content);
	}

}
