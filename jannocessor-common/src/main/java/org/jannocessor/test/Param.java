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

package org.jannocessor.test;

import java.lang.reflect.Array;

import net.sf.twip.AutoTwip;

public class Param {

	@AutoTwip
	public static String[] identifiers() {
		return new String[] { "x", "FOO", "FooBar", "foo_bar" };
	}

	@AutoTwip
	public static Class<?>[] classes() {
		return new Class<?>[] { String.class, int.class, void.class };
	}

	@SuppressWarnings("unchecked")
	public static <T> T[][] groups(Class<T> clazz, T param1, T param2) {
		T[] group1 = (T[]) Array.newInstance(clazz, 0);

		T[] group2 = (T[]) Array.newInstance(clazz, 1);
		group2[0] = param1;

		T[] group3 = (T[]) Array.newInstance(clazz, 2);
		group3[0] = param1;
		group3[1] = param2;

		T[][] result = (T[][]) Array.newInstance(group1.getClass(), 3);
		result[0] = group1;
		result[1] = group2;
		result[2] = group3;
		return result;
	}

}