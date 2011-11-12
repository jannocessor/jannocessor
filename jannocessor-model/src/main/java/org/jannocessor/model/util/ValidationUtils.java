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

package org.jannocessor.model.util;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.util.Check;

public class ValidationUtils {

	public static void validate(AbstractJavaStructure model) {
		Check.argument(model.getParent() != null, "A package must be set as a parent!");

		for (JavaMethod member : model.getMethods()) {
			checkParent(model, member);
		}

		for (JavaMetadata member : model.getMetadata()) {
			checkParent(model, member);
		}
	}

	private static void checkParent(JavaCodeModel parent, JavaCodeModel child) {
		Check.notNull(parent, "Parent cannot be null!");
		Check.notNull(child, "Child cannot be null!");
		Check.state(child.getParent() == parent, "Invalid member parent! DIFF:=====\n" + parent
				+ "\n=====\n" + child + "\n=====");
	}

}
