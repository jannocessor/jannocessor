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

package org.jannocessor.adapter.executable;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.util.ModelUtils;

public final class JavaStaticInitAdapter extends AbstractJavaExecutableAdapter
		implements JavaStaticInit {

	private static final long serialVersionUID = -6819739210362612616L;
	@SuppressWarnings("unused")
	private final ExecutableElement staticInit;

	public JavaStaticInitAdapter(ExecutableElement staticInit,
			Elements elementUtils, Types typeUtils) {
		super(staticInit, elementUtils, typeUtils);

		this.staticInit = staticInit;
	}

	@Override
	public Name getName() {
		return null;
	}

	@Override
	protected Class<? extends JavaStaticInit> getAdaptedInterface() {
		return JavaStaticInit.class;
	}

	@Override
	public PowerList<CodeNode> getChildren() {
		return ModelUtils.getChildren(this);
	}

	@Override
	public JavaStaticInit copy() {
		throw calculatedMethodException();
	}

}
