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
import org.jannocessor.data.JavaEnumData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.executable.JavaInstanceInit;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.executable.JavaStaticInit;
import org.jannocessor.model.modifier.EnumModifiers;
import org.jannocessor.model.structure.JavaEnum;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaNestedAnnotation;
import org.jannocessor.model.structure.JavaNestedClass;
import org.jannocessor.model.structure.JavaNestedEnum;
import org.jannocessor.model.structure.JavaNestedInterface;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaEnumConstant;
import org.jannocessor.model.variable.JavaField;

public class JavaEnumBean extends JavaEnumData implements JavaEnum {


	private static final long serialVersionUID = -194889084741369043L;

	public JavaEnumBean(EnumModifiers modifiers, String name,
			List<JavaType> interfaces, List<JavaEnumConstant> values,
			List<JavaField> fields, List<JavaConstructor> constructors,
			List<JavaMethod> methods) {
		this.setModifiers(modifiers);
		this.setName(new NameBean(name));
		this.setInterfaces(children(Power.list(interfaces)));
		this.setValues(children(Power.list(values)));
		this.setFields(children(Power.list(fields)));
		this.setConstructors(children(Power.list(constructors)));
		this.setMethods(children(Power.list(methods)));
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));
		this.setStaticInits(children(Power.emptyList(JavaStaticInit.class)));
		this.setInstanceInits(children(Power.emptyList(JavaInstanceInit.class)));
		this.setNestedClasses(children(Power.emptyList(JavaNestedClass.class)));
		this.setNestedEnums(children(Power.emptyList(JavaNestedEnum.class)));
		this.setNestedInterfaces(children(Power
				.emptyList(JavaNestedInterface.class)));
		this.setNestedAnnotations(children(Power
				.emptyList(JavaNestedAnnotation.class)));

		this.setKind(JavaElementKind.ENUM);
		this.setCode(New.code(JavaEnum.class));
		this.setExtraCode(New.code());
	}

}
