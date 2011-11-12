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

package org.jannocessor.model.util;

import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.SerializationUtils;
import org.jannocessor.collection.api.PowerList;
import org.jannocessor.model.CodeNode;
import org.jannocessor.model.JavaElement;
import org.jannocessor.model.executable.JavaConstructor;
import org.jannocessor.model.modifier.value.ConstructorModifierValue;
import org.jannocessor.model.structure.AbstractJavaClass;
import org.jannocessor.model.structure.AbstractJavaEnum;
import org.jannocessor.model.type.JavaDeclaredType;
import org.jannocessor.model.type.JavaType;

public class ModelUtils {

	public static <T> PowerList<T> parentedList(PowerList<T> list,
			final JavaElement parent) {
		ParentedListOperationListener<T> operationListener = new ParentedListOperationListener<T>(
				parent);
		list.addCollectionOperationListener(operationListener);
		for (T item : list) {
			operationListener.itemAdded(new ParentedListEvent<T>(list, item));
		}
		return list;
	}

	public static <T> PowerList<T> parentedList(PowerList<T> list, JavaType type) {
		return list;
	}

	public static String getCanonicalName(JavaType type) {
		String arguments = "";
		if (type instanceof JavaDeclaredType) {
			JavaDeclaredType declaredType = (JavaDeclaredType) type;
			PowerList<JavaType> typeArgs = declaredType.getTypeArguments();

			if (!typeArgs.isEmpty()) {
				arguments = "<";

				for (Iterator<JavaType> it = typeArgs.iterator(); it.hasNext();) {
					JavaType typeArg = it.next();
					arguments += typeArg.getCanonicalName();
					if (it.hasNext()) {
						arguments += ", ";
					}
				}

				arguments += ">";
			}
		}

		String prefix = (type.getPackageName() != null) ? type.getPackageName()
				+ "." : "";

		return prefix + type.getSimpleName() + arguments;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T copy(T model) {
		T clone = (T) SerializationUtils.clone(model);

		if (!model.equals(clone) || !clone.equals(model)) {
			throw new IllegalStateException("Couldn't create a correct copy!");
		}

		return clone;
	}

	public static Boolean isDefault(JavaConstructor constructor) {
		ConstructorModifierValue[] modifiers = constructor.getModifiers()
				.getValues();
		boolean isPublic = ArrayUtils.contains(modifiers,
				ConstructorModifierValue.PUBLIC);

		boolean isAlone = false;
		CodeNode parent = constructor.getParent();
		if (parent != null) {
			if (parent instanceof AbstractJavaClass) {
				AbstractJavaClass classs = (AbstractJavaClass) parent;
				isAlone = (classs.getConstructors().size() == 1);
			} else if (parent instanceof AbstractJavaEnum) {
				AbstractJavaEnum enumm = (AbstractJavaEnum) parent;
				isAlone = (enumm.getConstructors().size() == 1);
			}
		}

		return isPublic && isAlone && constructor.getParameters().isEmpty()
				&& constructor.getThrownTypes().isEmpty();
	}

	public static PowerList<CodeNode> getChildren(CodeNode codeNode) {
		throw new NotImplementedException("This method will be implemented soon!");
	}

}
