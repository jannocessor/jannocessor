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

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaTypeParameterData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;

public class JavaTypeParameterBean extends JavaTypeParameterData implements
		JavaTypeParameter {

	
	private static final long serialVersionUID = 3912037783962709230L;

	public JavaTypeParameterBean(String name, List<JavaType> bounds) {
		this.setName(new NameBean(name));
		this.setBounds(children(Power.list(bounds)));

		this.setKind(JavaElementKind.TYPE_PARAMETER);
		this.setCode(New.code(JavaTypeParameter.class));
		this.setExtraCode(New.code());
	}
}
