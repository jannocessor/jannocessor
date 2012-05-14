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

import org.jannocessor.data.JavaTypeVariableData;
import org.jannocessor.model.type.JavaTypeVariable;
import org.jannocessor.model.util.New;

public class JavaTypeVariableBean extends JavaTypeVariableData implements
		JavaTypeVariable {

	
	private static final long serialVersionUID = -8480407492208799883L;

	public JavaTypeVariableBean(Class<?> lowerBound, Class<?> upperBound) {
		// TODO Auto-generated constructor stub
		this.setCode(New.code(JavaTypeVariable.class));
		this.setExtraCode(New.code());
	}

}
