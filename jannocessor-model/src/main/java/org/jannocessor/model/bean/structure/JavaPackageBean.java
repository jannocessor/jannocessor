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

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaPackageData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.New;

public class JavaPackageBean extends JavaPackageData implements JavaPackage {

	private static final long serialVersionUID = 7490321860868917296L;

	public JavaPackageBean(String name) {
		this.setName(New.name(name));
		this.setAnnotations(children(Power.emptyList(JavaAnnotation.class)));
		this.setClasses(children(Power.emptyList(JavaClass.class)));
		this.setEnums(children(Power.emptyList(JavaEnum.class)));
		this.setInterfaces(children(Power.emptyList(JavaInterface.class)));

		this.setKind(JavaElementKind.PACKAGE);
		this.setCode(New.code(JavaPackage.class));
		this.setExtraCode(New.code());
	}
}
