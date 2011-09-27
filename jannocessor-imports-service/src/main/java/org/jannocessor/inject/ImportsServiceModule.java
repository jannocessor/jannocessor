package org.jannocessor.inject;

import org.jannocessor.service.api.ImportOrganizer;
import org.jannocessor.service.imports.ImportOrganizerImpl;

import com.google.inject.AbstractModule;

public class ImportsServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(ImportOrganizer.class).to(ImportOrganizerImpl.class);
	}

}
