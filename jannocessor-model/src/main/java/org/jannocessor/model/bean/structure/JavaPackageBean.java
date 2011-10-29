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
	}
}
