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

package org.jannocessor.model.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.jannocessor.model.Name;

public class NameBean implements Name {

	private static final long serialVersionUID = -8706143384650266668L;

	private String name;

	private enum NameCase {
		CAMELCASE, UNDERSCORE, PACKAGE
	};

	public NameBean(String name) {
		this.name = name;
	}

	private List<String> parts() {
		String name = getText();
		String[] parts;
		switch (getNameCase()) {
		case CAMELCASE:
			parts = name.split("(?<!^)(?=[A-Z][^A-Z0-9])");
			break;
		case PACKAGE:
			parts = name.split("\\.");
			break;
		case UNDERSCORE:
			parts = name.split("_");
			break;
		default:
			throw new IllegalStateException("Unknown name case!");
		}

		List<String> aaa = new ArrayList<String>();
		for (String part : parts) {
			if (getNameCase().equals(NameCase.CAMELCASE)) {
				String[] subparts = part.split("(?<=[^A-Z])(?=[A-Z])");
				for (String subpart : subparts) {
					aaa.add(subpart);
				}
			} else {
				aaa.add(part);
			}
		}

		return aaa;
	}

	@Override
	public String[] getParts() {
		List<String> parts = new ArrayList<String>();
		for (String part : parts()) {
			parts.add(part);
		}
		return parts.toArray(new String[parts.size()]);
	}

	@Override
	public Name deleteParts(int... positions) {
		List<String> parts = parts();

		translateNegativePositions(positions, parts.size());

		String deletedStart = null;
		for (int position : positions) {
			if (position == 0) {
				deletedStart = parts.get(0);
			}
			parts.set(position, null);
		}

		for (Iterator<String> iterator = parts.iterator(); iterator.hasNext();) {
			String part = (String) iterator.next();
			if (part == null) {
				iterator.remove();
			}
		}

		if (parts.isEmpty()) {
			throw new IllegalStateException("At least 1 part of the name must not be deleted!");
		}

		if (deletedStart != null && getNameCase().equals(NameCase.CAMELCASE)) {
			fixCamelCaseStart(parts, deletedStart);
		}

		String name = mergeParts(parts);
		assign(name);
		return this;
	}

	private void fixCamelCaseStart(List<String> parts, String deletedStart) {
		String start = parts.get(0);

		if (Character.isUpperCase(deletedStart.charAt(0))) {
			start = start.substring(0, 1).toUpperCase() + start.substring(1);
		} else {
			start = start.substring(0, 1).toLowerCase() + start.substring(1);
		}

		parts.set(0, start);
	}

	@Override
	public Name insertPart(int position, String part) {
		List<String> parts = parts();

		position = translateNegativePosition(position, parts.size());

		if (getNameCase().equals(NameCase.CAMELCASE) && !parts.isEmpty() && (position == 0)) {
			parts.set(0, StringUtils.capitalize(parts.get(0)));
		}

		parts.add(position, part);

		String name = mergeParts(parts);
		assign(name);
		return this;
	}

	@Override
	public Name appendPart(String part) {
		List<String> parts = parts();

		parts.add(part);

		String name = mergeParts(parts);
		assign(name);
		return this;
	}

	@Override
	public Name replacePart(int position, String part) {
		List<String> parts = parts();

		position = translateNegativePosition(position, parts.size());

		parts.set(position, part);

		String name = mergeParts(parts);
		assign(name);
		return this;
	}

	@Override
	public boolean containsParts(String... parts) {
		return parts().containsAll(Arrays.asList(parts));
	}

	private String mergeParts(List<String> parts) {
		String separator;
		switch (getNameCase()) {
		case CAMELCASE:
			separator = "";
			break;
		case PACKAGE:
			separator = ".";
			break;
		case UNDERSCORE:
			separator = "_";
			break;
		default:
			throw new IllegalStateException("Unknown name case!");
		}

		return StringUtils.join(parts, separator);
	}

	private NameCase getNameCase() {
		String name = getText();
		int separatorPos = name.indexOf('.');
		if (separatorPos > 0) {
			return NameCase.PACKAGE;
		} else {
			separatorPos = name.indexOf('_');
			if (separatorPos > 0) {
				return NameCase.UNDERSCORE;
			} else {
				return NameCase.CAMELCASE;
			}
		}
	}

	private int translateNegativePosition(int position, int length) {
		if (position < 0) {
			return length + position;
		} else {
			return position;
		}
	}

	private void translateNegativePositions(int[] positions, int length) {
		for (int i = 0; i < positions.length; i++) {
			if (positions[i] < 0) {
				positions[i] = translateNegativePosition(positions[i], length);
			}
		}
	}

	@Override
	public Name copy() {
		return new NameBean(getText());
	}

	public String getText() {
		return name;
	}

	@Override
	public String getCapitalized() {
		return StringUtils.capitalize(getText());
	}

	@Override
	public String getUncapitalized() {
		return StringUtils.uncapitalize(getText());
	}

	@Override
	public void assign(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (!(obj instanceof Name)) {
			return false;
		}
		Name other = (Name) obj;
		return new EqualsBuilder().append(getText(), other.getText()).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(getText()).toHashCode();
	}

	@Override
	public String toString() {
		return getText();
	}
}
