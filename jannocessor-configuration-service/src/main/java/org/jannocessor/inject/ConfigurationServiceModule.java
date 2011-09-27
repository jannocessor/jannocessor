package org.jannocessor.inject;

import org.jannocessor.service.api.Configurator;
import org.jannocessor.service.api.PathLocator;
import org.jannocessor.service.configuration.ConfiguratorImpl;
import org.jannocessor.service.configuration.PathLocatorImpl;

import com.google.inject.AbstractModule;

public class ConfigurationServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Configurator.class).to(ConfiguratorImpl.class);
		bind(PathLocator.class).to(PathLocatorImpl.class);
	}

}
