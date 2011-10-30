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
