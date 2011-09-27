package org.jannocessor.inject;

import org.jannocessor.service.api.TemplateRenderer;
import org.jannocessor.service.render.VelocityTemplateRenderer;

import com.google.inject.AbstractModule;

public class TemplateServiceModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(TemplateRenderer.class).to(VelocityTemplateRenderer.class);
	}
}
