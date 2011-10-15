/**
 * Copyright 2011 Nikolche Mihajlovski
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

package org.jannocessor.service.render;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;
import org.jannocessor.collection.Power;
import org.jannocessor.collection.api.PowerMap;
import org.jannocessor.processor.model.JannocessorException;
import org.jannocessor.service.api.MultiContentSplitter;

public class TemplateHelper {

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

}
