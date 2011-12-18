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

package org.jannocessor.processor.context;

import java.util.Map;

import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.RenderData;

public class DefaultRenderData implements RenderData {

	private final Map<String, Object> attributes;
	private final CodeMerger merger;

	public DefaultRenderData(Map<String, Object> attributes, CodeMerger merger) {
		this.attributes = attributes;
		this.merger = merger;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public CodeMerger getCodeMerger() {
		return merger;
	}

	@Override
	public String toString() {
		return "RenderData [attributes=" + attributes + "]";
	}

}
