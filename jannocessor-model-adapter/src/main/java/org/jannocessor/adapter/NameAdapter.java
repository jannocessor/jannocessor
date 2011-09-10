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

package org.jannocessor.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.model.Name;
import org.jannocessor.model.Text;

public class NameAdapter extends TextAdapter implements Name {

	private enum NameCase {
		CAMELCASE, UNDERSCORE
	};

	public NameAdapter(String name) {
		super(name);
	}

	private List<String> parts() {
		String name = getText();
		boolean isCamelcase = isCamelCase();

		String[] parts;
		if (isCamelcase) {
			parts = name.split("(?<!^)(?=[A-Z][^A-Z0-9])");
		} else {
			parts = name.split("_");
		}

		List<String> aaa = new ArrayList<String>();
		for (String part : parts) {
			if (isCamelcase) {
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
	public Text[] getParts() {
		List<Text> parts = new ArrayList<Text>();
		for (String part : parts()) {
			parts.add(new TextAdapter(part));
		}
		return parts.toArray(new Text[parts.size()]);
	}

	@Override
	public Name deleteParts(int... positions) {
		List<String> parts = parts();

		for (int position : positions) {
			parts.set(position, null);
		}

		for (Iterator<String> iterator = parts.iterator(); iterator.hasNext();) {
			String part = (String) iterator.next();
			if (part == null) {
				iterator.remove();
			}
		}

		if (parts.isEmpty()) {
			throw new IllegalStateException("At least 1 part of the name '"
					+ getText() + "' must not be deleted!");
		}

		String name = mergeParts(parts);
		setText(name);
		return this;
	}

	@Override
	public Name insertPart(int position, String part) {
		List<String> parts = parts();

		parts.add(position, part);

		String name = mergeParts(parts);
		setText(name);
		return this;
	}

	@Override
	public Name appendPart(String part) {
		List<String> parts = parts();

		parts.add(part);

		String name = mergeParts(parts);
		setText(name);
		return this;
	}

	@Override
	public Name replacePart(int position, String part) {
		List<String> parts = parts();

		parts.set(position, part);

		String name = mergeParts(parts);
		setText(name);
		return this;
	}

	private String mergeParts(List<String> parts) {
		String separator = isCamelCase() ? "" : "_";
		return StringUtils.join(parts, separator);
	}

	private boolean isCamelCase() {
		return getNameCase().equals(NameCase.CAMELCASE);
	}

	private NameCase getNameCase() {
		String name = getText();
		int separatorPos = name.indexOf('_');
		if (separatorPos < 0) {
			return NameCase.CAMELCASE;
		} else {
			return NameCase.UNDERSCORE;
		}
	}

	@Override
	public Name copy() {
		return new NameAdapter(getText());
	}

}
