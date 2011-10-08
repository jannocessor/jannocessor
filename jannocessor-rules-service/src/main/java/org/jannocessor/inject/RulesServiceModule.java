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

import org.jannocessor.service.api.PatternService;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.rules.PatternServiceImpl;
import org.jannocessor.service.rules.RuleExecutorImpl;
import org.jannocessor.service.rules.RulesGeneratorImpl;

import com.google.inject.AbstractModule;

public class RulesServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(RuleExecutor.class).to(RuleExecutorImpl.class);
		bind(RulesGenerator.class).to(RulesGeneratorImpl.class);
		bind(PatternService.class).to(PatternServiceImpl.class);
	}

}
