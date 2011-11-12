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

package org.jannocessor.model.bean.variable;

import org.jannocessor.data.JavaExceptionParameterData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaExceptionParameter;

public class JavaExceptionParameterBean extends JavaExceptionParameterData
		implements JavaExceptionParameter {

	
	private static final long serialVersionUID = 2637119654910165235L;

	public JavaExceptionParameterBean(JavaType type, String name) {
		this.setType(type);
		this.setName(new NameBean(name));

		this.setKind(JavaElementKind.EXCEPTION_PARAMETER);
		this.setCode(New.code(JavaExceptionParameter.class));
	}

}
