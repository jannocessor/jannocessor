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
