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

package org.jannocessor.model.bean;

import static junit.framework.Assert.assertEquals;
import net.sf.twip.TwiP;

import org.jannocessor.model.code.bean.SourceCodeBean;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class SourceCodeTest extends AbstractModelTest {

	@Test
	public void testEquality() {
		SourceCodeBean code1 = new SourceCodeBean("a", null, null, null);
		SourceCodeBean code2 = new SourceCodeBean("a", null, null, null);

		assertEquals(code1, code2);
	}

}
