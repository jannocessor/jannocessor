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

package org.jannocessor.context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jannocessor.JannocessorException;

public abstract class RenderRegister {

	private final List<RenderData> renderings = new ArrayList<RenderData>();

	public void register(Map<String, Object> attributes) {
		renderings.add(new RenderData(attributes));
	}

	public List<RenderData> getRenderings() {
		return renderings;
	}

	public abstract void refresh() throws JannocessorException;

}
