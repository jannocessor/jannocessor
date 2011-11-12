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
