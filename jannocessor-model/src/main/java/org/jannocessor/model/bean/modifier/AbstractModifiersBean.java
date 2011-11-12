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

package org.jannocessor.model.bean.modifier;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.jannocessor.model.modifier.AbstractModifiers;
import org.jannocessor.util.TypeSpecificStyle;

public abstract class AbstractModifiersBean<T extends Enum<T>, M extends AbstractModifiers<T, M>>
		implements AbstractModifiers<T, M> {


	private static final long serialVersionUID = -5244142034285692223L;
	private T[] values;
	private final Class<? extends AbstractModifiers<T, M>> interfacee;

	public AbstractModifiersBean(T[] values,
			Class<? extends AbstractModifiers<T, M>> interfacee) {
		this.values = values;
		this.interfacee = interfacee;
	}

	@Override
	public T[] getValues() {
		return values;
	}

	@Override
	public boolean contains(M modifiers) {
		for (T modifier : modifiers.getValues()) {
			if (!ArrayUtils.contains(values, modifier)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void assign(AbstractModifiers<T, M> modifiers) {
		values = modifiers.getValues().clone();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}

		if (!interfacee.isInstance(obj)) {
			return false;
		}

		@SuppressWarnings("unchecked")
		M other = (M) obj;

		EqualsBuilder builder = new EqualsBuilder();
		return builder.append(getValues(), other.getValues()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getValues()).toHashCode();
	}

	@Override
	public String toString() {
		TypeSpecificStyle style = new TypeSpecificStyle(interfacee);
		return new ToStringBuilder(this, style).append("values",
				Arrays.toString(getValues())).toString();
	}

}
