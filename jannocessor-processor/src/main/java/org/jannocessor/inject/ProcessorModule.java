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

package org.jannocessor.inject;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.engine.impl.JannocessorEngineImpl;
import org.jannocessor.engine.impl.JannocessorInputImpl;
import org.jannocessor.processor.model.Configuration;
import org.jannocessor.service.api.JannocessorInput;

import com.google.inject.AbstractModule;

public class ProcessorModule extends AbstractModule {

	private final Configuration options;

	public ProcessorModule(Configuration options) {
		this.options = options;
	}

	@Override
	protected void configure() {
		bind(JannocessorInput.class).toInstance(
				new JannocessorInputImpl(options));
		bind(JannocessorEngine.class).to(JannocessorEngineImpl.class);
	}

}
