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

	@Override
	public JavaPackage copy() {
		throw calculatedMethodException();
	}

}
