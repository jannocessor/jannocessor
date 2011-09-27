package org.jannocessor.inject;

import org.jannocessor.service.api.ConfigLoader;
import org.jannocessor.service.api.FileService;
import org.jannocessor.service.io.ConfigLoaderImpl;
import org.jannocessor.service.io.FileServiceImpl;

import com.google.inject.AbstractModule;

public class IOServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ConfigLoader.class).to(ConfigLoaderImpl.class);
		bind(FileService.class).to(FileServiceImpl.class);
	}
}
