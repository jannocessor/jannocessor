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

import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.util.New;

public final class JavaInstanceInitAdapter extends
		AbstractJavaExecutableAdapter implements JavaInstanceInit {

	@SuppressWarnings("unused")
	private final ExecutableElement instanceInit;

	public JavaInstanceInitAdapter(ExecutableElement instanceInit,
			Elements elementUtils, Types typeUtils) {
		super(instanceInit, elementUtils, typeUtils);
		this.setCode(New.code(JavaInstanceInit.class));
		this.setBody(New.body(JavaInstanceInit.class));
		this.instanceInit = instanceInit;
	}

	@Override
	public Name getName() {
		return null;
	}

}
