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

package org.jannocessor.service.render;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.jannocessor.JannocessorException;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.service.api.MultiContentSplitter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TemplateHelper {

	private Logger logger = LoggerFactory.getLogger("TEMPLATE");

	private final VelocityContext context;

	public TemplateHelper(VelocityContext context) {
		this.context = context;
	}

	public Map<String, Object> getExtra() {
		PowerMap<String, Object> map = Power.map();

		map.put("r", "\r");
		map.put("n", "\n");
		map.put("t", "\t");

		return map;
	}

	public String join(String separator, List<String> parts) {
		StringBuilder sb = new StringBuilder();
		boolean isEmpty = true;

		for (String part : parts) {
			if (!StringUtils.isEmpty(part)) {
				if (!isEmpty) {
					sb.append(separator);
				}
				sb.append(part);
				isEmpty = false;
			}
		}

		return sb.toString();
	}

	public String insight() {
		String keys = Arrays.toString(context.getKeys());
		int depth = context.getCurrentMacroCallDepth();
		String macro = context.getCurrentMacroName();
		List<?> macros = context.getMacroLibraries();
		String macroStack = Arrays.toString(context.getMacroNameStack());
		String info = "INTROSPECTION {\n  keys:%s\n  depth:%s\n  macro:%s\n  macros:%s\n  macroStack:%s\n}";
		return String.format(info, keys, depth, macro, macros, macroStack);
	}

	public String locate(String templateName) throws JannocessorException {
		return templateName + ".vm";
	}

	public String fileMark(String filename) {
		return String.format("%s %s %s", MultiContentSplitter.PREFIX, filename,
				MultiContentSplitter.SUFFIX);
	}

	public boolean isInstanceOf(Object value, String className)
			throws ClassNotFoundException {
		return Class.forName(className).isInstance(value);
	}

	public String indent(String code, String prefix) {

		StringBuilder sb = new StringBuilder();

		String[] lines = StringUtils.splitPreserveAllTokens(code, "\n");
		for (int i = 0; i < lines.length; i++) {
			String line = lines[i];

			if (!StringUtils.isWhitespace(line)) {
				line = prefix + line;
			}
			sb.append(line);

			if (i < lines.length - 1) {
				sb.append("\n");
			}
		}

		return sb.toString();
	}

	public void setAttributes(Map<String, ? extends Object> attributes) {
		for (Entry<String, ? extends Object> entry : attributes.entrySet()) {
			context.put(entry.getKey(), entry.getValue());
		}
	}

	public void removeAttributes(Map<String, ? extends Object> attributes) {
		for (String key : attributes.keySet()) {
			context.remove(key);
		}
	}

	public String info(String msg) {
		logger.info(msg);
		return "";
	}

	public String debug(String msg) {
		logger.debug(msg);
		return "";
	}

}
