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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jannocessor.JannocessorException;
import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.RenderData;
import org.jannocessor.processor.api.RenderRegister;

public abstract class AbstractRenderRegister implements RenderRegister {

	private final List<RenderData> renderings = new ArrayList<RenderData>();

	@Override
	public void register(Map<String, Object> attributes, CodeMerger merger) {
		renderings.add(new DefaultRenderData(attributes, merger));
	}

	@Override
	public List<RenderData> getRenderings() {
		return renderings;
	}

	@Override
	public abstract void refresh() throws JannocessorException;

}
