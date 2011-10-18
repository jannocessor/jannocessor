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

package org.jannocessor.model.bean.type;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import net.sf.twip.TwiP;

import org.jannocessor.model.bean.AbstractModelTest;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(TwiP.class)
public class JavaDeclaredTypeTest extends AbstractModelTest {

	@Test
	public void testInstantiation() {
		JavaType elementType = New.type(List.class, String.class);
		assertNotNull(elementType);
	}

}
