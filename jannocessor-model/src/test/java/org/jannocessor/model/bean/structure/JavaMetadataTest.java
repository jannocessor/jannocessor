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

package org.jannocessor.model.bean.structure;

import java.util.Arrays;
import java.util.Map;

import net.sf.twip.AutoTwip;
import net.sf.twip.TwiP;

import org.jannocessor.collection.Power;
import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.test.ModelParam;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaMetadataTest extends AbstractModelTest {

	@AutoTwip
	public static JavaType[] TYPES = less(ModelParam.types());

	/* **************************** TESTS ****************************** */

	@Test
	public void testCombinations(JavaType type) {
		Map<String, ? extends Object> attr = Power.map("a", 1, "b", "x");
		JavaMetadata[] instances1 = allInstances(type, attr);
		JavaMetadata[] instances2 = allInstances(type, attr);

		Assert.assertArrayEquals(instances1, instances2);

		Map<String, ? extends Object> attr2 = Power.map("a", 1, "c", "Y");
		JavaMetadata[] instances3 = allInstances(type, attr2);

		Assert.assertFalse(Arrays.equals(instances1, instances3));
	}

	private JavaMetadata[] allInstances(JavaType type,
			Map<String, ? extends Object> attributes) {

		JavaMetadata obj1 = New.metadata(type);
		checkMetadata(obj1, type, Power.map(String.class, Object.class));

		JavaMetadata obj2 = New.metadata(type, "a");
		checkMetadata(obj2, type, Power.map("value", "a"));

		JavaMetadata obj3 = New.metadata(type, "a", "b");
		checkMetadata(obj3, type, Power.map("value", Power.list("a", "b")));

		JavaMetadata obj4 = New.metadata(type, attributes);
		checkMetadata(obj4, type, attributes);

		return new JavaMetadata[] { obj1, obj2, obj3, obj4 };
	}
}
