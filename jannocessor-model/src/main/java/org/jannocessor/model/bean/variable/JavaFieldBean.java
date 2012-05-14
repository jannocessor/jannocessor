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
import org.jannocessor.data.JavaFieldData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.Name;
import org.jannocessor.model.code.JavaExpression;
import org.jannocessor.model.modifier.FieldModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;

public class JavaFieldBean extends JavaFieldData implements JavaField {

	
	private static final long serialVersionUID = 41860021002962204L;

	public JavaFieldBean(FieldModifiers modifiers, JavaType type, Name name,
			JavaExpression value) {
		this.setModifiers(modifiers);
		this.setType(type);
		this.setName(name);
		this.setValue(value);
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));

		this.setKind(JavaElementKind.FIELD);
		this.setCode(New.code(JavaField.class));
		this.setExtraCode(New.code());
	}

}
