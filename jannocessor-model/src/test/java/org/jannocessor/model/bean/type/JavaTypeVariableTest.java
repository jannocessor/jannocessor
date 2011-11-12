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

package org.jannocessor.model.bean.type;

import static org.junit.Assert.assertNotNull;
import net.sf.twip.TwiP;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.New;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaTypeVariableTest extends AbstractModelTest {

	@Test
	public void testInstantiation() {
		JavaTypeVariable typeVar = New.typeVar();
		assertNotNull(typeVar);

		JavaTypeVariable typeVarLower = New.typeVarLowerBound(String.class);
		assertNotNull(typeVarLower);

		JavaTypeVariable typeVarUpper = New.typeVarUpperBound(Integer.class);
		assertNotNull(typeVarUpper);
	}

}
