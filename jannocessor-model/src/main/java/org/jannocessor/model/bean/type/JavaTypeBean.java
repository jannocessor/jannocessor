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

package org.jannocessor.model.bean.type;

import org.jannocessor.data.JavaTypeData;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaTypeBean extends JavaTypeData implements JavaType {

	
	private static final long serialVersionUID = 2329697894900332732L;

	@SuppressWarnings("unused")
	private final Class<?> type;

	@SuppressWarnings("unused")
	private final Class<?>[] typeParams;

	public JavaTypeBean(Class<?> type, Class<?>[] typeParams) {
		this.type = type;
		this.typeParams = typeParams;
		this.setCode(New.code(JavaType.class));
		this.setSimpleName(New.readonlyName(type.getSimpleName()));
		this.setCanonicalName(New.readonlyName(type.getCanonicalName()));
		this.setTypeClass(type);
		this.setKind(New.typeKind(type));
	}

}
