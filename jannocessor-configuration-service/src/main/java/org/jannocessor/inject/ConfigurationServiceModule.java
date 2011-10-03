package org.jannocessor.inject;

import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.configuration.ConfiguratorImpl;

import com.google.inject.AbstractModule;

public class ConfigurationServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Configurator.class).to(ConfiguratorImpl.class);
	}

}
