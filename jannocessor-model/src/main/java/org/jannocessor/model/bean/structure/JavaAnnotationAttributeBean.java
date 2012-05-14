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

package org.jannocessor.model.bean.structure;

import org.jannocessor.data.JavaAnnotationAttributeData;
import org.jannocessor.model.Name;
import org.jannocessor.model.structure.JavaAnnotationAttribute;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaAnnotationAttributeBean extends JavaAnnotationAttributeData
		implements JavaAnnotationAttribute {

	
	private static final long serialVersionUID = 7511359361247727478L;
	private JavaType type;
	private Name name;
	private Object defaultValue;

	public JavaAnnotationAttributeBean(JavaType type, String name,
			Object defaultValue) {
		this.type = type;
		this.name = New.name(name);
		this.defaultValue = defaultValue;
		this.setCode(New.code(JavaAnnotationAttribute.class));
		this.setExtraCode(New.code());
	}

	@Override
	public JavaType getType() {
		return this.type;
	}

	public Name getName() {
		return name;
	}

	@Override
	public Object getDefaultValue() {
		return defaultValue;
	}

}
