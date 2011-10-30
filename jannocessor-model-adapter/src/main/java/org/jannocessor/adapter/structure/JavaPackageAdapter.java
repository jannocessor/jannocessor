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

package org.jannocessor.adapter.structure;

import javax.lang.model.element.PackageElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaAnnotation;
import org.jannocessor.model.structure.JavaClass;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaPackage;
import org.jannocessor.model.util.ModelUtils;
import org.jannocessor.model.util.New;

public final class JavaPackageAdapter extends JavaElementAdapter implements
		JavaPackage {

	private static final long serialVersionUID = 8508618168552956729L;

	private final PackageElement tpackage;

	public JavaPackageAdapter(PackageElement tpackage, Elements elementUtils,
			Types typeUtils) {
		super(tpackage, elementUtils, typeUtils);

		this.tpackage = tpackage;
	}

	@Override
	public Name getName() {
		return New.name(tpackage.getQualifiedName().toString());
	}

	@Override
	protected Class<? extends JavaPackage> getAdaptedInterface() {
		return JavaPackage.class;
	}

	@Override
	public PowerList<JavaInterface> getInterfaces() {
		return findChildrenByType(JavaInterface.class);
	}

	@Override
	public PowerList<JavaClass> getClasses() {
		return findChildrenByType(JavaClass.class);
	}

	@Override
	public PowerList<JavaEnum> getEnums() {
		return findChildrenByType(JavaEnum.class);
	}

	@Override
	public PowerList<JavaAnnotation> getAnnotations() {
		return findChildrenByType(JavaAnnotation.class);
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

}
