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

package org.jannocessor.model.bean.executable;

import java.util.List;

import org.jannocessor.collection.Power;
import org.jannocessor.data.JavaMethodData;
import org.jannocessor.model.JavaElementKind;
import org.jannocessor.model.bean.NameBean;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.util.New;
import org.jannocessor.model.variable.JavaParameter;

public class JavaMethodBean extends JavaMethodData implements JavaMethod {

	
	private static final long serialVersionUID = -3450054892240456263L;

	public JavaMethodBean(MethodModifiers modifiers, JavaType returnType,
			String name, List<JavaParameter> params,
			List<JavaType> thrownTypes, List<JavaTypeParameter> typeParameters) {
		this.setBody(New.body());
		this.setModifiers(modifiers);
		this.setReturnType(returnType);
		this.setName(new NameBean(name));
		this.setParameters(children(Power.list(params)));
		this.setThrownTypes(children(Power.list(thrownTypes)));
		this.setTypeParameters(children(Power.list(typeParameters)));
		this.setMetadata(children(Power.emptyList(JavaMetadata.class)));

		this.setKind(JavaElementKind.METHOD);
		this.setCode(New.code(JavaMethod.class));
	}

}
