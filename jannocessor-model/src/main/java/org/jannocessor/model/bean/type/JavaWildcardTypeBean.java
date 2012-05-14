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

import org.jannocessor.data.JavaWildcardTypeData;
import org.jannocessor.model.type.JavaWildcardType;
import org.jannocessor.model.util.New;

public class JavaWildcardTypeBean extends JavaWildcardTypeData implements
		JavaWildcardType {

	
	private static final long serialVersionUID = 3874230315970645859L;

	public JavaWildcardTypeBean(Class<?> wildcardSuper, Class<?> wildcardExtends) {
		// TODO Auto-generated constructor stub
		this.setCode(New.code(JavaWildcardType.class));
		this.setExtraCode(New.code());
	}

}
