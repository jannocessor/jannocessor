/**
 * Copyright 2011 Nikolche Mihajlovski
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
import org.jannocessor.model.util.Code;
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

		JavaMetadata obj1 = Code.metadata(type);
		checkMetadata(obj1, type, Power.map(String.class, Object.class));

		JavaMetadata obj2 = Code.metadata(type, "a");
		checkMetadata(obj2, type, Power.map("value", "a"));

		JavaMetadata obj3 = Code.metadata(type, "a", "b");
		checkMetadata(obj3, type, Power.map("value", Power.list("a", "b")));

		JavaMetadata obj4 = Code.metadata(type, attributes);
		checkMetadata(obj4, type, attributes);

		return new JavaMetadata[] { obj1, obj2, obj3, obj4 };
	}
}
