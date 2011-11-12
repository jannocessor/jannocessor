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

package org.jannocessor.model.bean.variable;

import junit.framework.Assert;
import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;
import org.jannocessor.test.Param;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
// FIXME: shouldn't accept non-valid java names and void types
public class JavaFieldTest extends AbstractModelTest {

	@AutoTwip
	public static String[] IDS = Param.identifiers();

	@AutoTwip
	public static FieldModifiers[] MODIF = ModelParam.fieldModifiers();

	@AutoTwip
	public static JavaType[] TYPES = ModelParam.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@Test
	public void testFieldConstruction1(FieldModifiers modifiers, JavaType type,
			@Values("IDS") String name) {
		JavaField field = New.field(modifiers, type, name);

		checkLonelyElement(field, name, type);
		Assert.assertEquals(modifiers, field.getModifiers());
	}

	@Test
	public void testFieldConstruction2(FieldModifiers modifiers, Class<?> type,
			@Values("IDS") String name) {
		JavaField field = New.field(modifiers, type, name);
		checkLonelyElement(field, name, type);

		Assert.assertEquals(modifiers, field.getModifiers());
	}

}
