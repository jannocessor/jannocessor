package org.jannocessor.engine.impl;

import org.jannocessor.processor.model.Configuration;
import org.jannocessor.service.api.JannocessorInput;

public class JannocessorInputImpl implements JannocessorInput {

	private final Configuration options;

	public JannocessorInputImpl(Configuration options) {
		this.options = options;
	}

	public Configuration getOptions() {
		return options;
	}

}
