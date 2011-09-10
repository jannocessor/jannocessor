package org.jannocessor.inject;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.engine.impl.JannocessorEngineImpl;
import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.FileService;
import org.jannocessor.service.api.ImportOrganizer;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.api.PatternService;
import org.jannocessor.service.api.RuleExecutor;
import org.jannocessor.service.api.RulesGenerator;
import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.configuration.ConfiguratorImpl;
import org.jannocessor.service.configuration.PathLocatorImpl;
import org.jannocessor.service.imports.ImportOrganizerImpl;
import org.jannocessor.service.io.ConfigLoaderImpl;
import org.jannocessor.service.io.FileServiceImpl;
import org.jannocessor.service.render.VelocityTemplateRenderer;
import org.jannocessor.service.rules.PatternServiceImpl;
import org.jannocessor.service.rules.RuleExecutorImpl;
import org.jannocessor.service.rules.RulesGeneratorImpl;

import com.google.inject.AbstractModule;

public class ServicesModule extends AbstractModule {

	@Override
	protected void configure() {

		bind(ConfigLoader.class).to(ConfigLoaderImpl.class);

		bind(Configurator.class).to(ConfiguratorImpl.class);

		bind(ImportOrganizer.class).to(ImportOrganizerImpl.class);

		bind(PathLocator.class).to(PathLocatorImpl.class);

		bind(RuleExecutor.class).to(RuleExecutorImpl.class);

		bind(RulesGenerator.class).to(RulesGeneratorImpl.class);

		bind(TemplateRenderer.class).to(VelocityTemplateRenderer.class);

		bind(JannocessorEngine.class).to(JannocessorEngineImpl.class);

		bind(FileService.class).to(FileServiceImpl.class);

		bind(PatternService.class).to(PatternServiceImpl.class);

	}
}
