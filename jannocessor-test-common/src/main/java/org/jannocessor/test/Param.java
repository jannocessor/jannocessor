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