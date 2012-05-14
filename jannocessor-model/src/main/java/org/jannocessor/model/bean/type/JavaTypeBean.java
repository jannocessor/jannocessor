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
		this.setExtraCode(New.code());
	}

	public JavaTypeBean(String canonicalName, JavaTypeKind kind) {
		String packageName = getPackageName(canonicalName);
		String simpleName = (packageName != null) ? canonicalName
				.substring(packageName.length() + 1) : canonicalName;

		this.setSimpleName(New.name(simpleName));
		this.setPackageName(New.name(packageName));
		this.setKind(kind);

		this.setCode(New.code(JavaType.class));
		this.setExtraCode(New.code());
	}

	public JavaTypeBean(String packageName, String simpleName, JavaTypeKind kind) {
		this.setSimpleName(New.name(simpleName));
		this.setPackageName(New.name(packageName));
		this.setKind(kind);

		this.setCode(New.code(JavaType.class));
		this.setExtraCode(New.code());
	}

	private String getPackageName(String canonicalName) {
		int pos = canonicalName.lastIndexOf('.');
		return (pos >= 0) ? canonicalName.substring(0, pos) : null;
	}
	
}
