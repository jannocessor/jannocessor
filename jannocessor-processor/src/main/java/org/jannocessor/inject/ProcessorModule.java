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
