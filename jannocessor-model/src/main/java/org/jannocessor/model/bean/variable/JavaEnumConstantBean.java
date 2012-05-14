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

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaEnumConstantData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;

public class JavaEnumConstantBean extends JavaEnumConstantData implements JavaEnumConstant {

	private static final long serialVersionUID = -1708750074054535347L;

	public JavaEnumConstantBean(String name, List<JavaExpression> values) {
		this.setName(new NameBean(name));
		this.setValues(children(Power.list(values)));

		this.setKind(JavaElementKind.ENUM_CONSTANT);
		this.setCode(New.code(JavaEnumConstant.class));
		this.setExtraCode(New.code());
	}

}
