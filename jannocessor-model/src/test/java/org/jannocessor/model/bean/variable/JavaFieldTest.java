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

package org.jannocessor.model.bean.variable;

import junit.framework.Assert;
import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;
import net.sf.twip.Values;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.Code;
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
	public static FieldModifiers[] MODIF = Param.fieldModifiers();

	@AutoTwip
	public static JavaType[] TYPES = Param.types();

	@AutoTwip
	public static Class<?>[] CLASSES = Param.classes();

	@Test
	public void testFieldConstruction1(FieldModifiers modifiers, JavaType type,
			@Values("IDS") String name) {
		JavaField field = Code.field(modifiers, type, name);

		checkLonelyElement(field, name, type);
		Assert.assertEquals(modifiers, field.getModifiers());
	}

	@Test
	public void testFieldConstruction2(FieldModifiers modifiers, Class<?> type,
			@Values("IDS") String name) {
		JavaField field = Code.field(modifiers, type, name);
		checkLonelyElement(field, name, type);

		Assert.assertEquals(modifiers, field.getModifiers());
	}

}
