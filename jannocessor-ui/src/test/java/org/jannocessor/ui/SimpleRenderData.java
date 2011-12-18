package org.jannocessor.ui;

import java.util.Map;

import org.jannocessor.processor.api.CodeMerger;
import org.jannocessor.processor.api.RenderData;

public class SimpleRenderData implements RenderData {

	private final Map<String, Object> attributes;
	private final CodeMerger merger;

	public SimpleRenderData(Map<String, Object> attributes, CodeMerger merger) {
		this.attributes = attributes;
		this.merger = merger;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	@Override
	public CodeMerger getCodeMerger() {
		return merger;
	}

}
