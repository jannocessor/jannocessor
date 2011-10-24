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
import org.jannocessor.model.type.JavaTypeKind;
import org.jannocessor.model.util.New;

public class JavaTypeBean extends JavaTypeData implements JavaType {

	private static final long serialVersionUID = 2329697894900332732L;

	public JavaTypeBean(Class<?> type, Class<?>[] typeParams) {
		this.setSimpleName(New.name(type.getSimpleName()));
		this.setPackageName(type.getPackage() != null ? New.name(type
				.getPackage().getName()) : null);
		this.setTypeClass(type);
		this.setKind(New.typeKind(type));

		this.setCode(New.code(JavaType.class));
	}

	public JavaTypeBean(String canonicalName, JavaTypeKind kind) {
		String packageName = getPackageName(canonicalName);
		String simpleName = (packageName != null) ? canonicalName
				.substring(packageName.length() + 1) : canonicalName;

		this.setSimpleName(New.name(simpleName));
		this.setPackageName(New.name(packageName));
		this.setKind(kind);

		this.setCode(New.code(JavaType.class));
	}

	public JavaTypeBean(String packageName, String simpleName, JavaTypeKind kind) {
		this.setSimpleName(New.name(simpleName));
		this.setPackageName(New.name(packageName));
		this.setKind(kind);

		this.setCode(New.code(JavaType.class));
	}

	private String getPackageName(String canonicalName) {
		int pos = canonicalName.lastIndexOf('.');
		return (pos >= 0) ? canonicalName.substring(0, pos) : null;
	}
	
}
