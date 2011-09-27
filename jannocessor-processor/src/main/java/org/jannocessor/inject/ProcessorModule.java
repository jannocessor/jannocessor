package org.jannocessor.inject;

import org.jannocessor.engine.JannocessorEngine;
import org.jannocessor.engine.impl.JannocessorEngineImpl;

import com.google.inject.AbstractModule;

public class ProcessorModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(JannocessorEngine.class).to(JannocessorEngineImpl.class);
	}

}
