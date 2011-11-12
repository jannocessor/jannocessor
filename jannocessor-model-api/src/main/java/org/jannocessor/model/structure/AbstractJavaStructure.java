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

package org.jannocessor.model.structure;

import org.jannocessor.annotation.Calculated;
import org.jannocessor.annotation.DomainModel;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.Name;
import org.jannocessor.model.executable.JavaMethod;
import org.jannocessor.model.type.JavaType;

@DomainModel
public interface AbstractJavaStructure extends JavaElement {

	@Override
	@Calculated
	AbstractJavaStructure copy();

	String getNesting();

	Name getQualifiedName();

	JavaType getSuperclass();

	PowerList<JavaMetadata> getMetadata();

	PowerList<JavaMetadata> getAllMetadata();

	PowerList<JavaType> getInterfaces();

	PowerList<JavaMethod> getMethods();

	PowerList<JavaNestedClass> getNestedClasses();

	PowerList<JavaNestedEnum> getNestedEnums();

	PowerList<JavaNestedInterface> getNestedInterfaces();

	PowerList<JavaNestedAnnotation> getNestedAnnotations();

	@Override
	JavaElement getParent();

}
