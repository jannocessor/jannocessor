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

package org.jannocessor.service.imports;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.jannocessor.service.api.ImportOrganizer;

public class ImportOrganizerImpl implements ImportOrganizer {

	private static final String JAVA_LANG = "java.lang.";

	private Set<String> importedSimple = new HashSet<String>();

	private Set<String> importedFull = new HashSet<String>();

	@Override
	public String[] getTypeImports(String type) {
		List<String> imports = new ArrayList<String>();
		calculateTypeImports(type, imports);
		return imports.toArray(new String[imports.size()]);
	}

	private void calculateTypeImports(String type, List<String> imports) {
		ParsedTypeName parsedName = parseType(type);
		String simpleName = parsedName.getClassName();
		String genericType = parsedName.getGenericType();

		if (!parsedName.isSimple() && !genericType.startsWith(JAVA_LANG)) {
			if (!importedSimple.contains(simpleName)) {
				importedSimple.add(simpleName);
				importedFull.add(genericType);
				imports.add(genericType);
			}
		}

		for (String generic : parsedName.getParams()) {
			calculateTypeImports(generic, imports);
		}
	}

	@Override
	public String getTypeUsage(String type) {
		ParsedTypeName parsedName = parseType(type);
		String simpleName = parsedName.getClassName();
		String genericType = parsedName.getGenericType();

		if (!parsedName.isSimple()) {
			if (genericType.startsWith(JAVA_LANG)
					|| importedFull.contains(genericType)) {
				return simpleName + renderParams(parsedName.getParams());
			} else {
				return type + renderParams(parsedName.getParams());
			}
		} else {
			return type; // a simple type
		}
	}

	private String renderParams(List<String> params) {
		if (!params.isEmpty()) {
			StringBuilder sb = new StringBuilder();
			sb.append("<");

			for (Iterator<String> it = params.iterator(); it.hasNext();) {
				String type = (String) it.next();
				sb.append(getTypeUsage(type));

				if (it.hasNext()) {
					sb.append(",");
				}
			}

			sb.append(">");
			return sb.toString();
		} else {
			return "";
		}
	}

	private ParsedTypeName parseType(String type) {
		String regex = "^(?:([^<>]+)\\.)?([^.<>]+?)(?:\\s?<(.*)>)?$";
		Matcher matcher = Pattern.compile(regex).matcher(type);
		if (matcher.matches()) {
			List<String> params = extractParams(matcher.group(3));
			return new ParsedTypeName(matcher.group(1), matcher.group(2),
					params);
		} else {
			throw new IllegalArgumentException("Cannot parse type!");
		}
	}

	private List<String> extractParams(String params) {
		List<String> parts = new ArrayList<String>();

		if (StringUtils.isNotEmpty(params)) {

			StringBuffer sb = new StringBuffer(params);
			Pattern pattern = Pattern.compile("<[^<>]+?>");

			Matcher m = pattern.matcher(sb.toString());
			while (m.find()) {
				for (int i = m.start(); i < m.end(); i++) {
					sb.setCharAt(i, ' ');
				}
				m = pattern.matcher(sb.toString());
			}
			String projection = sb.toString();

			int from = 0;
			int pos = projection.indexOf(',');

			while (pos > 0) {
				String part = params.substring(from, pos).trim();
				parts.add(part);

				from = pos + 1;
				pos = projection.indexOf(',', pos + 1);
			}

			String part = params.substring(from).trim();
			parts.add(part);
		}

		return parts;
	}

}