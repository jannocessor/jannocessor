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
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.util.ModelUtils;

public final class JavaInstanceInitAdapter extends
		AbstractJavaExecutableAdapter implements JavaInstanceInit {

	private static final long serialVersionUID = -3096070487238690601L;
	@SuppressWarnings("unused")
	private final ExecutableElement instanceInit;

	public JavaInstanceInitAdapter(ExecutableElement instanceInit,
			Elements elementUtils, Types typeUtils) {
		super(instanceInit, elementUtils, typeUtils);

		this.instanceInit = instanceInit;
	}

	@Override
	public Name getName() {
		return null;
	}

	@Override
	protected Class<? extends JavaInstanceInit> getAdaptedInterface() {
		return JavaInstanceInit.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaInstanceInit copy() {
		throw calculatedMethodException();
	}

}
