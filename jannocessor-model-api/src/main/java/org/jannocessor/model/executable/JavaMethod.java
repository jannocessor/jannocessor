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

package org.jannocessor.model.executable;

import org.jannocessor.annotation.Calculated;
import org.jannocessor.annotation.DomainModel;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.modifier.MethodModifiers;
import org.jannocessor.model.structure.JavaMetadata;
import org.jannocessor.model.structure.JavaTypeParameter;
import org.jannocessor.model.type.JavaType;
import org.jannocessor.model.variable.JavaParameter;

@DomainModel
public interface JavaMethod extends AbstractJavaExecutable {

	@Override
	@Calculated
	JavaMethod copy();

	PowerList<JavaTypeParameter> getTypeParameters();

	JavaType getReturnType();

	PowerList<JavaParameter> getParameters();

	Boolean isVarArgs();

	PowerList<JavaType> getThrownTypes();

	MethodModifiers getModifiers();

	PowerList<JavaMetadata> getMetadata();

}
