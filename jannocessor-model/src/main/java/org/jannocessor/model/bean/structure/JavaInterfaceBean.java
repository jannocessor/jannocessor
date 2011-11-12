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
import org.jannocessor.data.JavaInterfaceData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.InterfaceModifiers;
import org.jannocessor.model.structure.JavaInterface;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaField;

public class JavaInterfaceBean extends JavaInterfaceData implements
		JavaInterface {


	private static final long serialVersionUID = -1718102721310923048L;

	public JavaInterfaceBean(InterfaceModifiers modifiers, String name,
			List<JavaType> superInterfaces, List<JavaField> fields,
			List<JavaMethod> methods, List<JavaTypeParameter> parameters) {
		this.setModifiers(modifiers);
		this.setName(new NameBean(name));
		this.setInterfaces(children(Power.list(superInterfaces)));
		this.setFields(children(Power.list(fields)));
		this.setMethods(children(Power.list(methods)));
		this.setTypeParameters(children(Power.list(parameters)));
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));
		this.setNestedClasses(children(Power.emptyList(JavaNestedClass.class)));
		this.setNestedEnums(children(Power.emptyList(JavaNestedEnum.class)));
		this.setNestedInterfaces(children(Power
				.emptyList(JavaNestedInterface.class)));
		this.setNestedAnnotations(children(Power
				.emptyList(JavaNestedAnnotation.class)));

		this.setKind(JavaElementKind.INTERFACE);
		this.setCode(New.code(JavaInterface.class));
	}

}
