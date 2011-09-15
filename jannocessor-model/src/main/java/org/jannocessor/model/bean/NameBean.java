/**
 * Copyright 2011 jannocessor.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jannocessor.model.bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.model.Name;

public class NameBean implements Name {

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
	    throw new IllegalStateException(
		    "At least 1 part of the name must not be deleted!");
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
    public String toString() {
	return getText();
    }

    @Override
    public void assign(String name) {
	this.name = name;
    }
}
