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

package org.jannocessor.service.configuration;

import org.jannocessor.engine.EngineInput;
import org.jannocessor.model.Config;
import org.jannocessor.service.api.JannocessorException;
import org.jannocessor.util.Settings;

public class EngineInputImpl implements EngineInput, Settings {

	private final Config options;

	public EngineInputImpl(Config options) {
		this.options = options;
	}

	@Override
	public String getProject() throws JannocessorException {
		//return options.getMandatoryValue("project");
		return "";
	}

}
