/**
 * Copyright 2011 jannocessor.org
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

package org.jannocessor.adapter.type;

import javax.lang.model.element.PackageElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import org.jannocessor.adapter.ElementAdapter;
import org.jannocessor.domain.type.JavaPackage;

public final class JavaPackageAdapter extends ElementAdapter implements
		JavaPackage {

	@SuppressWarnings("unused")
	private final PackageElement tpackage;

	public JavaPackageAdapter(PackageElement tpackage, Elements elementUtils,
			Types typeUtils) {
		super(tpackage, elementUtils, typeUtils);
		this.tpackage = tpackage;
	}

}
