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

package org.jannocessor.adapter;

import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.model.JavaCodeModel;
import org.jannocessor.model.code.SourceCode;
import org.jannocessor.model.util.New;

public abstract class JavaCodeModelAdapter extends CodeNodeAdapter implements
		JavaCodeModel {

	private static final long serialVersionUID = 132118813722881706L;

	public JavaCodeModelAdapter(Elements elementUtils, Types typeUtils) {
		super(elementUtils, typeUtils);
	}

	@Override
	public SourceCode getCode() {
		return New.code(getAdaptedInterface());
	}

	@Override
	public SourceCode getExtraCode() {
		return New.code();
	}

	protected abstract Class<? extends JavaCodeModel> getAdaptedInterface();

	@Override
	public JavaCodeModel copy() {
		throw calculatedMethodException();
	}

}
