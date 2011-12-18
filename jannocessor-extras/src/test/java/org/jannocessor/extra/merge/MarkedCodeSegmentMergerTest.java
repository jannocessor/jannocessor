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

import java.util.Date;

import junit.framework.Assert;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.processor.api.FileInformation;
import org.jannocessor.processor.api.CodeMerger;
import org.junit.Test;

public class MarkedCodeSegmentMergerTest {

	private static final String FROM1 = MarkedCodeSegmentMerger.START;
	private static final String TO1 = MarkedCodeSegmentMerger.END;

	private static final String FROM2 = "(FROM)";
	private static final String TO2 = "(TO)";

	private final CodeMerger merger = new MarkedCodeSegmentMerger();
	private final CodeMerger customMerger = new MarkedCodeSegmentMerger(FROM2, TO2);

	@Test
	public void shouldOverwriteContentWithoutCustomParts() {
		String old = lines("aaa1", "bbb1", "ccc1");
		String recent = lines("aaa2", "bbb2", "ccc2");

		String merged = merger.mergeCode(info(old), info(recent));

		Assert.assertEquals(recent, merged);
	}

	@Test
	public void shouldMergeSinglePartContent() {
		String old = lines("aaa1", FROM1, "bbb1", TO1, "ccc1");
		String recent = lines("aaa2", FROM1, "bbb2", TO1, "ccc2");
		String result = lines("aaa2", FROM1, "bbb1", TO1, "ccc2");

		String merged = merger.mergeCode(info(old), info(recent));

		Assert.assertEquals(result, merged);
	}

	@Test
	public void shouldMergeMultiplePartsContent() {
		String old = lines("aaa1", FROM1, "bbb1", TO1, "ccc1", FROM1, "ddd1", TO1, "eee1");
		String recent = lines("aaa2", FROM1, "bbb2", TO1, "ccc2", FROM1, "ddd2", TO1, "eee2");
		String result = lines("aaa2", FROM1, "bbb1", TO1, "ccc2", FROM1, "ddd1", TO1, "eee2");

		String merged = merger.mergeCode(info(old), info(recent));

		Assert.assertEquals(result, merged);
	}

	@Test
	public void shouldMergeContentWithInlineParts() {
		String old = "aaa1" + FROM2 + "bbb1" + TO2 + "ccc1";
		String recent = "aaa2" + FROM2 + "bbb2" + TO2 + "ccc2";
		String result = "aaa2" + FROM2 + "bbb1" + TO2 + "ccc2";

		String merged = customMerger.mergeCode(info(old), info(recent));

		Assert.assertEquals(result, merged);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowExceptionWhenPartIsNotFound() {
		String old = lines("aaa1", FROM1, "bbb1", TO1, "ccc1");
		String recent = lines("aaa2", FROM1, "bbb2", "ccc2");

		merger.mergeCode(info(old), info(recent));
	}

	private static FileInformation info(final String content) {
		return new FileInformation() {
			@Override
			public Date getLastModifiedOn() {
				return null;
			}

			@Override
			public String getFilename() {
				return null;
			}

			@Override
			public String getContent() {
				return content;
			}
		};
	}

	private static String lines(String... lines) {
		return StringUtils.join(lines, "\n");
	}

}
