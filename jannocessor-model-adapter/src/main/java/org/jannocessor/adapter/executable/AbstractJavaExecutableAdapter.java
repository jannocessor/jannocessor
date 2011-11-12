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

package org.jannocessor.adapter.executable;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.JavaElementAdapter;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.code.JavaBody;
import org.jannocessor.model.executable.AbstractJavaExecutable;
import org.jannocessor.model.structure.AbstractJavaStructure;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;

abstract class AbstractJavaExecutableAdapter extends JavaElementAdapter
		implements AbstractJavaExecutable {

	private static final long serialVersionUID = -5004287664697277125L;

	private final ExecutableElement executable;

	private final JavaBody body = New.body();

	public AbstractJavaExecutableAdapter(ExecutableElement executable,
			Elements elementUtils, Types typeUtils) {
		super(executable, elementUtils, typeUtils);
		this.executable = executable;
	}

	public PowerList<JavaTypeParameter> getTypeParameters() {
		return getElementsAdapters(executable.getTypeParameters(),
				JavaTypeParameter.class);
	}

	public JavaType getReturnType() {
		return getTypeAdapter(executable.getReturnType());
	}

	public PowerList<JavaParameter> getParameters() {
		return getElementsAdapters(executable.getParameters(),
				JavaParameter.class);
	}

	public Boolean isVarArgs() {
		return executable.isVarArgs();
	}

	public PowerList<JavaType> getThrownTypes() {
		PowerList<JavaType> adapters = Power.list();

		for (TypeMirror typeMirror : executable.getThrownTypes()) {
			adapters.add(getTypeAdapter(typeMirror));
		}

		return adapters;
	}

	@Override
	public JavaBody getBody() {
		return this.body;
	}

	@Override
	protected Class<? extends AbstractJavaExecutable> getAdaptedInterface() {
		return AbstractJavaExecutable.class;
	}

	@Override
	public AbstractJavaStructure getParent() {
		return super.retrieveParent();
	}

	@Override
	public AbstractJavaExecutable copy() {
		throw calculatedMethodException();
	}

}
