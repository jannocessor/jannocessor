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

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaParameterData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;

public class JavaParameterBean extends JavaParameterData implements JavaParameter {

	private static final long serialVersionUID = -726399585570941549L;

	public JavaParameterBean(JavaType type, String name, boolean isFinal) {
		this.setType(type);
		this.setName(new NameBean(name));
		this.setCode(New.code(JavaParameter.class));
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));

		this.setKind(JavaElementKind.PARAMETER);
		this.setFinal(isFinal);
	}

}
